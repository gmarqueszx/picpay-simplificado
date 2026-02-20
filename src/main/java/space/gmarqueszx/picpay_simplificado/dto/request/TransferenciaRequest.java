package space.gmarqueszx.picpay_simplificado.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import space.gmarqueszx.picpay_simplificado.dto.response.ClienteResponse;

import java.math.BigDecimal;

public class TransferenciaRequest {
    @Positive
    private BigDecimal valor;

    @NotNull
    private Long remetente;

    @NotNull
    private Long destinatario;
}
