package unioeste.br.contractor_api.company.hiringCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unioeste.br.contractor_api.company.hiringCompany.domain.entity.HiringCompany;

@Repository
public interface HiringCompanyRepository extends JpaRepository<HiringCompany, Long> {
}
