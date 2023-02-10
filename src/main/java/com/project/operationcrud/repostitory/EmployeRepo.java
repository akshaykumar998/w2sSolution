package com.project.operationcrud.repostitory;

import com.project.operationcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepo extends JpaRepository<Employee, Long> {
}
