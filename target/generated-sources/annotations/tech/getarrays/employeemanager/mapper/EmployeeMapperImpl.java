package tech.getarrays.employeemanager.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import tech.getarrays.employeemanager.dto.EmployeeGetDto;
import tech.getarrays.employeemanager.dto.EmployeeReturnDto;
import tech.getarrays.employeemanager.model.Employee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-16T18:10:42+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class EmployeeMapperImpl extends EmployeeMapper {

    @Override
    public List<EmployeeReturnDto> mapList(List<Employee> employeeList) {
        if ( employeeList == null ) {
            return null;
        }

        List<EmployeeReturnDto> list = new ArrayList<EmployeeReturnDto>( employeeList.size() );
        for ( Employee employee : employeeList ) {
            list.add( toDto( employee ) );
        }

        return list;
    }

    @Override
    public EmployeeReturnDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeReturnDto employeeReturnDto = new EmployeeReturnDto();

        employeeReturnDto.setId( employee.getId() );
        employeeReturnDto.setFullName( employee.getFullName() );
        employeeReturnDto.setEmail( employee.getEmail() );
        employeeReturnDto.setJobTitle( employee.getJobTitle() );
        employeeReturnDto.setPhone( employee.getPhone() );
        employeeReturnDto.setImagePath( employee.getImagePath() );
        employeeReturnDto.setEmployeeCode( employee.getEmployeeCode() );

        return employeeReturnDto;
    }

    @Override
    public Employee fromGetDto(EmployeeGetDto employeeGetDto) {
        if ( employeeGetDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setFullName( employeeGetDto.getFullName() );
        employee.setEmail( employeeGetDto.getEmail() );
        employee.setJobTitle( employeeGetDto.getJobTitle() );
        employee.setPhone( employeeGetDto.getPhone() );
        employee.setImagePath( employeeGetDto.getImagePath() );

        return employee;
    }

    @Override
    public Employee FromDtoFromReturnDto(EmployeeReturnDto returnDto) {
        if ( returnDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( returnDto.getId() );
        employee.setFullName( returnDto.getFullName() );
        employee.setEmail( returnDto.getEmail() );
        employee.setJobTitle( returnDto.getJobTitle() );
        employee.setPhone( returnDto.getPhone() );
        employee.setImagePath( returnDto.getImagePath() );
        employee.setEmployeeCode( returnDto.getEmployeeCode() );

        return employee;
    }
}
