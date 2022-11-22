package com.example.Rabota.Controller;


import com.example.Rabota.Models.Employee;
import com.example.Rabota.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/")
public String GetRab(Model model)
    {
        Iterable<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees",employees);
        return "Main";
    }
    @GetMapping("/Add/Employee")
    public String GetAddEmployee(Model model)
    {
        return "Add-Employee";
    }
    @PostMapping("/Add/Employee")
    public String blogPostAdd(@RequestParam(value="lastname") String lastname,
                              @RequestParam(value ="name" ) String name,
                              @RequestParam(value = "maiddlename") String middlename,
                              @RequestParam(value ="birthday" ) Date birthday,
                              @RequestParam(value = "expetienxs") int expetienxs,
                              Model model)
    {
        Employee employee = new Employee(lastname,name,middlename, birthday,expetienxs);
        employeeRepository.save(employee);
        return "redirect:/";
    }


    @GetMapping( path = "/Search/Employee")
    public String blogFilter(Model model)
    {
        return "Search-Employee";
    }

    @PostMapping("/Search/Employee-result")
    public String blogResult(@RequestParam String lastname, Model model)
    {
        List<Employee> emp = employeeRepository.findByLastname(lastname);
        model.addAttribute("result", emp);
        return "Search-Employee";
    }
    @PostMapping("/Search/Employee")
    public String simpleSearch(@RequestParam String lastname, Model model)
    {
        List<Employee> emp = employeeRepository.findByLastnameContains(lastname);
        model.addAttribute("result", emp);
        return "Search-Employee";
    }


}
