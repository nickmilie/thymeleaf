package com.nick.spring.thymeleaf.service;

import com.nick.spring.thymeleaf.dao.EmployeeRepository;
import com.nick.spring.thymeleaf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Almost every comment here it is usage of DaoHibernate or DaoJPA,
// But in last example I use Sparing Data JPA
// It's some sort of Dao generator instead of write Dao manually developer could use this technology
// This technology use Transactional included in Dao I suppose,
// that's why we don't need here Transactional to every method

@Service
public class EmployeeServiceImplementation implements EmployeeService {

/*
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImplementation(@Qualifier("JPAImplementation") EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
*/

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
//    @Transactional
    public List<Employee> findAll() {
//        return employeeRepository.findAll();
        return employeeRepository.findAllByOrderByLastNameAsc();

    }

    @Override
//    @Transactional
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;

        if(result.isPresent()){
            employee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return employee;
//        return employeeRepository.findById(id);
    }

    @Override
//    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
