package tech.getarrays.employeemanager.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.EmployeeNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repositories.EmployeeRepository;
import tech.getarrays.employeemanager.services.interfaces.EmployeeService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty())
            throw new EmployeeNotFoundException("There's no employees yet");
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("There's no employee with that ID"));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Employee saveEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Employee updateEmployee(Employee employee) {
        if (employee.getEmployeeCode() == null || employee.getId() == null)
            throw new EmployeeNotFoundException("There's no employees yet");
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteEmployee(Long id) {
        if (employeeRepository.deleteByIdIn(new Long[]{id}) == 0)
            throw new EmployeeNotFoundException("This employee does not exists");
    }

}
