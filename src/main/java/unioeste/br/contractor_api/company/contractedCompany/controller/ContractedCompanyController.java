package unioeste.br.contractor_api.company.contractedCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.company.contractedCompany.domain.entity.ContractedCompany;
import unioeste.br.contractor_api.company.contractedCompany.service.ContractedCompanyService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/contracted-company")
public class ContractedCompanyController {
    @Autowired
    private ContractedCompanyService service;

    @GetMapping
    public Page<ContractedCompany> getAllCompanies(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractedCompany> getCompanyById(@PathVariable Long id) {
        Optional<ContractedCompany> company = service.findById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractedCompany createCompany(@RequestBody ContractedCompany company) {
        return service.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContractedCompany> updateCompany(@PathVariable Long id, @RequestBody ContractedCompany companyDetails) {
        Optional<ContractedCompany> updatedCompany = service.update(id, companyDetails);
        return updatedCompany.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
