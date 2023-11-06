package com.example.tugaspertemuan10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateStudentData()) { student ->
            Toast.makeText(this@MainActivity, " ${student.name}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("ipk", student.ipk)
            intent.putExtra("image", student.imageResId)
            startActivity(intent)
        }

        with(binding) {
            rvStudent.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun generateStudentData(): List<Student> {
        return listOf(
            Student("Darriel Markerizal", "3.8", R.drawable.avatar_1),
            Student("Yodhimas Geffananda", "3.7", R.drawable.avatar_2),
            Student("Rizky Aziz", "3.6", R.drawable.avatar_3),
            Student("Wildan Dzaky", "3.5", R.drawable.avatar_4),
            Student("Nawal Rizky", "3.4", R.drawable.avatar_5)
        )
    }
}
