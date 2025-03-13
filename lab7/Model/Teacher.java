package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotEmpty(message = "The id cannot be Empty")
    @Size(min= 10)
    private String id;
@NotEmpty(message = "The name cannot be Empty")
    @Pattern(regexp = ".*[a-zA-Z]")
    @Size(min=4,max = 10)
private String name;
@NotEmpty(message = "The email cannot be Empty")
@Email
    private String email;
@NotEmpty(message = "The password cannot be Empty")
@Pattern(regexp = "(?=.*.*)(?=.*[a-zA-Z].*)(?=.*[!#$%&?].*).{8,20}")
    private String password;
@NotNull(message = "The years of Experience cannot be null")
    @Positive
    private int yearsOfExperience;
@NotNull(message = "The salary cannot be null")
    @Positive
    private double salary;


}
