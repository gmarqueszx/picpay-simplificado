package space.gmarqueszx.picpay_simplificado.mapper;

import org.mapstruct.Mapper;
import space.gmarqueszx.picpay_simplificado.dto.request.TransferenciaRequest;
import space.gmarqueszx.picpay_simplificado.dto.response.TransferenciaResponse;
import space.gmarqueszx.picpay_simplificado.model.TransferenciaModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransferenciaMapper {
    TransferenciaResponse toDto(TransferenciaModel model);
    TransferenciaModel toModel(TransferenciaRequest request);
    List<TransferenciaResponse> toCollectionDto(TransferenciaModel collectionModel);
}
