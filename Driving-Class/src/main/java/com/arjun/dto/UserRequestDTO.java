package com.arjun.dto;

import com.arjun.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String scheduledTime;
    private String progress;
    private Role role;
}

