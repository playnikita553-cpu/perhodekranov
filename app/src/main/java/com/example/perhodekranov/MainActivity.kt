package com.example.perhodekranov

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.perhodekranov.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    companion object {
        const val REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnEdit.setOnClickListener()
        {
            val intent = Intent(this, CreatorActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }






    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)


        if (requestCode == REQUEST_CODE && data != null) {
            binding.familia.setText(data.getStringExtra("FAMILIA"))
            binding.name.setText(data.getStringExtra("NAME"))
            binding.age.setText(data.getStringExtra("AGE"))
            binding.address.setText(data.getStringExtra("ADDRESS"))
            binding.phone.setText(data.getStringExtra("PHONE"))
            binding.site.setText(data.getStringExtra("SITE"))
        }
    }
}