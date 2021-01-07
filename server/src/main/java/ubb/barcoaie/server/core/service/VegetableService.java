package ubb.barcoaie.server.core.service;

import ubb.barcoaie.server.core.domain.Vegetable;

import java.util.List;
import java.util.Optional;

public interface VegetableService {
    List<Vegetable> getVegetables();

    Optional<Vegetable> getVegetableByName(String name);

    Optional<Vegetable> getVegetableById(Long id);
}
