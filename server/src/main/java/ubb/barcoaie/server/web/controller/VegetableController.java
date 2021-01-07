package ubb.barcoaie.server.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ubb.barcoaie.server.core.domain.Vegetable;
import ubb.barcoaie.server.core.service.VegetableService;
import ubb.barcoaie.server.web.converter.VegetableConverter;
import ubb.barcoaie.server.web.dto.VegetableDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    public static final Logger logger = LoggerFactory.getLogger(VegetableController.class);

    @Autowired
    private VegetableConverter vegetableConverter;
    @Autowired
    private VegetableService vegetableService;

    @RequestMapping(value = "/getVegetables", method = RequestMethod.GET)
    public List<VegetableDto> getVegetables() {
        List<Vegetable> vegetables = vegetableService.getVegetables();
        logger.trace("GET - VegetableController -> method entered, vegetables = {}", vegetables);
        return vegetableConverter.convertModelsToDtos(vegetables);
    }

    @RequestMapping(value = "/getVegetableById", method = RequestMethod.GET)
    public VegetableDto getVegetableById(@RequestParam Long ID) {
        Optional<Vegetable> vegetable = vegetableService.getVegetableById(ID);
        logger.trace("GET ID - VegetableController -> method entered, ID = {}", ID);
        if(vegetable.isEmpty()) {
            return null;
        }
        return vegetableConverter.convertModelToDto(vegetable.get());
    }
}
