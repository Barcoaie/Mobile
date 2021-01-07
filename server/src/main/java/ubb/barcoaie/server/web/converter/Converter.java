package ubb.barcoaie.server.web.converter;

import ubb.barcoaie.server.core.domain.BaseEntity;
import ubb.barcoaie.server.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {
    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);
}
