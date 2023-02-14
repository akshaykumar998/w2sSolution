package com.project.operationcrud.service;

import com.project.operationcrud.entity.Employee;
import com.project.operationcrud.exceptions.ResourceNotFoundException;
import com.project.operationcrud.mapping.EmployeeMapping;
import com.project.operationcrud.payload.RequestEmployeeDto;
import com.project.operationcrud.payload.ResponseEmployeeDto;
import com.project.operationcrud.repostitory.EmployeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeRepo employeRepo;

    public EmployeeServiceImpl(EmployeRepo employeRepo) {
        this.employeRepo = employeRepo;
    }

    @Override
    public List<ResponseEmployeeDto> getAllEmployeeDetails() {
        List<Employee> allEmployee = employeRepo.findAll();
        return allEmployee.stream().map(EmployeeMapping :: maptoDto).collect(Collectors.toList());
    }

    @Override
    public ResponseEmployeeDto createEmployee(RequestEmployeeDto requestEmployeeDto, String currentPrincipalName) {
        Employee employee = EmployeeMapping.mapToEntity(requestEmployeeDto);
        employee.setUserId(currentPrincipalName);
        Employee save = employeRepo.save(employee);
        return EmployeeMapping.maptoDto(save);
    }

    @Override
    public void deleteEmployee(long id) {
        Employee employee = employeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employeRepo.delete(employee);
    }

    @Override
    public ResponseEmployeeDto updateEmpById(RequestEmployeeDto requestEmployeeDto, Long id) {
        Employee employee = employeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        employee.setName(requestEmployeeDto.getName());
        employee.setDepartment(requestEmployeeDto.getDepartment());
        employee.setEmail(requestEmployeeDto.getEmail());
        employee.setMobile(requestEmployeeDto.getMobile());

        Employee updatedEmployee= employeRepo.save(employee);

        return EmployeeMapping.maptoDto(updatedEmployee);
    }

    @Override
    public List<ResponseEmployeeDto> findEmpByUserId(String userId) {
        List<Employee> employee = employeRepo.findByUserId(userId);
        return employee.stream().map(EmployeeMapping :: maptoDto).collect(Collectors.toList());
    }

}
