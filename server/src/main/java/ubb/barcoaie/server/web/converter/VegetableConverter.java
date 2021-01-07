package ubb.barcoaie.server.web.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ubb.barcoaie.server.core.domain.Vegetable;
import ubb.barcoaie.server.web.dto.VegetableDto;

@Component
public class VegetableConverter extends BaseConverter<Vegetable, VegetableDto> {
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Vegetable convertDtoToModel(VegetableDto dto) {
        Vegetable vegetable = modelMapper.map(dto, Vegetable.class);
        vegetable.setId(dto.getId());
        return vegetable;
    }

    @Override
    public VegetableDto convertModelToDto(Vegetable vegetable) {
        VegetableDto vegetableDto = modelMapper.map(vegetable, VegetableDto.class);
        vegetableDto.setId(vegetable.getId());
        return vegetableDto;
    }
}
