package com.nick.spring.thymeleaf.controller;

import com.nick.spring.thymeleaf.entity.Employee;
import com.nick.spring.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/manager")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/list")
    public String showEmployeeList( @RequestParam(defaultValue = "1") Integer pageNo, Model model){

        //int pageNo = 2;

        Page<Employee> employeeList = employeeService.findAll(pageNo - 1);

        int totalPages = employeeList.getTotalPages();

        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());

        model.addAttribute("employeeList", employeeList);

        model.addAttribute("pageNumbers", pageNumbers);

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
