package unioeste.br.contractor_api.contractedCompanyEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.contractedCompanyEmployee.service.ContractedCompanyEmployeeService;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/contracted-company-employee")
public class ContractedCompanyEmployeeController {

    @Autowired
    private ContractedCompanyEmployeeService service;

    @GetMapping
    public Page<ContractedCompanyEmployee> getAllEmployees(Pageable pageable, @RequestParam(required = false) Long companyId ) {
        if(companyId != null) {
            return service.findByCompanyId(companyId, pageable);
        }

        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractedCompanyEmployee> getEmployeeById(@PathVariable Long id) {
        Optional<ContractedCompanyEmployee> employee = service.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractedCompanyEmployee createEmployee(@RequestBody ContractedCompanyEmployee employee) {
        return service.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
