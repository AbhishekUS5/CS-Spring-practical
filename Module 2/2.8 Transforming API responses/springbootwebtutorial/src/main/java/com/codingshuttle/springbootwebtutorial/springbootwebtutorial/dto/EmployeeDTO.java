package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.annotation.EmployeeRoleValidation;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message="Name of the employee cannot be empty")
    @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3,10]")
    private String name;

    @Email(message = "Email should be valid email")
    private String email;

    @NotNull(message = "Age cannot be blank")
    @Max(value = 80, message="Age cannot be greater than 80")
    @Min(value = 18, message= "Age cannot be less then 18")
    private Integer age;

    @NotBlank(message = "Role of the employee cannot be blank")
    //@Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be ADMIN or USER")
    @EmployeeRoleValidation
    private String role; // admin or user

    @PastOrPresent(message = "DateOfJoining field in employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message= "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull()
    @Positive(message = "salary of employee should be positive")
    @Digits(integer = 6,fraction = 2, message = "The salary can be in the form XXXX.YY")
    @DecimalMin(value="100.10")
    @DecimalMax(value="1000000.99")
    private Double salary;
}
