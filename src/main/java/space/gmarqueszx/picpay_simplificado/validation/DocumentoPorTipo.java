package space.gmarqueszx.picpay_simplificado.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ClienteDocumentoValidator.class)
public @interface DocumentoPorTipo {
    String message() default "Documento inválido para o tipo de cliente";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
