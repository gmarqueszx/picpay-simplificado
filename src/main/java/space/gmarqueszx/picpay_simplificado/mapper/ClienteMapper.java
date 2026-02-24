package space.gmarqueszx.picpay_simplificado.mapper;

import jakarta.validation.constraints.Positive;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import space.gmarqueszx.picpay_simplificado.dto.request.ClienteRequest;
import space.gmarqueszx.picpay_simplificado.dto.response.ClienteResponse;
import space.gmarqueszx.picpay_simplificado.model.ClienteModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteResponse toDto(ClienteModel model);
    ClienteModel toModel(ClienteRequest request);
    List<ClienteResponse> toCollectionDto(List<ClienteModel> collectionModel);
    @Mapping(target = "id", ignore = true)
    void updateModelFromDto(ClienteRequest request, @MappingTarget ClienteModel model);
}
