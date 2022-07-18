package com.design.patterns.project.dto.mapper;

import com.design.patterns.project.dto.UserDTO;
import com.design.patterns.project.dto.UserIUDTO;
import com.design.patterns.project.models.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {RoleMapper.class})
public interface UserMapper {


    @Mappings({
            @Mapping(source = "username", target = "username"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "role", target = "roleDTO")
    })
    UserDTO toUserDTO(User user);
    List<UserDTO> toUsersDTO(List<User> users);

    @InheritInverseConfiguration
    User toUserUpdate(UserDTO userDTO);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", ignore = true)
    User toUser(UserIUDTO userDTO);
}
