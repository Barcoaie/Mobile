package ubb.barcoaie.lab2_ma.Service;

import ubb.barcoaie.lab2_ma.Domain.Vegetable;
import ubb.barcoaie.lab2_ma.Repo.VegetableRepo;

public class VegetableService {
    private VegetableRepo<Vegetable,Long> vegetableRepo;

    public VegetableService(VegetableRepo<Vegetable, Long> vegetableRepo) {
        this.vegetableRepo = vegetableRepo;
    }

    public VegetableRepo<Vegetable, Long> getVegetableRepo() {
        return vegetableRepo;
    }

    public void add(String name, int price) {
        Vegetable vegetable = new Vegetable(name, price);
        this.vegetableRepo.addVegetable(vegetable);
    }

    public void del(String pos) {
        this.vegetableRepo.delVegetable(pos);
    }

    public void update(String name, int price) {
        this.vegetableRepo.updateVegetable(name, price);
    }
}
