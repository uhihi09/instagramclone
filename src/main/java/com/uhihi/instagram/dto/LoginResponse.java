package com.uhihi.instagram.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private boolean success;
    private String message;
    private String username;
}