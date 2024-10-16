package unioeste.br.contractor_api.contractType.model;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contractItem.model.ContractItem;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ContractType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String contractObjective;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_type_id")
    private List<ContractItem> contractItems;
}
