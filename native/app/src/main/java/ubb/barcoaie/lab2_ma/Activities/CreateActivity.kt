package ubb.barcoaie.lab2_ma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText
import ubb.barcoaie.lab2_ma.Domain.Vegetable
import ubb.barcoaie.lab2_ma.R
import ubb.barcoaie.lab2_ma.Repo.VegetableRepoImpl

class CreateActivity : AppCompatActivity() {
    var repo = VegetableRepoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create)

        val addButton: Button = findViewById(R.id.add_button)

        val input_price: TextInputEditText = findViewById(R.id.price2)
        val input_name: TextInputEditText = findViewById(R.id.name)

        repo = intent.extras?.get("Repo") as VegetableRepoImpl

        addButton.setOnClickListener {
            val input_name_text = input_name.text.toString()
            val input_price_text = input_price.text.toString().toInt()
            repo.addVegetable(Vegetable(input_name_text, input_price_text))

            println("coae merge")
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Repo", repo)
        startActivity(intent)
    }
}