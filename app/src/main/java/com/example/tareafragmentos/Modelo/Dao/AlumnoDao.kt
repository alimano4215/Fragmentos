package com.example.tareafragmentos.Modelo.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tareafragmentos.Modelo.Alumno

@Dao
interface AlumnoDao {
    @Query("SELECT * FROM Alumno")
     fun getAlumnos(): List<Alumno>?
    @Query("SELECT * FROM Alumno where Asignaturas = :asignatura")
     fun getAlumnos(asignatura : String): List<Alumno>?
    @Insert
     fun insertAll(vararg alumno: Alumno)
}
