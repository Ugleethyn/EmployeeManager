package tech.getarrays.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "employee")
public class Employee extends BaseEntity implements Serializable {

    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "e_mail", nullable = false)
    private String email;
    @Column(name = "job_title", nullable = false)
    private String jobTitle;
    @Column(name = "phone", nullable = false)
    private String phone;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "employee_code", nullable = false, unique = true, updatable = false)
    private String employeeCode;

}
