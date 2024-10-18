package unioeste.br.contractor_api.contractItem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unioeste.br.contractor_api.contractItem.domain.entity.ContractItem;
import unioeste.br.contractor_api.contractItem.service.ContractItemService;

@CrossOrigin
@RestController
@RequestMapping("/contract-item")
@RequiredArgsConstructor
public class ContractItemController {

    private final ContractItemService contractItemService;

    @GetMapping
    public Page<ContractItem> getAllContractItems(Pageable pageable) {
        return contractItemService.findAll(pageable);
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
