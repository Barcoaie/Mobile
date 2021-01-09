package ubb.barcoaie.lab5_ma.activities.Create;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ubb.barcoaie.lab5_ma.model.Vegetable;
import ubb.barcoaie.lab5_ma.R;
import ubb.barcoaie.lab5_ma.repository.VegetableDatabase;


public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        EditText vegetable_name = this.findViewById(R.id.vegetable_name);
        EditText vegetable_price = this.findViewById(R.id.vegetable_price);

        Button create_button = this.findViewById(R.id.button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reply = new Intent();
                Vegetable vegetable = new Vegetable(vegetable_name.getText().toString(), Integer.parseInt(vegetable_price.getText().toString()), -1);
                VegetableDatabase.databaseWriteExecutor.execute(() -> {
                    VegetableDatabase.getDatabase(v.getContext()).vegetableDao().insert(vegetable);
                });
                reply.putExtra("add", vegetable);
                setResult(RESULT_OK, reply);
                CreateActivity.this.finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent replyIntent = new Intent();
        setResult(RESULT_CANCELED, replyIntent);
        CreateActivity.this.finish();
    }
}