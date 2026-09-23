package com.example.perhodekranov

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.perhodekranov.databinding.CreatorUserBinding

class CreatorActivity : AppCompatActivity() {

    private lateinit var binding: CreatorUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = CreatorUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAddress.setOnClickListener(){
            val address = binding.addressTwo.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$address"))
            startActivity(intent)
        }
        binding.btnPhone.setOnClickListener() {
            val phone = binding.phoneTwo.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$phone")
            startActivity(intent)
        }
        binding.btnSite.setOnClickListener {
            val site = binding.siteTwo.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://$site"))
            startActivity(intent)
        }
        binding.btnSave.setOnClickListener() {
            val intent = Intent()
            intent.putExtra("FAMILIA", binding.familiaTwo.text.toString())

            intent.putExtra("NAME", binding.nameTwo.text.toString())

            intent.putExtra("AGE", binding.ageTwo.text.toString())

            intent.putExtra("ADDRESS", binding.addressTwo.text.toString())

            intent.putExtra("PHONE", binding.phoneTwo.text.toString())

            intent.putExtra("SITE", binding.siteTwo.text.toString())

            setResult(RESULT_OK, intent)
            finish()

        }


    }
}