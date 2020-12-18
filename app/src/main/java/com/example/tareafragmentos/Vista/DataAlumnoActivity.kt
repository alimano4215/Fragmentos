package com.example.tareafragmentos.Vista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tareafragmentos.Modelo.Alumno
import com.example.tareafragmentos.R
import kotlinx.android.synthetic.main.activity_data_alumno.*

class DataAlumnoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_alumno)

        var alumno : Alumno? = intent.getParcelableExtra<Alumno>("Alumno")

        txtIdAlumno.text = alumno?.codigo.toString()
        txtNombreAlumno.text = alumno?.nombre
        txtApellidoAlumno.text = alumno?.apellido
        txtAsignaturaAlumno.text = alumno?.Asignaturas
    }
}