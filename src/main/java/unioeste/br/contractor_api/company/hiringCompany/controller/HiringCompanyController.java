package unioeste.br.contractor_api.company.hiringCompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.company.hiringCompany.domain.entity.HiringCompany;
import unioeste.br.contractor_api.company.hiringCompany.service.HiringCompanyService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/hiring-company")
public class HiringCompanyController {
    @Autowired
    private HiringCompanyService service;

    @GetMapping
    public Page<HiringCompany> getAllCompanies(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HiringCompany> getCompanyById(@PathVariable Long id) {
        Optional<HiringCompany> company = service.findById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public HiringCompany createCompany(@RequestBody HiringCompany company) {
        return service.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HiringCompany> updateCompany(@PathVariable Long id, @RequestBody HiringCompany companyDetails) {
        Optional<HiringCompany> updatedCompany = service.update(id, companyDetails);
        return updatedCompany.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        service.deleteHiringCompany(id);
        return ResponseEntity.noContent().build();
    }
}
