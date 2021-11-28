package com.example.login

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_alumno.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //LOGIN---------------------
        var log_login = findViewById<Button>(R.id.btn_ingresar)
        log_login.setOnClickListener{
            val correo = log_email.text.toString()
            val pass = log_pass.text.toString()

            val intent = Intent(this, InicioSistema::class.java)
                intent.putExtra("correo", correo)
                intent.putExtra("pass", pass)
                startActivity(intent)
        }

        //--------------------------


        var alumnos = findViewById<Button>(R.id.alumlist)
        alumnos.setOnClickListener {
                val accion = Intent(this, AlumnosList::class.java)
                startActivity(accion)
        }


        //-----------------------------------------------------------------
        floatingActionButton.setOnClickListener{
            val intent = Intent(this, NuevoAlumnoActivity::class.java)
            startActivity(intent)
        }


    }
}