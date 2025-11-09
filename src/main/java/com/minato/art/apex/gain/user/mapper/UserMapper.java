package com.minato.art.apex.gain.user.mapper;

import com.minato.art.apex.gain.user.domain.User;
import com.minato.art.apex.gain.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}