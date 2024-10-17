package unioeste.br.contractor_api.contractedCompany.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class ContractedCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String corporateName;

    private String code;

    private String phone;

    private String email;

    private String address;
}
