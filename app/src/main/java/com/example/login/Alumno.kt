package com.example.login

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "alumnos")
class Alumno (
        val nombre:String,
        val matricula:Int,
        val correo:String,
        val pass:String,
        val imagen:Int,
        @PrimaryKey(autoGenerate = true)
        val idAlumno:Int = 0
): Serializable