package com.example.ankit.mod2.controllers;

import com.example.ankit.mod2.entities.EmployeeEntity;
import com.example.ankit.mod2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @GetMapping(path="/getSecretMessage")
      public String getSecretMessage(){
          return "Secret Message: hello";
     }
     private final EmployeeRepository employeeRepository;

     public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/id/{employeeId}")
    public EmployeeEntity getEmployeeByID(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required=false) Integer age, @RequestParam(required=false) String name){
        return employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity addNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }
}
