package unioeste.br.contractor_api.contractItem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractItem.domain.entity.ContractItem;
import unioeste.br.contractor_api.contractItem.service.ContractItemService;

import java.util.List;

@RestController
@RequestMapping("/contract-item")
@RequiredArgsConstructor
public class ContractItemController {

    private final ContractItemService contractItemService;

    @GetMapping
    public List<ContractItem> getAllContractItems() {
        return contractItemService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractItem> getContractItemById(@PathVariable Long id) {
        return contractItemService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContractItem createContractItem(@RequestBody ContractItem contractItem) {
        return contractItemService.save(contractItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContractItem(@PathVariable Long id) {
        contractItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
