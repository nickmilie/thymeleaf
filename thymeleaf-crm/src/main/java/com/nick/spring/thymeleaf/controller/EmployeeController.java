package com.nick.spring.thymeleaf.controller;

import com.nick.spring.thymeleaf.entity.Employee;
import com.nick.spring.thymeleaf.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String showEmployeeList(Model model){

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employeeList", employeeList);

        return "employees/employee-list";
    }

    @GetMapping("/addForm")
    public String addForm(Model model){

        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/updateForm")
    public String updateForm(@RequestParam("employeeId") int id, Model model){

        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employees/employee-form";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.save(employee);

        return "redirect:/manager/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){

        employeeService.deleteById(id);

        return "redirect:/manager/list";
    }



}
