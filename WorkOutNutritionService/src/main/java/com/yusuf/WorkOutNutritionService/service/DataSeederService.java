package com.yusuf.WorkOutNutritionService.service;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.yusuf.WorkOutNutritionService.entity.ExerciseCatalog;
import com.yusuf.WorkOutNutritionService.repository.ExerciseCatalogRepository;

@Component
public class DataSeederService implements CommandLineRunner {

    private final ExerciseCatalogRepository catalogRepository;

    public DataSeederService(ExerciseCatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        if (catalogRepository.count() == 0) {
            System.out.println("⚠️ Katalog boş! Sadeleştirilmiş yapıya uygun ev tipi hareketler ekleniyor...");

            List<ExerciseCatalog> defaultExercises = List.of(
                // Parametre Sırası: (id, name, description, targetMuscleGroup, videoUrl)

                // --- GÖĞÜS ---
                new ExerciseCatalog(null, "Yerde Dambıl Göğüs Presi", "Sırtüstü uzanın, dambılları göğüs hizasından kontrollü bir şekilde yukarı itin ve yavaşça indirin.", "GOGUS", ""),
                new ExerciseCatalog(null, "Yerde Dambıl Göğüs Açış", "Sırtüstü uzanın, kollarınızı hafifçe bükerek dambılları yanlara doğru açın ve göğsünüzde sıkıştırarak kapatın.", "GOGUS", ""),
                new ExerciseCatalog(null, "Dambıl Pullover (Göğüs Arkaya Çekiş)", "Sırtüstü uzanarak tek dambılı iki elinizle tutun, kollarınızı gergin şekilde başınızın arkasına indirip tekrar göğüs hizasına çekin.", "GOGUS", ""),
                new ExerciseCatalog(null, "Şınav", "Yüzüstü pozisyonda, eller omuz genişliğinde açıkken vücudunuzu düz tutarak aşağı inip göğsünüzden güç alarak kendinizi yukarı itin.", "GOGUS", ""),
                new ExerciseCatalog(null, "Geniş Tutuş Şınav", "Standart şınav pozisyonunda ellerinizi omuz genişliğinden daha fazla açarak göğüs kaslarınızı daha çok esnetin.", "GOGUS", ""),

                // --- SIRT ---
                new ExerciseCatalog(null, "Eğilerek Çift Dambıl Çekiş", "Belinizi düz tutarak öne eğilin, dambılları gövdenize doğru çekerek sırt kaslarınızı sıkıştırın ve yavaşça salın.", "SIRT", ""),
                new ExerciseCatalog(null, "Tek Kol Dambıl Çekiş (Sandalyeden Destekli)", "Bir elinizle ve dizinizle sandalyeden destek alarak öne eğilin, diğer elinizdeki dambılı kürek kemiğinizi sıkarak geriye çekin.", "SIRT", ""),
                new ExerciseCatalog(null, "Dambıl Ters Uçuş (Eğilerek Arkaya Açış)", "Öne eğilin, kollarınızı hafif bükük tutarak dambılları yanlara doğru açın ve arka omuz/sırt bölgenizi sıkıştırın.", "SIRT", ""),
                new ExerciseCatalog(null, "Dambıl Deadlift", "Dik durun, belinizi bükmeden kalçanızı geriye iterek dambılları diz kapağının altına kadar indirin ve tekrar doğrulun.", "SIRT", ""),
                new ExerciseCatalog(null, "Süpermen Hareketi (Yerde Uzatarak)", "Yüzüstü yere uzanın, kollarınızı ve bacaklarınızı aynı anda havaya kaldırarak sırtınızı sıkın ve yavaşça indirin.", "SIRT", ""),

                // --- OMUZ ---
                new ExerciseCatalog(null, "Ayakta Dambıl Omuz Presi", "Dik durun, dambılları omuz hizasından başınızın üzerine doğru itin ve yavaşça başlangıç noktasına indirin.", "OMUZ", ""),
                new ExerciseCatalog(null, "Oturarak Dambıl Omuz Presi", "Sırtınızı yaslayarak oturun, dambılları kulak hizasından yukarı doğru kontrollü bir şekilde presleyin.", "OMUZ", ""),
                new ExerciseCatalog(null, "Ayakta Dambıl Yana Açış", "Dik dururken dambılları yanlara doğru omuz hizasına kadar kaldırın ve yavaşça indirin. Boynunuzu kasmamaya dikkat edin.", "OMUZ", ""),
                new ExerciseCatalog(null, "Ayakta Dambıl Öne Açış", "Dambılları kollarınız düz bir şekilde öne doğru omuz hizasına kadar kaldırıp yavaşça indirin.", "OMUZ", ""),
                new ExerciseCatalog(null, "Dambıl Omuz Silkme", "Ellerinize dambılları alın, kollarınızı bükmeden omuzlarınızı kulaklarınıza doğru çekip yavaşça bırakın.", "OMUZ", ""),

                // --- ÖN KOL / PAZU ---
                new ExerciseCatalog(null, "Ayakta Dambıl Pazu Katlama", "Dik durun, dirseklerinizi gövdenize sabitleyerek dambılları sırayla veya aynı anda omuzlarınıza doğru kaldırın.", "ON_KOL", ""),
                new ExerciseCatalog(null, "Çekiç Tutuş Pazu Katlama", "Avuç içleri birbirine bakacak şekilde dambılları tutun ve dirsekleri bükerek pazu kasınızı sıkıştırın.", "ON_KOL", ""),
                new ExerciseCatalog(null, "Konsantrasyon Pazu Katlama (Dize Destekli)", "Oturarak dirseğinizi bacağınızın iç kısmına dayayın ve dambılı yavaşça yukarı doğru kıvırın.", "ON_KOL", ""),
                new ExerciseCatalog(null, "Oturarak Çift Dambıl Pazu Katlama", "Sandalyede dik oturarak iki dambılı aynı anda omuz hizasına doğru kontrollü bir şekilde kaldırın.", "ON_KOL", ""),

                // --- ARKA KOL ---
                new ExerciseCatalog(null, "Dambıl Geriye İtiş (Kickback)", "Öne eğilin, üst kolunuzu gövdenize sabitleyin ve dirseğinizi açarak dambılı geriye doğru itin.", "ARKA_KOL", ""),
                new ExerciseCatalog(null, "Baş Üstü Dambıl Arka Kol Uzatma", "Dambılı iki elinizle başınızın arkasında tutun ve dirseklerin konumunu bozmadan kollarınızı yukarı doğru dümdüz uzatın.", "ARKA_KOL", ""),
                new ExerciseCatalog(null, "Yerde Alna Dambıl İtiş", "Sırtüstü uzanın, dambılları yukarıda tutun ve dirsekleri bükerek dambılları alnınızın yanına indirip tekrar yukarı itin.", "ARKA_KOL", ""),
                new ExerciseCatalog(null, "Dar Tutuş Şınav", "Ellerinizi göğsünüzün hemen altında birbirine çok yakın konumlandırarak şınav çekin, itiş gücünü arka kollardan alın.", "ARKA_KOL", ""),
                new ExerciseCatalog(null, "Sandalye Arka Kol İtişi (Bench Dips)", "Ellerinizi arkanızdaki sandalyeye koyun, bacaklarınızı öne uzatın ve kollarınızdan güç alarak vücudunuzu aşağı indirip kaldırın.", "ARKA_KOL", ""),

                // --- BACAK ---
                new ExerciseCatalog(null, "Dambıl Çömelme (Goblet Squat)", "Tek dambılı iki elinizle göğüs hizasında tutun, sırtınızı dik tutarak kalçanızı geriye verip çömelin ve kalkın.", "BACAK", ""),
                new ExerciseCatalog(null, "Dambıl Adımlama (Lunge)", "Ellerinize dambıl alın, bir bacağınızla öne geniş bir adım atarak arka diziniz yere yaklaşana kadar çömelip başlangıca dönün.", "BACAK", ""),
                new ExerciseCatalog(null, "Tek Bacak Çömelme (Ayağı Koltuğa Koyarak)", "Arka ayağınızı arkanızdaki koltuğa veya sandalyeye dayayın, ön bacağınızdan güç alarak tek bacakla çömelip kalkın.", "BACAK", ""),
                new ExerciseCatalog(null, "Düz Bacak Dambıl Kaldırma (Stiff-Leg)", "Dizleri çok hafif bükük tutarak belinizi dik bir şekilde öne eğin, dambılları bacaklarınıza sürterek indirip arka bacağı esneterek kalkın.", "BACAK", ""),
                new ExerciseCatalog(null, "Sandalyeye Adım Atma (Step-Up)", "Dambılları elinize alın, sağlam bir sandalyeye tek bacağınızla basarak vücudunuzu yukarı çekin ve yavaşça inin.", "BACAK", ""),
                new ExerciseCatalog(null, "Dambıl Sumo Çömelme (Geniş Açılı)", "Bacaklarınızı omuz genişliğinden fazla açın, dambılı aşağıda iki elinizle tutarak çömelin ve iç bacaklarınızı sıkarak kalkın.", "BACAK", ""),

                // --- KALF ---
                new ExerciseCatalog(null, "Dambıl Ayakta Kalf Kaldırma", "Ellerinize dambıl alın, ayak parmak uçlarınızda olabildiğince yükselip baldırlarınızı sıkın ve yavaşça topuklarınızı indirin.", "KALF", ""),
                new ExerciseCatalog(null, "Tek Bacak Kalf Kaldırma (Duvara Destekli)", "Bir elinizle duvardan destek alın, diğer elinizde dambıl varken tek bacak üzerinde parmak ucunda yükselin.", "KALF", ""),

                // --- KARIN ---
                new ExerciseCatalog(null, "Mekik", "Sırtüstü uzanın, dizleri bükün, ellerinizi başınızın yanına koyun ve karın kaslarınızı sıkarak gövdenizi yukarı kaldırın.", "KARIN", ""),
                new ExerciseCatalog(null, "Düz Duruş (Plank)", "Dirseklerinizi yere koyun, vücudunuzu topuktan başa kadar düz bir çizgi halinde tutarak karın kaslarınızı sıkıp bekleyin.", "KARIN", ""),
                new ExerciseCatalog(null, "Yerde Bacak Kaldırma", "Sırtüstü yatın, bacaklarınızı birbirine bitişik ve düz tutarak havaya kaldırın ve belinizi yerden kesmeden yavaşça yere indirin.", "KARIN", ""),
                new ExerciseCatalog(null, "Dambıl Rus Bükülmesi (Russian Twist)", "Yere oturun, ayaklarınızı hafifçe havaya kaldırın ve elinizdeki dambılı gövdenizi döndürerek sağa ve sola değdirin.", "KARIN", ""),
                new ExerciseCatalog(null, "Dağ Tırmanışı (Mountain Climber)", "Şınav pozisyonu alın, dizlerinizi sırayla göğsünüze doğru hızlıca çekip bırakarak karın bölgenizi çalıştırın.", "KARIN", "")
            );

            catalogRepository.saveAll(defaultExercises);
            
            System.out.println("✅ " + defaultExercises.size() + " adet hareket güncel formata göre kataloğa eklendi!");
            
        } else {
            System.out.println("✅ Katalog zaten dolu. Veri ekleme işlemi atlandı.");
        }
    }
}