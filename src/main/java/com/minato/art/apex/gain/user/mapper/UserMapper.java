package com.minato.art.apex.gain.user.mapper;

import com.minato.art.apex.gain.common.mapper.DomainMapper;
import com.minato.art.apex.gain.user.domain.User;
import com.minato.art.apex.gain.user.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends DomainMapper<User,UserEntity> {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toDomain(UserEntity entity);

    UserEntity toEntity(User domain);
}