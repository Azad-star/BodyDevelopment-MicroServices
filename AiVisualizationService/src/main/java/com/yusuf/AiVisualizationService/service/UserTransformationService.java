package com.yusuf.AiVisualizationService.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import com.yusuf.AiVisualizationService.dto.AiTransformationRequestDto;
import com.yusuf.AiVisualizationService.dto.AiTransformationResponseDto;
import com.yusuf.AiVisualizationService.dto.UserDataDto;
import com.yusuf.AiVisualizationService.entity.UserTransformation;
import com.yusuf.AiVisualizationService.feign_client_manager.getUserDataForPromtClientManager;
import com.yusuf.AiVisualizationService.repository.UserTransformationRepository;
import com.yusuf.AiVisualizationService.service.interfaces.IUserTransformationService;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class UserTransformationService implements IUserTransformationService {
	
	private final UserTransformationRepository repository;
	private final getUserDataForPromtClientManager clientManager;
	
	@Value("${file.upload-dir}")
	private String uploadDir;
    
    // REPLICATE API KEY
	@Value("${replicate.api.key}")
	private String replicateApiKey;
    
    public String getUserPrompt(Long userId) throws Exception {
    	ResponseEntity<UserDataDto> response = clientManager.getUser(userId);
    	UserDataDto userData = response.getBody();
    	if(userData == null) throw new Exception("Kullanıcı verileri getirilemedi ! ");
    	return buildRealisticAiPrompt(userData);
    }

    private String convertMuscleGroupsToTurkish(UserDataDto user) {
        if (user.getTargetMuscleGroup() == null || user.getTargetMuscleGroup().isEmpty()) {
            return "";
        }

        return user.getTargetMuscleGroup()
                .stream()
                .map(group -> switch (group) {
                    case "GOGUS" -> "göğüs";
                    case "SIRT" -> "sırt";
                    case "OMUZ" -> "omuz";
                    case "ON_KOL" -> "ön kol";
                    case "ARKA_KOL" -> "arka kol";
                    case "BACAK" -> "bacak";
                    case "KALF" -> "kalf";
                    case "KARIN" -> "karın";
                    default -> "";
                })
                .filter(s -> !s.isBlank())
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    // TAMAMEN TÜRKÇE VE KULLANICI BİLGİLERİNE DAYALI DİNAMİK PROMPT
    private String buildRealisticAiPrompt(UserDataDto user) {

        String hedefKaslar = convertMuscleGroupsToTurkish(user);

        StringBuilder prompt = new StringBuilder();

        // KİMLİK KORUMA
        prompt.append("Yüklenen fotoğraftaki kişiyle tamamen aynı kişi. ");
        prompt.append("Yüz hatları, göz yapısı, burun, dudak, saç modeli, saç rengi, cilt tonu, ten rengi ve kimlik kesinlikle değişmesin. ");
        prompt.append("Aynı kişi olduğu net şekilde belli olsun. ");

        // ORTAM
        String ortam = Math.random() > 0.5
                ? "Modern ve kaliteli bir spor salonunda, profesyonel ışıklandırma altında ayakta duruyor."
                : "Doğal manzaralı açık havada, gün batımı ışığında ayakta duruyor.";

        prompt.append(ortam).append(" ");

        // FITNESS HEDEFİ
        switch (user.getFitnessGoal()) {
            case "KAS_KAZANIMI":
                prompt.append("Bu kişi disiplinli şekilde 1 ay spor ve beslenme programına uymuş. ");
                prompt.append("1 aylık gerçekçi kas gelişimi görülüyor. ");
                prompt.append("Genel vücutta hafif doğal gelişim mevcut. ");

                if (!hedefKaslar.isEmpty()) {
                    prompt.append(hedefKaslar)
                            .append(" bölgelerinde diğer bölgelere kıyasla biraz daha fazla gelişim, hafif hacim artışı ve belirginleşme bulunuyor. ");
                }

                prompt.append("Kaslar doğal görünsün, abartılı büyüme olmasın, steroid kullanmış gibi görünmesin. ");
                break;

            case "KILO_VERME":
                prompt.append("Bu kişi 1 ay boyunca düzenli spor ve sağlıklı beslenme uygulamış. ");
                prompt.append("Gerçekçi 1 aylık kilo kaybı sonucu daha ince bel, daha fit duruş ve hafif yağ kaybı görülüyor. ");

                if (!hedefKaslar.isEmpty()) {
                    prompt.append("Özellikle ")
                            .append(hedefKaslar)
                            .append(" bölgeleri daha sıkı, toparlanmış ve hafif daha belirgin görünüyor. ");
                }

                prompt.append("Yüz biraz daha keskin ve sağlıklı görünüyor ama tamamen aynı kişi kalıyor. ");
                break;

            case "FIT_KALMA":
            default:
                prompt.append("Bu kişi 1 ay boyunca düzenli egzersiz ve sağlıklı yaşam uygulamış. ");
                prompt.append("Daha enerjik, hafif daha fit, sağlıklı ve dengeli atletik görünüm oluşmuş. ");

                if (!hedefKaslar.isEmpty()) {
                    prompt.append("Özellikle ")
                            .append(hedefKaslar)
                            .append(" bölgelerinde hafif tonlanma ve sıkılaşma mevcut. ");
                }

                prompt.append("Kaslar hafif belirgin ama tamamen doğal. ");
                break;
        }

        // FOTOĞRAF KALİTESİ
        prompt.append("Ultra gerçekçi fotoğraf. ");
        prompt.append("Profesyonel kamera çekimi, doğal ışık, yüksek çözünürlük, 8k kalite, gerçek insan fotoğrafı. ");

        // NEGATIVE PROMPT
        prompt.append("[NEGATIVE PROMPT: farklı yüz, başka kişi, yüz değişimi, saç değişimi, aşırı kaslı bodybuilder görünümü, ");
        prompt.append("steroid görünümü, yapay cilt, plastik yüz, anime, çizim, 3D render, CGI, bozuk anatomi, ekstra kol, ekstra bacak, ");
        prompt.append("orantısız vücut, aşırı kilo kaybı, dramatik değişim]");

        return prompt.toString();
    }
    
    @Override
	public AiTransformationResponseDto generateImage(AiTransformationRequestDto request) throws Exception {
		AiTransformationResponseDto response = new AiTransformationResponseDto();
		
		Optional<UserTransformation> existingTransformation = repository.findByUserId(request.getUserId());
		if(existingTransformation.isPresent()) {
            repository.delete(existingTransformation.get()); 
        }
		
		MultipartFile photo = request.getCurrentPhoto();
		if(photo == null || photo.isEmpty()) throw new Exception("Fotoğraf yüklenmedi!");
		
		String originalFileName = "original_" + request.getUserId() + ".jpg";
		String originalImageName = saveFileLocally(photo, originalFileName);
		
		String aiPrompt = getUserPrompt(request.getUserId());
		Path savedFilePath = Paths.get(uploadDir).resolve(originalImageName);
        
        // Base64 dönüşümü (Replicate için)
		String base64Image = convertFileToBase64DataUri(savedFilePath);
		
		System.out.println("Görüntü Replicate.AI'a gönderiliyor, lütfen bekleyin...");
		String tempReplicateUrl = callReplicateApi(base64Image, aiPrompt);
		System.out.println("Yapay zeka fotoğrafı üretti! (Geçici Link): " + tempReplicateUrl);
		
        String generatedFileName = "generated_" + request.getUserId() + ".jpg";
        downloadImageAndSaveLocally(tempReplicateUrl, generatedFileName);
        System.out.println("Fotoğraf başarıyla bilgisayarına indirildi!");
		
		UserTransformation newTransformation = new UserTransformation();
		newTransformation.setUserId(request.getUserId());
		newTransformation.setOriginalImageUrl("/uploads/" + originalImageName);
		newTransformation.setGeneratedImageUrl("/uploads/" + generatedFileName); 
		
		UserTransformation savedTransformation = repository.save(newTransformation);
		
		response.setUserId(savedTransformation.getUserId());
		response.setOriginalImageUrl(savedTransformation.getOriginalImageUrl());
		response.setGeneratedImageUrl(savedTransformation.getGeneratedImageUrl());
		
		return response;
	}

    private void downloadImageAndSaveLocally(String imageUrl, String fileName) throws Exception {
        try {
            URI uri = new URI(imageUrl);
            Path uploadPath = Paths.get(uploadDir);
            
            if (!Files.exists(uploadPath)) Files.createDirectories(uploadPath);
            Path filePath = uploadPath.resolve(fileName);
            
            try (InputStream in = uri.toURL().openStream()) {
                Files.copy(in, filePath, StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            throw new Exception("Yapay zeka görseli indirilirken hata oluştu: " + e.getMessage());
        }
    }

 	private String convertFileToBase64DataUri(Path filePath) throws IOException {
 		byte[] fileContent = Files.readAllBytes(filePath);
 		String base64String = Base64.getEncoder().encodeToString(fileContent);
 		return "data:image/jpeg;base64," + base64String;
 	}

 	private String callReplicateApi(String base64Image, String prompt) throws Exception {
 		WebClient webClient = WebClient.builder()
 				.baseUrl("https://api.replicate.com/v1")
 				.defaultHeader(HttpHeaders.AUTHORIZATION, "Token " + replicateApiKey) 
 				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
 				.build();

 		Map<String, Object> inputParams = new HashMap<>();
 		inputParams.put("image", base64Image);
 		inputParams.put("prompt", prompt);
        
        // REPLICATE SDXL PARAMETRELERİ
 		inputParams.put("prompt_strength", 0.45); // Yüzün bozulmaması için ideal sınır
        inputParams.put("guidance_scale", 7.5);   // Prompt'a uyum sağlama baskısı

 		Map<String, Object> requestBody = new HashMap<>();
        // Replicate'in en iyi modeli olan SDXL 1.0 (image-to-image) Version ID'si
 		requestBody.put("version", "39ed52f2a78e934b3ba6e2a89f5b1c712de7dfea535525255b1aa35c5565e08b"); 
 		requestBody.put("input", inputParams);

 		JsonNode predictionResponse;
 		try {
 			predictionResponse = webClient.post()
 					.uri("/predictions")
 					.bodyValue(requestBody)
 					.retrieve()
 					.bodyToMono(JsonNode.class)
 					.block(); 
 		} catch (org.springframework.web.reactive.function.client.WebClientResponseException e) {
 			throw new Exception("Replicate API Reddetme Sebebi: " + e.getResponseBodyAsString());
 		}

 		if (predictionResponse == null || !predictionResponse.has("urls")) {
 			throw new Exception("Replicate API'ye ulaşılamadı veya geçersiz anahtar!");
 		}

 		String getUrl = predictionResponse.get("urls").get("get").asText();

 		String status = "starting";
 		JsonNode resultNode = null;
 		
 		while (!status.equals("succeeded") && !status.equals("failed") && !status.equals("canceled")) {
 			Thread.sleep(3000); 
 			
 			resultNode = webClient.get()
 					.uri(getUrl)
 					.header(HttpHeaders.AUTHORIZATION, "Token " + replicateApiKey) 
 					.retrieve()
 					.bodyToMono(JsonNode.class)
 					.block();
 			
 			if (resultNode != null && resultNode.has("status")) {
 				status = resultNode.get("status").asText();
 				System.out.println("AI İşlem Durumu: " + status + "...");
 			} else {
 				throw new Exception("API'den geçersiz yanıt alındı.");
 			}
 		}

 		if (status.equals("failed") || status.equals("canceled")) {
 			String errorLog = resultNode.has("error") ? resultNode.get("error").asText() : "Bilinmeyen hata";
 			throw new Exception("Yapay Zeka görüntüyü oluştururken hata yaşadı: " + errorLog);
 		}

 		return resultNode.get("output").get(0).asText();
 	}
	
	private String saveFileLocally(MultipartFile file, String fileName) throws IOException {
		Path uploadPath = Paths.get(uploadDir);
		if(!Files.exists(uploadPath))   Files.createDirectories(uploadPath);
		
		Path filePath = uploadPath.resolve(fileName);
		Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);		
		
		return fileName;
	}

	@Override
	public Boolean deleteImage(Long userId) {
		
		Optional<UserTransformation> transformationOpt = repository.findByUserId(userId);
		if(transformationOpt.isPresent()) {
			try {
				
				String originalFileName = "original_" + userId + ".jpg";
				String generatedFileName = "generated_" + userId + ".jpg";
				
				Path originalFilePath = Paths.get(uploadDir).resolve(originalFileName);
				Path generatedFilePath = Paths.get(uploadDir).resolve(generatedFileName);
				
				Files.deleteIfExists(originalFilePath);
				Files.deleteIfExists(generatedFilePath);
				
			} catch (IOException e) {
				System.err.println("Dosyalar Silinirken bir hata oluştu: " + e.getMessage());
			}
			
			repository.delete(transformationOpt.get());
			return true;
		}
		
		return false;
	}

}