package space.gmarqueszx.picpay_simplificado.exception;

public class DocumentoEmUsoException extends RuntimeException {
    public DocumentoEmUsoException(String documento) {
        super("O documento " + documento + " está em uso.");
    }
}
