package com.enoca.challenge.service.abstracts;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.entity.Employee;

import java.util.List;

public interface EmployeeService {
    DataResult<List<Employee>> findAll();

    DataResult<Employee> findById(int theId);

    DataResult<Employee> save(Employee employee);

    DataResult<String> deleteById(int id);
}
