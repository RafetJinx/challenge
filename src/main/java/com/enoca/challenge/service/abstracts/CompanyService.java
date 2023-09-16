package com.enoca.challenge.service.abstracts;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.entity.Company;

import java.util.List;

public interface CompanyService {
    DataResult<List<Company>> findAll();

    DataResult<Company> findById(int theId);

    DataResult<Company> save(Company company);

    DataResult<String> deleteById(int id);
}
