package unioeste.br.contractor_api.hiringCompany.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class HiringCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String corporateName;

    private String code;

    private String phone;

    private String email;

    private String address;

    private boolean matrix;
}
