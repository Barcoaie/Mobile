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
            startActivity(intent)
        }

        val createBtn:Button = findViewById(R.id.button_create)
        createBtn.setOnClickListener {
            val intent = Intent(this,CreateActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivity(intent)
        }

        val deleteBtn:Button = findViewById(R.id.button_delete)
        deleteBtn.setOnClickListener {
            val intent = Intent(this,DeleteActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivity(intent)
        }

        val updateBtn:Button = findViewById(R.id.button_update)
        updateBtn.setOnClickListener {
            val intent = Intent(this,UpdateActivity::class.java)
            intent.putExtra("Repo", repo)
            startActivity(intent)
        }

        if(intent.extras?.get("Repo") != null) {
            repo = intent.extras?.get("Repo") as VegetableRepoImpl
        }
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

}