package unioeste.br.contractor_api.company.contractedCompany.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.company.base.domain.entity.Company;

@Entity
@Getter @Setter
public class ContractedCompany extends Company {

    @Override
    public String toString() {
        return super.toString();
    }
}
