package unioeste.br.contractor_api.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unioeste.br.contractor_api.contract.domain.entity.Contract;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    List<Contract> findContractByContractedCompanyId(Long contractedCompanyId);
    List<Contract> findContractBySubsidiaryCompanyId(Long subsidiaryCompanyId);
}
