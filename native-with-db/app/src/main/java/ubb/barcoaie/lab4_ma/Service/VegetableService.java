package ubb.barcoaie.lab4_ma.Service;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ubb.barcoaie.lab4_ma.Model.Vegetable;

public class VegetableService implements Serializable {
    private List<Vegetable> vegetableList;

    public VegetableService() {
        this.vegetableList = new ArrayList<>();
    }

    @NotNull
    @Override
    public String toString() {
        return "VegetableService{" +
                "vegetableList=" + vegetableList +
                '}';
    }

    public List<Vegetable> getVegetableList() {
        return vegetableList;
    }

    public void setVegetableList(List<Vegetable> vegetableList) {
        this.vegetableList = vegetableList;
    }
}
