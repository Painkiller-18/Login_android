package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_alumno_list.*

class AlumnosList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno_list)


    //-----------------------------------------------------------------
    var listaAlumnos = emptyList<Alumno>()
    var database = AppDatabase.getDatabase(this)

    database.alumnos().getAll().observe(this, Observer {
        listaAlumnos = it
        val adapter = AlumnosAdapter(this, listaAlumnos)
        lista.adapter = adapter
    })


        }

}