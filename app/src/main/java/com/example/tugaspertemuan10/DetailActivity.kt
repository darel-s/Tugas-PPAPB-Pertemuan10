package com.example.tugaspertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugaspertemuan10.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentName = intent.getStringExtra("name")
        val studentIpk = intent.getStringExtra("ipk")
        val studentImage = intent.getIntExtra("image", 0)
        
        binding.apply {
            nameTxt.text = studentName
            ipkTxt.text = studentIpk
            imgIcon.setImageResource(studentImage)
        }
    }
}