package space.gmarqueszx.picpay_simplificado.validation;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.usertype.UserType;
import space.gmarqueszx.picpay_simplificado.dto.request.ClienteRequest;
import space.gmarqueszx.picpay_simplificado.model.TipoCliente;

public class ClienteDocumentoValidator implements ConstraintValidator<DocumentoPorTipo,
        ClienteRequest> {
    @Override
    public boolean isValid(ClienteRequest request, ConstraintValidatorContext context) {
        if (request == null || request.getDocumento() == null || request.getTipoCliente() == null) {
            return true;
        }

        String doc = request.getDocumento().replaceAll("\\D", "");

        if (request.getTipoCliente() == TipoCliente.PESSOA_FISICA) {
            return validarCPF(doc);
        } else {
            return validarCNPJ(doc);
        }
    }

    private boolean validarCPF(String cpf) {
        try {
            new CPFValidator().assertValid(cpf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean validarCNPJ(String cnpj) {
        try {
            new CNPJValidator().assertValid(cnpj);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
