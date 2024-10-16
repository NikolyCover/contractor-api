package unioeste.br.contractor_api.contractedCompanyEmployee.model;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ContractedCompanyEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String code;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private ContractedCompany company;

    private boolean isLegalRepresentative;
}
