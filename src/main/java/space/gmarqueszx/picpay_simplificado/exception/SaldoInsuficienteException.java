package space.gmarqueszx.picpay_simplificado.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException() {
        super("Seu saldo é insuficiente para realizar essa transação");
    }
}
