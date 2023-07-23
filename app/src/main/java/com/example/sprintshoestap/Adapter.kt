package com.example.sprintshoestap

import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.sprintshoestap.databinding.ItemZapatoBinding

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    var zapatos = mutableListOf<Zapato>()
    var callback: ZapatosCallBack? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemZapatoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

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
    }

    inner class ViewHolder(val binding: ItemZapatoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(zapato: Zapato) {
            binding.nombreTxt.text = zapato.nombre
            binding.imaZapato.load(zapato.url){    crossfade(true)
                placeholder(R.drawable.logo)
                }

            binding.precioTxt.text = "$ " + zapato.precio.toString()

            binding.cardView.setOnClickListener(View.OnClickListener {
            callback?.showInfoFragmen(zapato)
                val applicationContext = this
                Log.e("bind: ","baana" )
            })


        }

    }

    interface ZapatosCallBack {
        fun showInfoFragmen(zapata:Zapato)

    }


}