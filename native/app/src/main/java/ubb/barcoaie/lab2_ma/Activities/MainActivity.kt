package ubb.barcoaie.lab2_ma.Activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import ubb.barcoaie.lab2_ma.Domain.Vegetable
import ubb.barcoaie.lab2_ma.R
import ubb.barcoaie.lab2_ma.Repo.VegetableRepoImpl

class MainActivity : AppCompatActivity() {
    private lateinit var repo :VegetableRepoImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repo = VegetableRepoImpl()
        repo.addVegetable(Vegetable("lettuce", 1))

        setContentView(R.layout.activity_main)

        val readBtn:Button = findViewById(R.id.button_read)
        readBtn.setOnClickListener {
            val intent = Intent(this,ReadActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivityForResult(intent, 2)
        }

        val createBtn:Button = findViewById(R.id.button_create)
        createBtn.setOnClickListener {
            val intent = Intent(this,CreateActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivityForResult(intent, 1)
        }

        val deleteBtn:Button = findViewById(R.id.button_delete)
        deleteBtn.setOnClickListener {
            val intent = Intent(this,DeleteActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivityForResult(intent, 4)
        }

        val updateBtn:Button = findViewById(R.id.button_update)
        updateBtn.setOnClickListener {
            val intent = Intent(this,UpdateActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivityForResult(intent,3)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                repo = intent.extras?.get("Repo") as VegetableRepoImpl
            }
        }
        if (requestCode == 3) {
            if (resultCode == RESULT_OK) {
                repo = intent.extras?.get("Repo") as VegetableRepoImpl
            }
        }
        if (requestCode == 4) {
            if (resultCode == RESULT_OK) {
                repo = intent.extras?.get("Repo") as VegetableRepoImpl
            }
        }
    }

}