package com.nick.spring.thymeleaf.service;



import com.nick.spring.thymeleaf.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    public Page<Employee> findAll(int pageNo);

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
