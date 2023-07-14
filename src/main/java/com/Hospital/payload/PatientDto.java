package com.Hospital.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PatientDto {

    private long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Age cannot be empty")
    private int age;

    @NotEmpty(message = "Room Number should be assigned")
    private long room;

    @NotEmpty(message = "Expenses cannot be empty")
    private long expenses;

    @NotEmpty(message = "Doctor Name is missing")
    private String doctor_name;

    @NotEmpty(message = "Please enter the date")
    private String admit_date;

    @NotEmpty(message = "Status cannot be empty")
    private String status;
}
