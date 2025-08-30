package com.example.jobapp.company;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Find All The Company
    @GetMapping("/company")
    public List<Company> getAllCompanies(){
        return  companyService.findAllCompanies();
    }

    //Find Company By Id
    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
       Company company = companyService.findCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Edit Company Details
    @PutMapping("/company/{id}")
    public ResponseEntity<String> getCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(company,id);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }

    // Add Company Details
    @PostMapping("/company")
    public ResponseEntity<String> addCompany(@RequestBody Company company){
         companyService.createCompany(company);
         return new ResponseEntity<>("Company created successfully", HttpStatus.OK);
    }

    // Delete Company Details
    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean deletedId = companyService.deleteCompany(id);
        if(deletedId){
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
        }
    }

}
