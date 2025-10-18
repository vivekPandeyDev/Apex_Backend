package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.helper.UserHelper;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = Arrays.asList(
                new User(1L, "Amit Kumar", "amit@example.com"),
                new User(2L, "Nikhita Sharma", "nikhita@example.com")
        );

        return users.stream()
                .map(UserHelper::convertToDTO)
                .collect(Collectors.toList());
    }
}
