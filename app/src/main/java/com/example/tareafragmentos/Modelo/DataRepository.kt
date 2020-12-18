package com.example.tareafragmentos.Modelo

import android.content.Context
import android.os.AsyncTask
import com.example.tareafragmentos.Modelo.Dao.*

class DataRepository(context: Context) {
    private val alumnoDao: AlumnoDao? = GenerarBBDD.getDatabase(context)?.alumnoDao()
    private val profesorDao: ProfesorDao? = GenerarBBDD.getDatabase(context)?.profesorDao()


    fun insertAlumno(alumno: Alumno): Int {
        if (alumnoDao != null) {
            return InsertAlumno(alumnoDao).execute(alumno).get()
        }
        return -1
    }

    private class InsertAlumno(private val alumnoDao: AlumnoDao) :
        AsyncTask<Alumno, Void, Int>() {

        override fun doInBackground(vararg alumnos: Alumno?): Int? {

            try {
                for (alumno in alumnos) {
                    if (alumno != null) {
                        alumnoDao.insertAll(alumno)
                    }
                }
                return 0
            } catch (exception: Exception) {
                return -1
            }
        }
    }

    fun insertProfesor(profesor: Profesor): Int {

        if (profesorDao != null) {
            return InsertProfesor(profesorDao).execute(profesor).get()
        }
        return -1
    }

    private class InsertProfesor(private val profesorDao: ProfesorDao) :
        AsyncTask<Profesor, Void, Int>() {

        override fun doInBackground(vararg profesores: Profesor?): Int {
            try {
                for (profesor in profesores) {
                    if (profesor != null) {
                        profesorDao.insertAll(profesor)
                    }
                }
                return 0
            } catch (exception: Exception) {
                return -1
            }
        }
    }

    fun getProfesor() : List<Profesor>? {
        var getProfesores = GetProfesores(profesorDao!!).execute().get()
        return getProfesores
    }

    private class GetProfesores(private val profesorDao: ProfesorDao) : AsyncTask<Void, Void, List<Profesor>>() {
        override fun doInBackground(vararg p0: Void?): List<Profesor>? {
            return profesorDao.getProfesor()
        }
    }

    fun getAlumnos(asignatura : String? = null) : List<Alumno>? {
        var getAlumnos = GetAlumnos(alumnoDao!!, asignatura).execute().get()
        return getAlumnos
    }

    private class GetAlumnos(private val alumnoDao: AlumnoDao, private val asignatura: String?) : AsyncTask<Void, Void, List<Alumno>>() {
        override fun doInBackground(vararg p0: Void?): List<Alumno>? {
            return asignatura?.let { alumnoDao.getAlumnos(it) }
        }
    }
}