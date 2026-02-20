package space.gmarqueszx.picpay_simplificado.dto.response;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import space.gmarqueszx.picpay_simplificado.model.TipoCliente;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ClienteResponse {
    private Long id;
    private String nome;
    private String sobrenome;
    private String documento;
    private String email;
//    private String senha;
    private TipoCliente tipoCliente;
    private BigDecimal saldo;
    private OffsetDateTime dataCriacao;
    private OffsetDateTime dataAtualizacao;
}
