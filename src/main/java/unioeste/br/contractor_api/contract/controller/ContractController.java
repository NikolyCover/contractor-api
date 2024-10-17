package unioeste.br.contractor_api.contract.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contract.model.Contract;
import unioeste.br.contractor_api.contract.service.ContractService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping
    public List<Contract> getAllContracts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Optional<Contract> contract = service.findById(id);
        return contract.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Contract createContract(@RequestBody Contract contract) {
        return service.save(contract);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
