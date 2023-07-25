package com.example.sprintshoestap

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.sprintshoestap.databinding.ItemCarritoBinding
import com.example.sprintshoestap.databinding.ItemZapatoBinding

class AdapterCarrito : RecyclerView.Adapter<AdapterCarrito.ViewHolder>() {

    var zapatos = mutableListOf<Zapato>()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zapato = zapatos[position]
        holder.bind(zapato)
    }

    fun setData(zapatos: MutableList<Zapato>) {
        this.zapatos = zapatos.toMutableList()
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemCarritoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(zapato: Zapato) {
            binding.nombreZapatoCarritoTxt.text = zapato.nombre
            binding.imaZapatoCarrito.load(zapato.url){    crossfade(true)
                transformations(CircleCropTransformation())
                placeholder(R.drawable.logo)

            }

            binding.precioZapatoCarritoTxt.text = "$ " + zapato.precio.toString()




        }

    }




}