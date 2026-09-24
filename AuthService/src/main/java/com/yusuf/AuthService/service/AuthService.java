package com.yusuf.AuthService.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yusuf.AuthService.dto.UserAuthDto;
import com.yusuf.AuthService.entity.LoginRequest;
import com.yusuf.AuthService.feign_client_manager.UserClientManager;
import com.yusuf.AuthService.security.JwtUtil;
import com.yusuf.AuthService.service.interfaces.IAuthService;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

	private final UserClientManager userClientManager;
	private final JwtUtil jwtUtil;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public String login(LoginRequest request) throws Exception {
		
		UserAuthDto userAuthDto = new UserAuthDto();
		
		try {
			// 1. Feign Client ile UserService'e sor: "Bu emaile sahip biri var mı?"
			userAuthDto = userClientManager.getUserByEmailForAuth(request.getEmail()).getBody();
		
		} catch (FeignException e) {
			// EĞER BURAYA DÜŞERSE: UserService "Ben böyle birini bulamadım (404/500)" demiş demektir.
			// Feign'in o çirkin hatasını ezip kendi mesajımızı fırlatıyoruz:
			throw new Exception("Kullanıcı Bulunamadı!!");
		}
		
		// 2. Şifre Kontrolü (Sihir burada gerçekleşiyor)
        // Kullanıcının girdiği "123456" ile veritabanındaki "$2a$10..." hash kodunu karşılaştırır.
		Boolean isPasswordMatch = passwordEncoder.matches(request.getPassword(), userAuthDto.getPassword());
		
		if(!isPasswordMatch) throw new Exception("Şifre Hatalı!!");
		
		// 3. Her şey doğruysa kullanıcının ID'sini alıp biletini (JWT) bas ve teslim et
		return jwtUtil.generateToken(userAuthDto.getId().toString());
		
	}

}
