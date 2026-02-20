package space.gmarqueszx.picpay_simplificado.dto.response;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import space.gmarqueszx.picpay_simplificado.model.ClienteModel;

import java.math.BigDecimal;

public class TransferenciaResponse {
    private Long id;
    private BigDecimal valor;
    private ClienteResponse remetente;
    private ClienteResponse destinatario;
}
