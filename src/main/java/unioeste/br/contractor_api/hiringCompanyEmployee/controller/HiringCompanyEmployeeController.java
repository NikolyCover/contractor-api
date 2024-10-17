package unioeste.br.contractor_api.hiringCompanyEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.hiringCompanyEmployee.service.HiringCompanyEmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hiring-company-employee")
public class HiringCompanyEmployeeController {

    @Autowired
    private HiringCompanyEmployeeService service;

    @GetMapping
    public List<HiringCompanyEmployee> getAllEmployees(@RequestParam(required = false) Long companyId) {
        if(companyId != null) {
            return service.findByCompanyId(companyId);
        }
        return service.findAll();
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
