package com.example.tareafragmentos.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tareafragmentos.Adaptadores.AdaptadorRecycler
import com.example.tareafragmentos.Modelo.DataRepository
import com.example.tareafragmentos.R
import com.example.tareafragmentos.Vista.DataAlumnoActivity
import com.example.tareafragmentos.Vista.MainActivity



/**
 * A simple [Fragment] subclass.
 * Use the [ListaAlumnosFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaAlumnosFrag : Fragment() {

    lateinit var dataRepository: DataRepository

    lateinit var customAdapter :AdaptadorRecycler

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var ViewFrag = inflater.inflate(R.layout.fragment_lista_alumnos, container, false)
        var recyclerView : RecyclerView = ViewFrag.findViewById(R.id.idRecycler) as RecyclerView

        dataRepository = this.context?.let { DataRepository(it)}!!

        var listaAlumnos  = dataRepository.getAlumnos((this.activity as MainActivity).spinnerSelection)

        customAdapter = listaAlumnos?.let { AdaptadorRecycler(it){
            var intent = Intent(this.context, DataAlumnoActivity::class.java)
            intent.putExtra("Alumno", it)
            startActivity(intent)
            }
         }!!

        recyclerView.setLayoutManager(LinearLayoutManager(context))
        recyclerView.setAdapter(customAdapter)

        return ViewFrag
    }
    fun actualizar(asignatura : String){
        var listaAlumnos  = dataRepository.getAlumnos(asignatura)
        if (listaAlumnos != null) {
            customAdapter.refreshAlumnos(listaAlumnos)
        }
    }
}