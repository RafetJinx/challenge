package com.enoca.challenge.controller.employee.template;

import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeTemplateController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeTemplateController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll().getData();

        // add tp the spring model
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        // create model attribute to bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        // get the employee form the service
        Employee employee = employeeService.findById(id).getData();

        // set employee in the model to prepopulate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save the employee
        employeeService.save(employee);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        // delete the employee
        employeeService.deleteById(id);

        // redirect to /employees/list
        return "redirect:/employees/list";
    }
}
