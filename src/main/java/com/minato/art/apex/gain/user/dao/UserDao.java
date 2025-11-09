package com.minato.art.apex.gain.user.dao;

import com.minato.art.apex.gain.common.dao.BaseDaoImpl;
import com.minato.art.apex.gain.user.domain.User;
import com.minato.art.apex.gain.user.entity.UserEntity;
import com.minato.art.apex.gain.user.mapper.UserMapper;
import com.minato.art.apex.gain.user.persistence.UserJpaPersistence;

import java.util.Optional;
import java.util.UUID;

public abstract class UserDao extends BaseDaoImpl<User, UserEntity, UUID> {


    protected UserDao(UserJpaPersistence repository, UserMapper mapper) {
        super(repository, mapper);

    }

    public abstract Optional<User> findByEmail(String email);
}
