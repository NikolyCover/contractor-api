package unioeste.br.contractor_api.contractType.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contractType.model.ContractType;

public interface ContractTypeRepository extends JpaRepository<ContractType, Long> {
}
