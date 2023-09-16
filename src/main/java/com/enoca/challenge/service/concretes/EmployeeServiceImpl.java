package com.enoca.challenge.service.concretes;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.core.utilities.results.dataResult.error.ErrorDataResult;
import com.enoca.challenge.core.utilities.results.dataResult.success.SuccessDataResult;
import com.enoca.challenge.dao.EmployeeRepository;
import com.enoca.challenge.entity.Employee;
import com.enoca.challenge.service.abstracts.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public DataResult<List<Employee>> findAll() {
        List<Employee> employees = employeeRepository.findAllByOrderByIdAsc();

        if(employees == null) {
            return new ErrorDataResult<>("Employees cannot be retrieved from the database. Employees list is null", null);
        }

        if(employees.isEmpty()){
            return new ErrorDataResult<>("Employees cannot be retrieved from the database. Employees list is empty", null);
        }

        return new SuccessDataResult<>("All employees were successfully retrieved from the database", employees);
    }

    @Override
    public DataResult<Employee> findById(int id) {
        int employeeCount = (int) employeeRepository.count();

        if(id > employeeCount){
            return new ErrorDataResult<>("Employee cannot be retrieved from the database. Employee id is greater than the number of employees or employee deleted", null);
        }

        Optional<Employee> employee = employeeRepository.findById(id);

        if(employee == null) {
            return new ErrorDataResult<>("Employee cannot be retrieved from the database. Employee is null", null);
        }

        return new SuccessDataResult<>("Employee was successfully retrieved from the database", employee);
    }

    @Override
    public DataResult<Employee> save(Employee employee) {
        employeeRepository.save(employee);

        return new SuccessDataResult<>("Employee was successfully saved to the database", employee);
    }

    @Override
    public DataResult<String> deleteById(int id) {
        employeeRepository.deleteById(id);

        return new SuccessDataResult<>("Employee was successfully deleted from the database", null);
    }
}
