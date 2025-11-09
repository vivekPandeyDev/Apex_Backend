package com.minato.art.apex.gain.user.dao;

import com.minato.art.apex.gain.user.domain.User;
import com.minato.art.apex.gain.user.mapper.UserMapper;
import com.minato.art.apex.gain.user.persistence.UserJpaPersistence;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDaoImpl extends UserDao {
    private final UserJpaPersistence userPersistence;

    protected UserDaoImpl(UserJpaPersistence repository, UserMapper mapper) {
        super(repository, mapper);
        this.userPersistence = repository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userPersistence.findByEmail(email).map(mapper::toDomain);
    }
}
