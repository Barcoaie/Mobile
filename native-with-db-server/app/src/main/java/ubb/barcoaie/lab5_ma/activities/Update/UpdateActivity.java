package ubb.barcoaie.lab5_ma.activities.Update;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import ubb.barcoaie.lab5_ma.R;
import ubb.barcoaie.lab5_ma.VegetableViewModel;

public class UpdateActivity extends AppCompatActivity {
    private VegetableViewModel vegetableViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final VegetableListAdapterUpd adapter = new VegetableListAdapterUpd(new VegetableListAdapterUpd.VegetableDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vegetableViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new VegetableViewModel(getApplication());
            }
        }).get(VegetableViewModel.class);
        vegetableViewModel.getAllVegetables().observe(this, adapter::submitList);
    }

    @Override
    public void onBackPressed() {
        Intent replyIntent = new Intent();
        setResult(RESULT_OK, replyIntent);
        UpdateActivity.this.finish();
    }
}