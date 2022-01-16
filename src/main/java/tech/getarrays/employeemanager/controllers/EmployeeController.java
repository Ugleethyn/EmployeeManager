package tech.getarrays.employeemanager.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.dto.EmployeeGetDto;
import tech.getarrays.employeemanager.dto.EmployeeReturnDto;
import tech.getarrays.employeemanager.mapper.EmployeeMapper;
import tech.getarrays.employeemanager.services.interfaces.EmployeeService;

import java.util.List;

@CrossOrigin(origins = "${host.cross.origin}")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;


    @GetMapping("/findAll")
    public ResponseEntity<List<EmployeeReturnDto>> findAllEmployees() {
        return new ResponseEntity<>(employeeMapper.mapList(employeeService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/find/{employeeId}")
    public ResponseEntity<EmployeeReturnDto> findEmployeeById(@PathVariable("employeeId") Long id) {
        return new ResponseEntity<>(employeeMapper.toDto(employeeService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeReturnDto> createEmployee(@Validated @RequestBody EmployeeGetDto employeeGetDto) {
        return new ResponseEntity<>(employeeMapper.toDto(employeeService.saveEmployee(employeeMapper.fromGetDto(employeeGetDto))), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<EmployeeReturnDto> updateEmployee(@Validated @RequestBody EmployeeReturnDto employeeReturnDto) {
        return new ResponseEntity<>(employeeMapper.toDto(employeeService.updateEmployee(employeeMapper.FromDtoFromReturnDto(employeeReturnDto))), HttpStatus.OK);
    }

    @DeleteMapping("delete/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
