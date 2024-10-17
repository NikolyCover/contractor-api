package unioeste.br.contractor_api.installment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import unioeste.br.contractor_api.contract.model.Contract;

import java.time.LocalDate;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    private LocalDate scheduledPaymentDate;

    private LocalDate paymentDate;

    private String paymentReceiptURL;

    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    @JsonBackReference
    private Contract contract;
}
