package com.arclaudio.ems.controller;

import com.arclaudio.ems.dto.EmployeeDTO;
import com.arclaudio.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok((employeeDTO));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> employees = employeeService.getEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("{employeeId}/update")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long employeeId,
                                                      @RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(employeeId, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("{employeeId}/delete")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }

}
