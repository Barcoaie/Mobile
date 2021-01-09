package ubb.barcoaie.lab5_ma;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ubb.barcoaie.lab5_ma.model.Vegetable;
import ubb.barcoaie.lab5_ma.repository.VegetableRepo;

public class VegetableViewModel extends AndroidViewModel {
    private VegetableRepo vegetableRepo;

    private final LiveData<List<Vegetable>> allVegetables;

    public VegetableViewModel(Application application) {
        super(application);
        vegetableRepo = new VegetableRepo(application);
        allVegetables = vegetableRepo.getAllVegetables();
    }

    public LiveData<List<Vegetable>> getAllVegetables() { return allVegetables; }
}
