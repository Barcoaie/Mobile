package ubb.barcoaie.lab5_ma.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ubb.barcoaie.lab5_ma.domain.Vegetable;

public interface VegetableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Vegetable vegetable);

    @Query("DELETE FROM Vegetable WHERE id = :id")
    void delete(Long id);

    @Query("UPDATE Vegetable SET name  = :name, price = :price, onServer = :onServer WHERE id = :id")
    void update(Long id, String name, int price, int onServer);

    @Query("DELETE FROM Vegetable")
    void deleteAll();

    @Query("SELECT * FROM Vegetable ORDER BY name ASC")
    LiveData<List<Vegetable>> getVegetables();

    @Query("SELECT * FROM Vegetable WHERE onServer = -1")
    LiveData<List<Vegetable>> getLocalStoredVegetables();
}
