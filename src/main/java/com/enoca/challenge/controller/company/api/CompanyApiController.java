package com.enoca.challenge.controller.company.api;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.entity.Company;
import com.enoca.challenge.service.abstracts.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class CompanyApiController {
    private CompanyService companyService;

    @Autowired
    public CompanyApiController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(value = "/all")
    public DataResult<List<Company>> findAll(){
        return companyService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DataResult<Company> findById(@PathVariable Integer id){
        return companyService.findById(id);
    }

    @PostMapping(value = "/save")
    public DataResult<Company> save(@RequestBody Company company){
        return companyService.save(company);
    }

    @DeleteMapping(value = "/{id}")
    public DataResult<String> deleteById(@PathVariable Integer id){
        return companyService.deleteById(id);
    }
}
