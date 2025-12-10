package com.uhihi.instagram.service;

import com.uhihi.instagram.dto.LoginRequest;
import com.uhihi.instagram.dto.LoginResponse;
import com.uhihi.instagram.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> user.getPassword().equals(request.getPassword()))
                .map(user -> LoginResponse.builder()
                        .success(true)
                        .message("로그인 성공!")
                        .username(user.getUsername())
                        .build())
                .orElse(LoginResponse.builder()
                        .success(false)
                        .message("아이디 또는 비밀번호가 올바르지 않습니다.")
                        .build());
    }
}