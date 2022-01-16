package tech.getarrays.employeemanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarrays.employeemanager.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    int deleteByIdIn(Long[] id);

}
