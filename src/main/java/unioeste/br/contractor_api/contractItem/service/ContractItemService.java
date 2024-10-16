package unioeste.br.contractor_api.contractItem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contractItem.model.ContractItem;
import unioeste.br.contractor_api.contractItem.repository.ContractItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractItemService {

    private final ContractItemRepository contractItemRepository;

    public List<ContractItem> getAllContractItems() {
        return contractItemRepository.findAll();
    }

    public Optional<ContractItem> getContractItemById(Long id) {
        return contractItemRepository.findById(id);
    }

    public ContractItem createContractItem(ContractItem contractItem) {
        return contractItemRepository.save(contractItem);
    }

    public void deleteContractItem(Long id) {
        contractItemRepository.deleteById(id);
    }
}
