package com.example.tareafragmentos.Vista


import android.widget.AdapterView
import android.widget.Toast
import com.example.tareafragmentos.Fragments.ListaAlumnosFrag
import com.example.tareafragmentos.Modelo.*
import com.example.tareafragmentos.R
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    var gestorGson = GestorGson()
    var spinnerSelection = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var gson = gestorGson.readGson(this)
        gson.alumnos.forEach{
            DataRepository(this).insertAlumno(it)
        }
        gson.profesores.forEach{
            System.out.println(it.toString())
            DataRepository(this).insertProfesor(it)
        }
        var Profes = DataRepository(this).getProfesor()

        Profesor.text = Profes?.get(0).toString() + "\n" + Profes?.get(1).toString()
        val adapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item, gson.asignaturas)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {

            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                if (gson.asignaturas[position].equals("BBDD")){
                    spinnerSelection = "BBDD"
                    Profesor.text = Profes?.get(1).toString()
                }

                if (gson.asignaturas[position].equals("programacion")){
                    Profesor.text = Profes?.get(0).toString()
                    spinnerSelection = "programacion"
                }

                (this@MainActivity.fragment as ListaAlumnosFrag).actualizar(spinnerSelection)
                Toast.makeText(applicationContext, gson.asignaturas[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                spinnerSelection = "BBDD"
            }

        }
    }


    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Está seguro que quiere salir?")

        builder.setPositiveButton("Si") { dialog, _ -> finish() }
        builder.setNegativeButton("No") { dialog, which -> }

        builder.show()
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        spinnerSelection = savedInstanceState.getString("spinnerSelection").toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("spinnerSelection", spinnerSelection)
    }
}