package unioeste.br.contractor_api.hiringCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unioeste.br.contractor_api.hiringCompany.model.HiringCompany;

@Repository
public interface HiringCompanyRepository extends JpaRepository<HiringCompany, Long> {
}
