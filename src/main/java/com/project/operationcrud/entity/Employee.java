package com.project.operationcrud.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private Long id;
    @Column(name = "e_name", nullable = false)
    private String name;
    @Column(name = "e_email", nullable = false, unique = true)
    private String email;
    @Column(name = "e_mobile", nullable = false, unique = true)
    private String mobile;
}
