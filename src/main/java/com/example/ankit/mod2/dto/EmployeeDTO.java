package com.example.ankit.mod2.dto;

import com.example.ankit.mod2.annotations.EmployeeRoleValidation;
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

    @NotNull(message = "Required field in Employees: name")
    @Size(min=3, max=10, message = "No. of characters in name should be in the range: [3,10]")
    private String name;

    @NotBlank(message = "Email of the employee cannot be blank")
    @Email(message = "Email should be a valid email.")
    private String email;

    @Max(value = 80, message = "Age of the employee must not be greater than 80")
    @Min(value=18, message = "Age of the employee must be greater than 18")
    private Integer age;

    @NotBlank(message = "Role of the Employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of employee can either be USER or ADMIN")
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Salary of employee should be not null")
    @Positive(message = "Salary of employee should be positive")
    @Digits(integer = 5, fraction = 2,message = "The salary can be in the form XXXXX.YY")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

}
