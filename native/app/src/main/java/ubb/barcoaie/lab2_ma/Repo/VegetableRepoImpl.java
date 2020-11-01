package ubb.barcoaie.lab2_ma.Repo;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ubb.barcoaie.lab2_ma.Domain.Vegetable;

public class VegetableRepoImpl implements VegetableRepo<Vegetable,Long> {
    private List<Vegetable> vegetables;

    public VegetableRepoImpl() {
        this.vegetables = new ArrayList<>();
    }

    public List<Vegetable> getVegetables() {
        return vegetables;
    }

    public void addVegetable(Vegetable vegetable) {
        this.vegetables.add(vegetable);
    }

    public void delVegetable(String name) {
        for(int i=0;i<vegetables.size();i++){
            if (vegetables.get(i).getName().matches(name)) {
                vegetables.remove(i);
                return;
            }
        }
    }

    public void updateVegetable(String name, int price) {
        Vegetable updated = search(name);
        updated.setName(name);
        updated.setPrice(price);
    }

    public Vegetable search(String name) {
        for(int i=0;i<vegetables.size();i++) {
            if (vegetables.get(i).getName().matches(name)) {
                return vegetables.get(i);
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "VegetableRepoImpl{" +
                "vegetables=" + vegetables +
                '}';
    }
}
