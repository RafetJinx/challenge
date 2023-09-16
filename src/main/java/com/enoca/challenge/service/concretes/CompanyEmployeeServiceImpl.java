package com.enoca.challenge.service.concretes;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.core.utilities.results.dataResult.error.ErrorDataResult;
import com.enoca.challenge.core.utilities.results.dataResult.success.SuccessDataResult;
import com.enoca.challenge.dao.CompanyRepository;
import com.enoca.challenge.dao.EmployeeRepository;
import com.enoca.challenge.entity.Company;
import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.service.abstracts.CompanyEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyEmployeeServiceImpl implements CompanyEmployeeService {

    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public CompanyEmployeeServiceImpl(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DataResult<Employee> saveWithCompany(Employee employee, int companyId) {
        // Veritabanından companyId'ye göre ilgili şirketi çekin
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if (!companyOptional.isPresent()) {
            return new ErrorDataResult<>("Company with ID " + companyId + " not found.", null);
        }

        Company company = companyOptional.get();

        // Employee nesnesine seçilen şirketi atayın
        employee.setCompany(company);

        // Employee nesnesini kaydedin
        employeeRepository.save(employee);

        return new SuccessDataResult<>("Employee was successfully saved to the database with Company ID " + companyId, employee);
    }

}
