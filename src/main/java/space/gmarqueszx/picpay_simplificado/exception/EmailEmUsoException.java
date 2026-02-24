package space.gmarqueszx.picpay_simplificado.exception;

public class EmailEmUsoException extends RuntimeException{
    public EmailEmUsoException(String email) {
        super("O email " + email + " está em uso.");
    }
}
