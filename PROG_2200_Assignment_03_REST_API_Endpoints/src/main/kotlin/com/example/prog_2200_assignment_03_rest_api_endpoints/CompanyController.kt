package com.example.prog_2200_assignment_03_rest_api_endpoints

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/companies")
class CompanyController @Autowired constructor(private val companyRepository: CompanyRepository) {

    @GetMapping
    fun getAllCompanies(): List<Company> {
        return companyRepository.findAll()
    }

    @PostMapping
    fun createCompany(@RequestBody company: Company): Company {
        return companyRepository.save(company)
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable id: Long): ResponseEntity<Company> {
        return companyRepository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Long, @RequestBody companyDetails: Company): ResponseEntity<Company> {
        return companyRepository.findById(id)
            .map { company ->
                val updatedCompany = company.copy(name = companyDetails.name, address = companyDetails.address)
                ResponseEntity.ok(companyRepository.save(updatedCompany))
            }
            .orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun deleteCompany(@PathVariable id: Long): ResponseEntity<Void> {
        return companyRepository.findById(id)
            .map {
                companyRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.NO_CONTENT)
            }
            .orElse(ResponseEntity.notFound().build())
    }
}