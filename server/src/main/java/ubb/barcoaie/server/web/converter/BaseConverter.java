package ubb.barcoaie.server.web.converter;

import ubb.barcoaie.server.core.domain.BaseEntity;
import ubb.barcoaie.server.web.dto.BaseDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseConverter<Model extends BaseEntity<Long>, Dto extends BaseDto> implements Converter<Model, Dto> {
    public List<Dto> convertModelsToDtos(Collection<Model> models) {
        return models.stream().map(model -> convertModelToDto(model)).collect(Collectors.toList());
    }

    public List<Model> convertDtosToModels(Collection<Dto> dtos) {
        return dtos.stream().map(dto -> convertDtoToModel(dto)).collect(Collectors.toList());
    }
}
