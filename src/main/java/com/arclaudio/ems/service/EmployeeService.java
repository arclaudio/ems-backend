package com.arclaudio.ems.service;

import com.arclaudio.ems.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO getEmployeeById(Long employeeId);

    List<EmployeeDTO> getEmployees();

    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO employeeDTO);

    String deleteEmployee(Long employeeId);
}
