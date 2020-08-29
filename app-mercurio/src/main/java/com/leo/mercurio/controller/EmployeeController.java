package com.leo.mercurio.controller;

import com.leo.mercurio.exception.ResourceNotFoundException;
import com.leo.mercurio.model.Employee;
import com.leo.mercurio.repository.EmployeeRepository;
import com.leo.mercurio.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//http://localhost:8080/api/v1/index
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    /**
     * Busca todos registros
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    /**
     * Busca registro por Id
     */
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById
            (@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException{
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found for this id ::"));
        return ResponseEntity.ok().body(employee);
    }

    /**
     * Insere registro*
     */
     @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
         employee.setId((sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME)));
         return employeeRepository.save(employee);
     }

    @PutMapping("/employees/{id}")
    public ResponseEntity < Employee > updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                      @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/employees/{id}")
    public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map< String, Boolean > response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @RequestMapping("/index")
    public String index(){
         return "Leonardo";
    }
}
