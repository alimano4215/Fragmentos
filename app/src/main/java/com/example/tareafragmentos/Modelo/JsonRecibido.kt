package com.example.tareafragmentos.Modelo

data class JsonRecibido (var asignaturas : ArrayList<String> = ArrayList(),
                         var alumnos : ArrayList<Alumno> = ArrayList(),
                         var profesores:ArrayList<Profesor> = ArrayList()) {
}