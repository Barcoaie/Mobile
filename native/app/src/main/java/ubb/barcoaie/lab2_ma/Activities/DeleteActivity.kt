package ubb.barcoaie.lab2_ma.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_delete.*
import ubb.barcoaie.lab2_ma.R
import ubb.barcoaie.lab2_ma.Repo.VegetableRepoImpl

class DeleteActivity : AppCompatActivity() {
    var repo = VegetableRepoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        val deleteBtn: Button = findViewById(R.id.delete_btn);

        repo = intent.extras?.get("Repo") as VegetableRepoImpl

        deleteBtn.setOnClickListener {
            val input_name_text = input_name.text.toString()
            repo.delVegetable(input_name_text)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent()
        setResult(RESULT_OK, intent)
        intent.putExtra("Repo", repo)
        this.finish()
    }
}