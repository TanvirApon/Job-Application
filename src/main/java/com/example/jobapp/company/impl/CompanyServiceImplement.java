package com.example.jobapp.company.impl;

import com.example.jobapp.company.Company;
import com.example.jobapp.company.CompanyRepository;
import com.example.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImplement implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplement(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies(){
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id){
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            optionalCompany.get().setName(company.getName());
            optionalCompany.get().setDescription(company.getDescription());
            optionalCompany.get().setJobs(company.getJobs());
            companyRepository.save(optionalCompany.get());
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company){
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(Long id){
        try{
            companyRepository.deleteById(id);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


}
