package com.example.sprintshoestap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.sprintshoestap.databinding.ItemCarritoBinding

class AdapterCarrito : RecyclerView.Adapter<AdapterCarrito.ViewHolder>() {

    var carritoZapatoParaVender = mutableListOf<Zapato>()

    var callback: EliminarItemCarrito? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemCarritoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return carritoZapatoParaVender.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zapato = carritoZapatoParaVender[position]
        holder.bind(zapato)
    }

    fun setData(zapatos: MutableList<Zapato>) {
        this.carritoZapatoParaVender = zapatos.toMutableList()
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemCarritoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(zapato: Zapato) {
            binding.nombreZapatoCarritoTxt.text = zapato.nombre
            binding.imaZapatoCarrito.load(zapato.url) {
                crossfade(true)
                transformations(CircleCropTransformation())
                placeholder(R.drawable.logo)

            }

            binding.precioZapatoCarritoTxt.text = "$ " + zapato.precio.toString()



            binding.eliminarZaparoB.setOnClickListener(View.OnClickListener {

                callback?.eliminarItem(zapato.nombre)
                carritoZapatoParaVender.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            })

        }

    }

    interface EliminarItemCarrito {
        fun eliminarItem(kay : String)

    }
}




