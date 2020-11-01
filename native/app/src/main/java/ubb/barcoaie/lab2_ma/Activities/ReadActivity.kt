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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        System.out.println("pressed back")
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("Repo", repo);
        startActivity(intent)
    }
}