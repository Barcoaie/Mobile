package ubb.barcoaie.lab4_ma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import ubb.barcoaie.lab4_ma.Service.VegetableService

class MainActivity : AppCompatActivity() {
    private val VEGETABLE_CREATE_REQUEST_CODE = 1
    private val VEGETABLE_READ_REQUEST_CODE = 2
    private val VEGETABLE_UPDATE_REQUEST_CODE = 3
    private val VEGETABLE_DELETE_REQUEST_CODE = 4

    private lateinit var vegetableService: VegetableService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vegetableService = VegetableService()

        val button_read: Button = this.findViewById(R.id.read_vegetables_button)
        button_read.setOnClickListener {
            val intent = Intent(this, ReadActivity::class.java)
            startActivityForResult(intent, VEGETABLE_READ_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == VEGETABLE_CREATE_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this,"back to menu",Toast.LENGTH_LONG).show()
        }
        else if (requestCode == VEGETABLE_READ_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this,"back to menu",Toast.LENGTH_LONG).show()
        }
        else if (requestCode == VEGETABLE_UPDATE_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this,"back to menu",Toast.LENGTH_LONG).show()
        }
        else if (requestCode == VEGETABLE_DELETE_REQUEST_CODE && resultCode == RESULT_OK) {
            Toast.makeText(this,"back to menu",Toast.LENGTH_LONG).show()
        }
        else
            Toast.makeText(this, "result was not ok", Toast.LENGTH_LONG).show()
    }
}