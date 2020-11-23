package ubb.barcoaie.lab4_ma.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ubb.barcoaie.lab4_ma.Model.Vegetable;

public class VegetableRepo {

    private VegetableDao vegetableDao;
    private LiveData<List<Vegetable>> allVegetables;

    public VegetableRepo(Application application) {
        VegetableDatabase db = VegetableDatabase.getDatabase(application);
        vegetableDao = db.vegetableDao();
        allVegetables = vegetableDao.getVegetables();
    }

    public LiveData<List<Vegetable>> getAllVegetables() {
        return allVegetables;
    }

    public void insert(Vegetable vegetable) {
        VegetableDatabase.databaseWriteExecutor.execute(() -> {
            vegetableDao.insert(vegetable);
        });
    }
}
