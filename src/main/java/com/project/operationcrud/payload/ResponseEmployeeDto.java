package com.project.operationcrud.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseEmployeeDto {
    private Long id;
    private String name;
    private String department;
    private String email;
    private String mobile;
    private String userId;
}
