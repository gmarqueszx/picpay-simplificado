package space.gmarqueszx.picpay_simplificado.exception;

public class SaldoPositivoException extends RuntimeException {
    public SaldoPositivoException() {
        super("Não é possível deletar sua conta, você ainda possuí saldo positivo.");
    }

}
