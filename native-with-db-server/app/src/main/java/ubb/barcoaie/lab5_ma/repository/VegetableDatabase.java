package ubb.barcoaie.lab5_ma.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ubb.barcoaie.lab5_ma.domain.Vegetable;

@Database(entities = {Vegetable.class}, version = 1, exportSchema = false)
public abstract class VegetableDatabase extends RoomDatabase {

    public abstract VegetableDao vegetableDao();

    private static volatile VegetableDatabase INSTANCE;

    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);

    public static VegetableDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (VegetableDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            VegetableDatabase.class, "VegetableDB").addCallback(RoomDatabaseCallback).build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback RoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                VegetableDao dao = INSTANCE.vegetableDao();
                dao.deleteAll();

                Vegetable vegetable = new Vegetable("aubergine", 6, -1);
                dao.insert(vegetable);
                Vegetable vegetable1 = new Vegetable("parsley", 2, -1);
                dao.insert(vegetable1);
            });
        }
    };
}
