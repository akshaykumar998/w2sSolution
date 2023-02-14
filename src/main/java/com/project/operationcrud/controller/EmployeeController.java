package com.project.operationcrud.controller;

import com.project.operationcrud.payload.RequestEmployeeDto;
import com.project.operationcrud.payload.ResponseEmployeeDto;
import com.project.operationcrud.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseEmployeeDto>> getAllEmp(@RequestParam String userId){
        System.out.println(userId);
        List<ResponseEmployeeDto> allEmployeeDetails = employeeService.getAllEmployeeDetails();
        return new ResponseEntity<>(allEmployeeDetails, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseEmployeeDto> createEmployee(@RequestBody RequestEmployeeDto requestEmployeeDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        ResponseEmployeeDto employee = employeeService.createEmployee(requestEmployeeDto, currentPrincipalName);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ResponseEmployeeDto> getEmployeeById(@PathVariable(name = "id") long id){
//        ResponseEmployeeDto empById = employeeService.findEmpById(id);
//        return new ResponseEntity<>(empById, HttpStatus.FOUND);
//    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ResponseEmployeeDto>> getEmployeeByUserId(@PathVariable(name = "userId") String userId){
        List<ResponseEmployeeDto> empById = employeeService.findEmpByUserId(userId);
        return new ResponseEntity<>(empById, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> removeEmployee(@PathVariable(name = "id") long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee details has been deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseEmployeeDto>  updateEmployee(@RequestBody RequestEmployeeDto requestEmployeeDto, @PathVariable(name = "id") Long id){
        ResponseEmployeeDto employeeDto = employeeService.updateEmpById(requestEmployeeDto, id);
        return new ResponseEntity<>(employeeDto,HttpStatus.CREATED);
    }

}

