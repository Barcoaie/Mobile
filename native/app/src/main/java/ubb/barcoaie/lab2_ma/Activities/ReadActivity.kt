package ubb.barcoaie.lab2_ma.Activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import ubb.barcoaie.lab2_ma.Domain.Vegetable
import ubb.barcoaie.lab2_ma.R
import ubb.barcoaie.lab2_ma.Repo.VegetableRepoImpl

class ReadActivity : AppCompatActivity() {
    var repo = VegetableRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_read)

        repo = intent.extras?.get("Repo") as VegetableRepoImpl

        val my_Array = ArrayList<Vegetable>()

        for (vegetable in repo.vegetables){
            my_Array.add(vegetable)
        }

        val adapter = ArrayAdapter<Vegetable>(
                this,
                R.layout.listview_item,
                my_Array
        )


        val listView:ListView = findViewById(R.id.listview_1)
        listView.setAdapter(adapter)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        System.out.println("pressed back")
        val intent = Intent()
        setResult(RESULT_OK, intent)
        this.finish()
    }
}