package com.example.jobapp.company;

import org.springframework.stereotype.Service;

import java.util.List;


public interface CompanyService {

    List<Company> findAllCompanies();
    boolean updateCompany(Company company, Long id);
    void createCompany(Company company);
    Company findCompanyById(Long id);
    boolean deleteCompany(Long id);
}
