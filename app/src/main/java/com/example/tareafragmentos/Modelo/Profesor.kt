package com.example.tareafragmentos.Modelo

import androidx.room.ColumnInfo
import androidx.room.Entity

import androidx.room.PrimaryKey

@Entity(
    tableName = "Profesor"
)
data class Profesor(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "IdProfesor") var codigo: Int,
    @ColumnInfo(name = "Nombre")var nombre: String,
    @ColumnInfo(name = "Apellido")var apellido: String,
    @ColumnInfo(name = "Asignatura")var asignatura: String
) {
}