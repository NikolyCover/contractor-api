package unioeste.br.contractor_api.company.base.domain.entity;
import lombok.*;
import jakarta.persistence.*;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String corporateName;

    private String code;

    private String phone;

    private String email;

    private String address;

    @Override
    public String toString() {
        return String.format(
                "ID: %d\n" +
                        "Nome: %s\n" +
                        "Razão social: %s\n" +
                        "CNPJ: %s\n" +
                        "Telefone: %s\n" +
                        "Email: %s\n" +
                        "Endereço: %s",
                id,
                name,
                corporateName,
                code,
                phone,
                email,
                address
        );
    }

}
