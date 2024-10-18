package unioeste.br.contractor_api.contractedCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;
import unioeste.br.contractor_api.contractedCompany.service.ContractedCompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/contracted-company")
public class ContractedCompanyController {
    @Autowired
    private ContractedCompanyService service;

    @GetMapping
    public List<ContractedCompany> getAllCompanies() {
        return service.findAll();
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
