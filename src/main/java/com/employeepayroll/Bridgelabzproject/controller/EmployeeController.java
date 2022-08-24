package com.employeepayroll.Bridgelabzproject.controller;

import com.employeepayroll.Bridgelabzproject.Utility.Response;
import com.employeepayroll.Bridgelabzproject.dto.Employeedto;
import com.employeepayroll.Bridgelabzproject.model.Employee;
import com.employeepayroll.Bridgelabzproject.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
Controller class to manage the Api Calls
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/add")
    public Response add(@RequestBody Employeedto employeedto) {
        return employeeService.saveEmployee(employeedto);
    }

    @GetMapping("/get/")
    public Employee getId(@RequestParam Integer id) {
        return employeeService.get(id);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getallemployee();
    }

    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Integer id) {
        return employeeService.get(id);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.delete(id);
        return "deleted Employee with id " + id;
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Employeedto employeedto, @PathVariable Integer id) {
        employeeService.updateEmployee(employeedto, id);
        return "updated sucessfully";
    }
}
