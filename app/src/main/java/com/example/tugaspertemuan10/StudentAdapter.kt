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
        val student = listStudents[position]
        holder.bind(listStudents[position])

        val ipkTextView = student.ipk
        val ipk = student.ipk.toDoubleOrNull()
        if (ipk != null) {
            when {
                ipk >= 3.5 -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.green))
                }
                ipk >= 3.0 -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.yellow))
                }
                else -> {
                    holder.itemView.setBackgroundColor(holder.itemView.context.getColor(R.color.red))
                }
            }
        }
    }
}