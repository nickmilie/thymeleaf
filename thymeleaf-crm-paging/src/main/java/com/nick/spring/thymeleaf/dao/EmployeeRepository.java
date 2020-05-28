package com.nick.spring.thymeleaf.dao;

import com.nick.spring.thymeleaf.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Page<Employee> findAllByOrderByLastNameAsc(Pageable pageable);
}
