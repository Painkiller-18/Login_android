package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_inicio.*


class InicioSistema  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        var database = AppDatabase.getDatabase(this)

        val correo = intent.getStringExtra("correo")
        val pass = intent.getStringExtra("pass")

        var alumnos = findViewById<Button>(R.id.alumlist)
        alumnos.setOnClickListener{
            val accion = Intent(this, AlumnosList::class.java)
            startActivity(accion)
        }


        if (correo == "") {
            txt_email.text = "Error: Falta el Correo."
            alumlist.setVisibility(View.INVISIBLE)
        } else {
            if (pass == "") {
                txt_email.text = "Error: Falta la Contraseña."
                alumlist.setVisibility(View.INVISIBLE)
            } else {
                var alumnoLiveData = database.alumnos().get(correo.toString(), pass.toString())
                alumnoLiveData.observe(this, Observer {
                    if (it != null) {
                        var alumno = it
                        inicio.text = "INICIO DEL SISTEMA"
                        txt_email.text = "Bienvenido\n" + alumno.nombre
                        alumlist.setVisibility(View.INVISIBLE)

                        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomnavigationView)
                        val navController = findNavController(R.id.fragmentContainerView)

                        val appBarConfiguration = AppBarConfiguration(
                            setOf(R.id.fragment_inicio,R.id.fragment_map,R.id.fragment_alumnos)
                        )
                        setupActionBarWithNavController(navController, appBarConfiguration)
                        bottomNavigationView.setupWithNavController(navController)
                    } else {
                        txt_email.text = "No existe el Usuario o Datos Incorrectos"
                        alumlist.setVisibility(View.INVISIBLE)
                    }
                })
            }
        }


        }
    }



