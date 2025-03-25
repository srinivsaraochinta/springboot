package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeePojo;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
    
    public EmployeePojo findEmployee(Long id) {
    	Optional<Employee> employeeOptional = null;
    	EmployeePojo employeePojo = null;
    	try {
    	employeeOptional = employeeRepository.findById(id);
    	employeePojo = new EmployeePojo();
    	if(!employeeOptional.isEmpty()) {
    		employeePojo.setId(employeeOptional.get().getId());
    		employeePojo.setName(employeeOptional.get().getName());
    		employeePojo.setDepartment(employeeOptional.get().getDepartment());
    		employeePojo.setSalary(employeeOptional.get().getSalary());
    	}
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return employeePojo;    	
    }
}
