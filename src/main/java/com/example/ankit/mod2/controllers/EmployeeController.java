package com.example.ankit.mod2.controllers;

import com.example.ankit.mod2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping(path="/getSecretMessage")
//    public String getSecretMessage(){
//        return "Secret Message: hellllooo";
//    }
    @GetMapping(path= "/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId){
        return new EmployeeDTO(employeeId,"Ankit","ankit@gmail.com",27, LocalDate.of(2026,07,25), true);
    }
    @GetMapping
    public String getAllEmployees(@RequestParam Integer age,@RequestParam String name){
        return "HI, my name is " +name+ " and age is "+age;
    }

}
