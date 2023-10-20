package com.ilacad.employeeapi.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeErrorResponse {

    private Integer status;
    private String message;
    private Long timeStamp;

}
