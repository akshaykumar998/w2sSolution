package com.project.operationcrud.service;

import com.project.operationcrud.payload.RequestEmployeeDto;
import com.project.operationcrud.payload.ResponseEmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<ResponseEmployeeDto> getAllEmployeeDetails();
    ResponseEmployeeDto createEmployee(RequestEmployeeDto requestEmployeeDto, String currentPrincipalName);
    void deleteEmployee(long id);
    ResponseEmployeeDto updateEmpById(RequestEmployeeDto requestEmployeeDto, Long id);

    List<ResponseEmployeeDto> findEmpByUserId(String userId);
}
