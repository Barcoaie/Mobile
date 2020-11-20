package ubb.barcoaie.lab2_ma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import ubb.barcoaie.lab2_ma.R
import ubb.barcoaie.lab2_ma.Repo.VegetableRepoImpl

class UpdateActivity : AppCompatActivity() {
    var repo = VegetableRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val updateBtn: Button = findViewById(R.id.update_button)

        val input_name: TextInputEditText = findViewById(R.id.name2)
        val input_price: TextInputEditText = findViewById(R.id.price2)

        repo = intent.extras?.get("Repo") as VegetableRepoImpl

        updateBtn.setOnClickListener {
            val input_name_text = input_name.text.toString()
            val input_price_text = input_price.text.toString().toInt()

            repo.updateVegetable(input_name_text, input_price_text)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        System.out.println("pressed back")
        val intent = Intent()
        intent.putExtra("Repo", repo);
        setResult(RESULT_OK, intent)
        this.finish()
    }
}