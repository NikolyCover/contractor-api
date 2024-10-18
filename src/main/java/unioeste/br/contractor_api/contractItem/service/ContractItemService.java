package unioeste.br.contractor_api.contractItem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unioeste.br.contractor_api.contract.domain.entity.Contract;
import unioeste.br.contractor_api.contractItem.domain.dto.ContractItemFormDTO;
import unioeste.br.contractor_api.contractItem.domain.entity.ContractItem;
import unioeste.br.contractor_api.contractItem.repository.ContractItemRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractItemService {

    private final ContractItemRepository contractItemRepository;

    public List<ContractItem> findAll() {
        return contractItemRepository.findAll();
    }

    public Optional<ContractItem> getById(Long id) {
        return contractItemRepository.findById(id);
    }

    public ContractItem save(ContractItem contractItem) {
        return contractItemRepository.save(contractItem);
    }

    public void deleteById(Long id) {
        contractItemRepository.deleteById(id);
    }

    public void createContractContractItems(List<ContractItemFormDTO> contractItems, Contract contract) {
        for (ContractItemFormDTO itemDTO : contractItems) {
            ContractItem item = new ContractItem();
            item.setName(itemDTO.getName());
            item.setType(itemDTO.getType());
            item.setScheduledDate(itemDTO.getScheduledDate());
            item.setContract(contract);
            save(item);
        }
    }

}
