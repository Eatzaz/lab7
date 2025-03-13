package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.rmi.MarshalException;

@Data
@AllArgsConstructor
public class Student {
    @NotEmpty(message = "The id cannot be Empty")
    @Size(min= 10)
    private String id;
    @NotEmpty(message = "The name cannot be Empty")
    @Pattern(regexp = ".*[a-zA-Z]")
    @Size(min= 4, max = 10)
    private String name;
    @NotEmpty(message = "The Email cannot be Empty")
    @Email
    private String email;
    @NotEmpty(message = "The Password cannot be Empty")
    @Pattern(regexp = "(?=.*.*)(?=.*[a-zA-Z].*)(?=.*[!#$%&?].*).{8,20}")
    private String password;
    @NotNull(message = "The Age cannot be null")
    @Positive
    private int age;
    @NotNull(message = "The Age cannot be null")
    private double GPA;
}
