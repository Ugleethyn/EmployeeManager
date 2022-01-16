package tech.getarrays.employeemanager.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeReturnDto {

    private Long id;
    private String fullName;
    private String email;
    private String jobTitle;
    private String phone;
    private String employeeCode;
    private String imagePath;

}
