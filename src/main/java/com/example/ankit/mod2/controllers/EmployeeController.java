package com.example.ankit.mod2.controllers;

import com.example.ankit.mod2.dto.EmployeeDTO;
import com.example.ankit.mod2.entities.EmployeeEntity;
import com.example.ankit.mod2.repositories.EmployeeRepository;
import com.example.ankit.mod2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required=false) Integer age, @RequestParam(required=false) String name){
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){
        EmployeeDTO savedEmployee = employeeService.addNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId){
        Boolean gotDeleted= employeeService.deleteEmployeeById(employeeId);
        if(gotDeleted)
            return ResponseEntity.ok(true);
        return  ResponseEntity.notFound().build();
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                 @PathVariable Long employeeId){
        EmployeeDTO employeeDTO=employeeService.updatePartialEmployeeById(employeeId,updates);
        if(employeeDTO==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }
}
