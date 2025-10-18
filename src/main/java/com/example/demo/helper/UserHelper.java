package com.example.demo.helper;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;

public class UserHelper {
    public static UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
