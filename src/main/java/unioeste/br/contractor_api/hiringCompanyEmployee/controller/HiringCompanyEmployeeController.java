package unioeste.br.contractor_api.hiringCompanyEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.hiringCompanyEmployee.service.HiringCompanyEmployeeService;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("hiring-company-employee")
public class HiringCompanyEmployeeController {

    @Autowired
    private HiringCompanyEmployeeService service;

    @GetMapping
    public Page<HiringCompanyEmployee> getAllEmployees(Pageable pageable, @RequestParam(required = false) Long companyId) {
        if(companyId != null) {
            return service.findByCompanyId(companyId, pageable);
        }
        return service.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HiringCompanyEmployee> getEmployeeById(@PathVariable Long id) {
        Optional<HiringCompanyEmployee> employee = service.findById(id);
        return employee.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public HiringCompanyEmployee createEmployee(@RequestBody HiringCompanyEmployee employee) {
        return service.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
