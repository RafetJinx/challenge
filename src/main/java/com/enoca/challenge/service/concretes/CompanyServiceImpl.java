package com.enoca.challenge.service.concretes;

import com.enoca.challenge.core.utilities.results.dataResult.DataResult;
import com.enoca.challenge.core.utilities.results.dataResult.error.ErrorDataResult;
import com.enoca.challenge.core.utilities.results.dataResult.success.SuccessDataResult;
import com.enoca.challenge.dao.CompanyRepository;
import com.enoca.challenge.entity.Company;
import com.enoca.challenge.service.abstracts.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;


    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public DataResult<List<Company>> findAll() {
        List<Company> companies = companyRepository.findAllByOrderByIdAsc();

        if(companies == null) {
            return new ErrorDataResult<>("Companies cannot be retrieved from the database. Commpanies list is null", null);
        }

        if(companies.isEmpty()){
            return new ErrorDataResult<>("Companies cannot be retrieved from the database. Commpanies list is empty", null);
        }

        return new SuccessDataResult<>("All companies were successfully retrieved from the database", companies);
    }

    @Override
    public DataResult<Company> findById(int id) {
        int companyCount = (int) companyRepository.count();

        if(id > companyCount){
            return new ErrorDataResult<>("Company cannot be retrieved from the database. Company id is greater than the number of companies or company deleted", null);
        }

        Company company = companyRepository.findById(id).orElse(null);

        if(company == null) {
            return new ErrorDataResult<>("Company cannot be retrieved from the database. Company is null", null);
        }

        return new SuccessDataResult<>("Company was successfully retrieved from the database", company);
    }

    @Override
    public DataResult<Company> save(Company company) {
        companyRepository.save(company);

        return new SuccessDataResult<>("Company was successfully saved to the database", company);
    }

    @Override
    public DataResult<String> deleteById(int id) {
        companyRepository.deleteById(id);

        return new SuccessDataResult<>("Company was successfully deleted from the database", null);
    }
}
