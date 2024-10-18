package unioeste.br.contractor_api.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contract.domain.entity.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
