package com.design.patterns.project.dto.mapper;

import com.design.patterns.project.dto.RoleDTO;
import com.design.patterns.project.models.Role;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mappings({
            @Mapping(source = "role", target = "name"),
            @Mapping(source = "description", target = "description")
    })
    RoleDTO toRoleDTO(Role role);
    List<RoleDTO> toRolesDTO(List<Role> roles);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    Role toRole(RoleDTO role);
}
