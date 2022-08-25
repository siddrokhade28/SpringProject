package com.employeepayroll.Bridgelabzproject.controller;

import com.employeepayroll.Bridgelabzproject.Security.MyUserDetailsService;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthRequest;
import com.employeepayroll.Bridgelabzproject.Util.Authenticator.AuthResponse;
import com.employeepayroll.Bridgelabzproject.Util.JwtUtil;
import com.employeepayroll.Bridgelabzproject.Utility.Response;
import com.employeepayroll.Bridgelabzproject.dto.Employeedto;
import com.employeepayroll.Bridgelabzproject.model.Employee;
import com.employeepayroll.Bridgelabzproject.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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


    //To add Data to the repository
    @PostMapping("/add")
    public Response add(@RequestBody Employeedto employeedto) {
        return employeeService.saveEmployee(employeedto);
    }

    //To fetch Data with Respect to ID using Request Param
    @GetMapping("/get/")
    public Employee getId(@RequestParam Integer id) {
        return employeeService.get(id);
    }

    //to fetch All Data
    @GetMapping("/getAll")
    public List<Employee> getAll() {
        return employeeService.getallemployee();
    }

    //To fetch Data with Respect to ID using Path vaiable
    @GetMapping("/get/{id}")
    public Employee get(@PathVariable Integer id) {
        return employeeService.get(id);
    }


    @DeleteMapping("/delete/{id}")
    public Response delete(@PathVariable Integer id) {

        return employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Response update(@RequestBody Employeedto employeedto, @PathVariable Integer id) {
        employeeService.updateEmployee(employeedto, id);
        return employeeService.updateEmployee(employeedto, id);
    }
}
