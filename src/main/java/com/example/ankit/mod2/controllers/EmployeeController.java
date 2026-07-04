package com.example.ankit.mod2.controllers;

import com.example.ankit.mod2.dto.EmployeeDTO;
import com.example.ankit.mod2.entities.EmployeeEntity;
import com.example.ankit.mod2.repositories.EmployeeRepository;
import com.example.ankit.mod2.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {


//    @GetMapping(path="/getSecretMessage")
//      public String getSecretMessage(){
//          return "Secret Message: hello";
//     }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/id/{employeeId}")
    public EmployeeDTO getEmployeeByID(@PathVariable Long employeeId) {
        return employeeService.getEmployeeByID(employeeId);
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required=false) Integer age, @RequestParam(required=false) String name){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO addNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.addNewEmployee(inputEmployee);
    }
    @PutMapping
    public String updateEmployeeById(){
        return "Hello from PUT";
    }
}
