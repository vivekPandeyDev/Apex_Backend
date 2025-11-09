package com.minato.art.apex.gain.user.persistence;

import com.minato.art.apex.gain.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaPersistence extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
