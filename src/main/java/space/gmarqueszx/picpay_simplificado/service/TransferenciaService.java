package space.gmarqueszx.picpay_simplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.gmarqueszx.picpay_simplificado.dto.request.TransferenciaRequest;
import space.gmarqueszx.picpay_simplificado.dto.response.TransferenciaResponse;
import space.gmarqueszx.picpay_simplificado.exception.ClienteNaoEncontradoException;
import space.gmarqueszx.picpay_simplificado.exception.NegocioException;
import space.gmarqueszx.picpay_simplificado.exception.SaldoInsuficienteException;
import space.gmarqueszx.picpay_simplificado.mapper.TransferenciaMapper;
import space.gmarqueszx.picpay_simplificado.model.ClienteModel;
import space.gmarqueszx.picpay_simplificado.model.TipoCliente;
import space.gmarqueszx.picpay_simplificado.model.TransferenciaModel;
import space.gmarqueszx.picpay_simplificado.repository.ClienteRepository;
import space.gmarqueszx.picpay_simplificado.repository.TransferenciaRepository;

import java.math.BigDecimal;

@Service
public class TransferenciaService {
    private final TransferenciaRepository repository;
    private final TransferenciaMapper mapper;
    private final ClienteRepository clienteRepository;

    @Autowired
    public TransferenciaService(TransferenciaRepository repository, TransferenciaMapper mapper, ClienteRepository clienteRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public TransferenciaResponse efetuarTransferencia(TransferenciaRequest request) {

        ClienteModel remetente = clienteRepository.findById(request.getRemetente()).orElseThrow(
                () -> new ClienteNaoEncontradoException(request.getRemetente()));


        if (remetente.getTipoCliente().equals(TipoCliente.PESSOA_JURIDICA)) {
            throw new NegocioException("Pessoa jurídica não pode realizar transferências.");
        }

        if (remetente.getSaldo().compareTo(request.getValor()) < 0){
            throw new SaldoInsuficienteException();
        }

        if (request.getRemetente().equals(request.getDestinatario())) {
            throw new NegocioException("Remetente e destinatário não podem ser os mesmos.");
        }

        ClienteModel destinatario = clienteRepository.findById(request.getDestinatario()).orElseThrow(
                () -> new ClienteNaoEncontradoException(request.getDestinatario()));

        remetente.debitar(request.getValor());
        destinatario.creditar(request.getValor());

        clienteRepository.save(remetente);
        clienteRepository.save(destinatario);

        TransferenciaModel model = mapper.toModel(request);
        repository.save(model);

        return mapper.toDto(model);
    }
}
