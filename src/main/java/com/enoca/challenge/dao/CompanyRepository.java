package com.enoca.challenge.dao;

import com.enoca.challenge.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
    public List<Company> findAllByOrderByIdAsc();
}
