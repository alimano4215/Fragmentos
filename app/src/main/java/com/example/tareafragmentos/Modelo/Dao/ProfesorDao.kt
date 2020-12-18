package com.example.tareafragmentos.Modelo.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tareafragmentos.Modelo.Profesor


@Dao
interface ProfesorDao {
    @Query("SELECT * FROM Profesor")
    fun getProfesor(): List<Profesor>?
    @Query("SELECT * FROM Profesor where Asignatura = :asignatura")
    fun getProfesor(asignatura : String): Profesor
    @Insert
    fun insertAll(vararg profesor: Profesor)
}