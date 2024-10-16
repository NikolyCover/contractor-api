package unioeste.br.contractor_api.contractedCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;

@Repository
public interface ContractedCompanyRepository extends JpaRepository<ContractedCompany, Long> {
}
