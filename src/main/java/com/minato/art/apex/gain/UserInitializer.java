package com.minato.art.apex.gain;


import com.minato.art.apex.gain.user.domain.User;
import com.minato.art.apex.gain.user.mapper.UserMapper;
import com.minato.art.apex.gain.user.persistence.UserJpaPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

import static com.minato.art.apex.gain.user.mapper.UserMapper.INSTANCE;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class UserInitializer {

    private final UserJpaPersistence userRepository;

    @Bean
    public ApplicationRunner initUser() {
        return args -> {
            String email = "test@example.com";

            userRepository.findByEmail(email).ifPresentOrElse(
                    user -> log.info("User already exists: {}", user.getEmail()),
                    () -> {
                        var newUser = new User();
                        newUser.setEmail(email);
                        newUser.setPasswordHash("hashed_password_here"); // Replace with proper hash
                        newUser.setFirstName("John");
                        newUser.setLastName("Doe");
                        newUser.setPhone("1234567890");
                        newUser.setDateOfBirth(LocalDate.of(1990, 1, 1));
                        newUser.setGender("Male");
                        newUser.setStatus("ACTIVE");

                        var entity = INSTANCE.toEntity(newUser);
                        userRepository.save(entity);
                        log.info("Saved new user: {}", entity.getEmail());
                    }
            );
        };
    }
}
