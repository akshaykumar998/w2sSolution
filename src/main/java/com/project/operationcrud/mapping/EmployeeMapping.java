package com.project.operationcrud.mapping;

import com.project.operationcrud.entity.Employee;
import com.project.operationcrud.payload.RequestEmployeeDto;
import com.project.operationcrud.payload.ResponseEmployeeDto;

public class EmployeeMapping {
    public static Employee mapToEntity(RequestEmployeeDto requestEmployeeDto){
        return Employee.builder()
                .name(requestEmployeeDto.getName())
                .email(requestEmployeeDto.getEmail())
                .mobile(requestEmployeeDto.getMobile())
                .build();
    }

    public static ResponseEmployeeDto maptoDto(Employee employee) {
        return ResponseEmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .mobile(employee.getMobile())
                .build();
    }
}
