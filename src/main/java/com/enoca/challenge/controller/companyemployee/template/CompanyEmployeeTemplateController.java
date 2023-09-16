package com.enoca.challenge.controller.companyemployee.template;

import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.service.abstracts.CompanyEmployeeService;
import com.enoca.challenge.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/companyemployees")
public class CompanyEmployeeTemplateController {

    private CompanyEmployeeService companyEmployeeService;

    @Autowired
    public CompanyEmployeeTemplateController(CompanyEmployeeService companyEmployeeService) {
        this.companyEmployeeService = companyEmployeeService;
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @RequestParam("companyId") int companyId) {
        companyEmployeeService.saveWithCompany(employee, companyId);

        return "redirect:/employees/list";
    }
}
