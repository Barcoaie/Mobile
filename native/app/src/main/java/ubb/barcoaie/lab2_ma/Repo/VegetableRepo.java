package ubb.barcoaie.lab2_ma.Repo;

import java.io.Serializable;
import java.util.List;

public interface VegetableRepo<Vegetable, ID extends Serializable > extends Serializable {
    void addVegetable(Vegetable vegetable);
    List<Vegetable> getVegetables();
    void delVegetable(String name);
    void updateVegetable(String name, int price);
    Vegetable search(String name);
}
