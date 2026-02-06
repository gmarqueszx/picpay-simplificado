package space.gmarqueszx.picpay_simplificado.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "transferencia")
public class TransferenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Positive
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    private ClienteModel remetente;

    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    private ClienteModel destinatario;
}
