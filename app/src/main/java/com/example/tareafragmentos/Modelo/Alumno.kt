package com.example.tareafragmentos.Modelo

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize

@Entity(
    tableName = "Alumno"
)
@Parcelize
data class Alumno(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "IdAlumno") var codigo: Int,
    @ColumnInfo(name = "Nombre")var nombre: String,
    @ColumnInfo(name = "Apellido") var apellido: String,
    @ColumnInfo(name = "Asignaturas") var Asignaturas: String
): Parcelable

