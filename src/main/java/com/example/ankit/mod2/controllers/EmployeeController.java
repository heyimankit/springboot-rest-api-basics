package com.example.ankit.mod2.controllers;

import com.example.ankit.mod2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getSecretMessage(){
//        return "Secret Message: hello";
//    }
    @GetMapping(path= "/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Ankit","ankit@gmail.com",21, LocalDate.of(2026,06,20), true);
    }
    @GetMapping
    public String getAllEmployees(@RequestParam(required=false) Integer age,@RequestParam(required=false) String name){
        return "HI, my name is " +name+ " and age is "+age;
    }
    @PostMapping
    public EmployeeDTO addNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(100L);
        return inputEmployee;
    }
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }
}
