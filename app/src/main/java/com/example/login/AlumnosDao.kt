package com.example.login

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AlumnosDao {
    @Query("SELECT * FROM alumnos")
    fun getAll(): LiveData<List<Alumno>>

    @Query("SELECT * FROM alumnos WHERE idAlumno = :id")
    fun get(id: Int): LiveData<Alumno>

    @Query("SELECT * FROM alumnos WHERE correo = :correo AND pass = :pass")
    fun get(correo: String, pass: String): LiveData<Alumno>

    @Insert
    fun insertAll(vararg alumno: Alumno)

    @Update
    fun update(alumno: Alumno)

    @Delete
    fun delete(alumno: Alumno)

}