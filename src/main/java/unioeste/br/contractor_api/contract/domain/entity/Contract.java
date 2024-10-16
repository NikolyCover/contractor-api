package unioeste.br.contractor_api.contract.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contractItem.domain.entity.ContractItem;
import unioeste.br.contractor_api.contractType.model.ContractType;
import unioeste.br.contractor_api.contractedCompanyEmployee.model.ContractedCompanyEmployee;
import unioeste.br.contractor_api.hiringCompanyEmployee.model.HiringCompanyEmployee;
import unioeste.br.contractor_api.installment.model.Installment;
import unioeste.br.contractor_api.paymentMethod.model.PaymentMethod;
import unioeste.br.contractor_api.contractedCompany.model.ContractedCompany;
import unioeste.br.contractor_api.hiringCompany.model.HiringCompany;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "contract_type_id", nullable = true)
    private ContractType contractType;

    private String contractObjective;

    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    private Double contractedValue;

    @ManyToOne
    @JoinColumn(name = "payment_method_id", nullable = false)
    private PaymentMethod paymentMethod;

    private String executionLocal;

    private Double latitude;

    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "subsidiary_company_id", nullable = false)
    private HiringCompany subsidiaryCompany;

    @ManyToOne
    @JoinColumn(name = "contract_manager_id", nullable = false)
    private HiringCompanyEmployee contractManager;

    @ManyToOne
    @JoinColumn(name = "contracted_company_id", nullable = false)
    private ContractedCompany contractedCompany;

    @ManyToOne
    @JoinColumn(name = "legal_representative_id", nullable = false)
    private ContractedCompanyEmployee legalRepresentative;

    @Enumerated(EnumType.STRING)
    private Status status = Status.UNDER_CONTRACT;

    private Double financialProgress = 0.0;

    @OneToMany(mappedBy = "contract")
    private List<Installment> installments;

    @OneToMany(mappedBy = "contract")
    private List<ContractItem> contractItems;
}
