package com.project.operationcrud.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestEmployeeDto {
    private Long id;
    private String name;
    private String email;
    private String mobile;
}
