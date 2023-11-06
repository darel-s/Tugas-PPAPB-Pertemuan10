package com.example.tugaspertemuan10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan10.databinding.ItemStudentBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapter (private val listStudents : List<Student>,
                      private val onClickStudent: OnClickStudent) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
                          inner class StudentViewHolder (private val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root) {
                              fun bind(student: Student) {
                                  with(binding) {
                                      ipkTxt.text = student.ipk
                                      nameTxt.text = student.name
                                      imgIcon.setImageResource(student.imageResId)
                                      itemView.setOnClickListener {
                                          onClickStudent(student)
                                      }
                                  }
                              }

                          }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return listStudents.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(listStudents[position])
    }
}