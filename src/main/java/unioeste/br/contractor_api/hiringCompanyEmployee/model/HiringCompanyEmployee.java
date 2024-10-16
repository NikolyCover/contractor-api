package unioeste.br.contractor_api.hiringCompanyEmployee.model;

import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.hiringCompany.model.HiringCompany;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class HiringCompanyEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String code;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private HiringCompany company;

    private boolean isProjectManager;
}
