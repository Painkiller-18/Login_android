package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_nuevo_alumno.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevoAlumnoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nuevo_alumno)

        val database = AppDatabase.getDatabase(this)

        save_btn.setOnClickListener{
            val nombre = nombre_nvo.text.toString()
            val matricula = matricula_nvo.text.toString().toInt()
            val correo = correo_nvo.text.toString()
            val pass = pass_nvo.text.toString()
            val alumno = Alumno(nombre, matricula, correo, pass, R.drawable.avatar)
                CoroutineScope(Dispatchers.IO).launch {
                    database.alumnos().insertAll(alumno)

                    this@NuevoAlumnoActivity.finish()

            }

        }

        var inicio = findViewById<Button>(R.id.btn_inicio)
        inicio.setOnClickListener{
            val accion = Intent(this, MainActivity::class.java)
            startActivity(accion)
        }

    }
}