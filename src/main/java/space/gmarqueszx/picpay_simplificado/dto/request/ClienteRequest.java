package space.gmarqueszx.picpay_simplificado.dto.request;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import space.gmarqueszx.picpay_simplificado.model.TipoCliente;
import space.gmarqueszx.picpay_simplificado.validation.DocumentoPorTipo;

@Getter
@Setter
@DocumentoPorTipo
public class ClienteRequest {
    private String nome;

    private String sobrenome;

    private String documento;

    @Email
    private String email;

//    private String senha;

    private TipoCliente tipoCliente;
}
