package unioeste.br.contractor_api.contractItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contractItem.model.ContractItem;

public interface ContractItemRepository extends JpaRepository<ContractItem, Long> {
}