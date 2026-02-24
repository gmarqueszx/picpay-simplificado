package space.gmarqueszx.picpay_simplificado.exception;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public ClienteNaoEncontradoException(Long id) {
        this("Não foi encontrado nenhum cliente com id: " + id + " registrado em nosso banco de " +
                "dados.");
    }
}
