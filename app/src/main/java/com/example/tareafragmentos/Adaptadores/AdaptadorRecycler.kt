package com.example.tareafragmentos.Adaptadores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tareafragmentos.Modelo.Alumno
import com.example.tareafragmentos.R
import kotlinx.android.synthetic.main.lista.view.*


class AdaptadorRecycler(var listAlumnos: List<Alumno>,  private val listener: (Alumno)-> Unit) : RecyclerView.Adapter<AdaptadorRecycler.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ):  ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.lista, parent, false))
    }

    fun refreshAlumnos(listAlumnos: List<Alumno>){
        this.listAlumnos = listAlumnos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AdaptadorRecycler.ViewHolder, position: Int) {
        var itemActual = listAlumnos[position]
        holder.itemView.txtIdAlumno.text = itemActual.codigo.toString()
        holder.itemView.txtNombreAlumno.text = itemActual.nombre.toString()
        holder.itemView.txtApellidoAlumno.text = itemActual.apellido
        holder.itemView.setOnClickListener { listener(itemActual) }
    }

    override fun getItemCount(): Int {
        return listAlumnos.size
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

}