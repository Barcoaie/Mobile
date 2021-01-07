package ubb.barcoaie.server.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ubb.barcoaie.server.core.domain.Vegetable;
import ubb.barcoaie.server.core.repository.VegetableRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    public static final Logger logger = LoggerFactory.getLogger(VegetableServiceImpl.class);

    @Autowired
    private VegetableRepository vegetableRepository;

    @Override
    public List<Vegetable> getVegetables() {
        List<Vegetable> vegetables = vegetableRepository.findAll();
        logger.trace("getProducts - VegetableService -> method entered, products = {}", vegetables);
        return vegetables;
    }

    @Override
    public Optional<Vegetable> getVegetableByName(String name) {
        logger.trace("getVegetableByName - VegetableService -> method entered, name = {}", name);
        return vegetableRepository.findAll().stream().filter(vegetable -> vegetable.getName().equals(name)).findFirst();
    }

    @Override
    public Optional<Vegetable> getVegetableById(Long id) {
        logger.trace("getVegetableById - VegetableService -> method entered, id = {}", id);
        Optional<Vegetable> optionalVegetable = vegetableRepository.findAll().stream().filter(vegetable -> vegetable.getId().equals(id)).findFirst();
        if (optionalVegetable.isEmpty()) {
            logger.trace("getVegetableById - VegetableService -> no vegetable with id = {}", id);
        }
        else {
            logger.trace("getVegetableById - VegetableService -> vegetable with id = {} found, vegetable = {}", id, optionalVegetable.get());
        }
        return optionalVegetable;
    }
}
