package com.example.sprintshoestap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sprintshoestap.databinding.ItemZapatoBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var zapatos = mutableListOf<Zapato>()
    var callback: PaisCallBack? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemZapatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pais = zapatos[position]
        holder.bind(pais)
    }

    fun setData(paises: MutableList<Zapato>) {
        this.zapatos = zapatos.toMutableList()
    }

    inner class ViewHolder(val binding: ItemZapatoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(zapato: Zapato) {
            binding.nombreTxt.text = zapato.nombre
            binding.imaZapato.load(zapato.url)
            binding.precioTxt.text = zapato.precio.toString()


            /*
            binding.cView.setOnClickListener(View.OnClickListener {
            callback?.showCountry("")
            })
            */

        }

    }

    interface PaisCallBack {
        fun showCountry(s: String)

    }


}