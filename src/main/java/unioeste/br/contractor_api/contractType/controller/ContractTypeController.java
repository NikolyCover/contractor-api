package unioeste.br.contractor_api.contractType.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractType.model.ContractType;
import unioeste.br.contractor_api.contractType.service.ContractTypeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contract-type")
public class ContractTypeController {

    @Autowired
    private ContractTypeService service;

    @GetMapping
    public List<ContractType> getAllContractTypes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractType> getContractTypeById(@PathVariable Long id) {
        Optional<ContractType> contractType = service.findById(id);
        return contractType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractType createContractType(@RequestBody ContractType contractType) {
        return service.save(contractType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractType(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
