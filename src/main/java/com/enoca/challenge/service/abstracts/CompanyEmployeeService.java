package com.enoca.challenge.service.abstracts;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.entity.Employee;

public interface CompanyEmployeeService {
    DataResult<Employee> saveWithCompany(Employee employee, int companyId);
}
