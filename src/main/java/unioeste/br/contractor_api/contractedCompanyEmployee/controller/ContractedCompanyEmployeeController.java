package unioeste.br.contractor_api.contractedCompanyEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.contractedCompanyEmployee.service.ContractedCompanyEmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contracted-company-employee")
public class ContractedCompanyEmployeeController {

    @Autowired
    private ContractedCompanyEmployeeService service;

    @GetMapping
    public List<ContractedCompanyEmployee> getAllEmployees() {
        return service.findAll();
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
