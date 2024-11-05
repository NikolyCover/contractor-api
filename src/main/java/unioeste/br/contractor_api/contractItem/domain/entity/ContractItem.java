package unioeste.br.contractor_api.contractItem.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contract.domain.entity.Contract;
import unioeste.br.contractor_api.contractType.model.ContractType;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ContractItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ContractItemType type;

    private LocalDate scheduledDate;

    private LocalDate finishedDate;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = true)
    @JsonBackReference
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "contract_type_id", nullable = true)
    private ContractType contractType;

    public String getTypeAsString() {
        return switch (type) {
            case DELIVERY -> "Entrega";
            case SERVICE -> "Serviço";
        };
    }
}
