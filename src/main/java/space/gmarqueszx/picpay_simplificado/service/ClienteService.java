package space.gmarqueszx.picpay_simplificado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import space.gmarqueszx.picpay_simplificado.dto.request.ClienteRequest;
import space.gmarqueszx.picpay_simplificado.dto.response.ClienteResponse;
import space.gmarqueszx.picpay_simplificado.exception.ClienteNaoEncontradoException;
import space.gmarqueszx.picpay_simplificado.exception.DocumentoEmUsoException;
import space.gmarqueszx.picpay_simplificado.exception.EmailEmUsoException;
import space.gmarqueszx.picpay_simplificado.exception.NegocioException;
import space.gmarqueszx.picpay_simplificado.mapper.ClienteMapper;
import space.gmarqueszx.picpay_simplificado.model.ClienteModel;
import space.gmarqueszx.picpay_simplificado.repository.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    @Autowired
    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public ClienteResponse criar(ClienteRequest request) {
        return gravar(null, request);
    }

    @Transactional
    public ClienteResponse atualizar(Long id, ClienteRequest request) {
        return gravar(id, request);
    }


    private ClienteResponse gravar(Long id, ClienteRequest request) {
        if (id == null && repository.existsByDocumento(request.getDocumento())) {
            throw new DocumentoEmUsoException(request.getDocumento());
        }

        if (id == null && repository.existsByEmail(request.getEmail())) {
            throw new EmailEmUsoException(request.getEmail());
        }

        ClienteModel model = (id != null) ? repository.findById(id).orElseThrow(
                () -> new ClienteNaoEncontradoException(id)) : new ClienteModel();


        if (id != null && !model.getDocumento().equals(request.getDocumento())) {
            throw new NegocioException("Não é possível alterar o CPF de um cliente existente.");
        }

        if (id != null && !model.getEmail().equals(request.getEmail())
                && repository.existsByEmail(request.getEmail())) {
            throw new EmailEmUsoException(request.getEmail());
        }

        mapper.updateModelFromDto(request, model);

        repository.save(model);

        return mapper.toDto(model);
    }

    @Transactional(readOnly = true)
    public ClienteResponse exibirPorId(Long id) {
        ClienteModel model =
                repository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));


        return mapper.toDto(model);
    }
}
