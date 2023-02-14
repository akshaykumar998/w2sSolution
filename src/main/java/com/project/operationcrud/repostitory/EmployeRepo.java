package com.project.operationcrud.repostitory;

import com.project.operationcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByUserId(String userId);
}
