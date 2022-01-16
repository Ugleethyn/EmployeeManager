package tech.getarrays.employeemanager.mapper;


import tech.getarrays.employeemanager.dto.EmployeeGetDto;
import tech.getarrays.employeemanager.dto.EmployeeReturnDto;
import tech.getarrays.employeemanager.model.Employee;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EmployeeMapper {

    public static EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    public abstract List<EmployeeReturnDto> mapList(List<Employee> employeeList);

    @Mappings({
            @Mapping(target = "id",source = "id"),
            @Mapping(target = "fullName",source = "fullName"),
            @Mapping(target = "email",source = "email"),
            @Mapping(target = "jobTitle",source = "jobTitle"),
            @Mapping(target = "phone",source = "phone"),
            @Mapping(target = "imagePath",source = "imagePath"),
            @Mapping(target = "employeeCode",source = "employeeCode")
    })
    public abstract EmployeeReturnDto toDto (Employee employee);

    @Mappings({
            @Mapping(target = "fullName",source = "fullName"),
            @Mapping(target = "email",source = "email"),
            @Mapping(target = "jobTitle",source = "jobTitle"),
            @Mapping(target = "phone",source = "phone"),
            @Mapping(target = "imagePath",source = "imagePath"),
    })

    public abstract Employee fromGetDto (EmployeeGetDto employeeGetDto);

    @InheritInverseConfiguration(name = "toDto")
    public abstract Employee FromDtoFromReturnDto (EmployeeReturnDto returnDto);
}
