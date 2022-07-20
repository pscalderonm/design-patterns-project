package com.design.patterns.project.dto.mapper;

import com.design.patterns.project.dto.EmployeeDTO;
import com.design.patterns.project.dto.EmployeeIUDTO;
import com.design.patterns.project.models.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface EmployeeMapper {
    @Mappings({
            @Mapping(source = "dni", target = "dni"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "dateBirth", target = "dateBirth"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "vaccineStatus", target = "vaccineStatus")
    })
    EmployeeDTO toEmployeeDTO(Employee employee);
    List<EmployeeDTO> toEmployeeDTO(List<Employee> employees);

    @InheritInverseConfiguration
    Employee toEmployeeUpdate(EmployeeDTO employeeDTO);

    @InheritInverseConfiguration
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "doses", ignore = true)
    @Mapping(target = "user", ignore = true)
    Employee toEmployee(EmployeeIUDTO employeeIUDTO);
}
