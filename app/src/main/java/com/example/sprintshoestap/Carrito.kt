package com.example.sprintshoestap


import android.content.SharedPreferences
import android.util.Log
import okhttp3.internal.threadName


//data class Carrito(val zapatos:Zapato)

class CarritoCompra()
{

    companion object {
        val carritoZapatos = crearListaCarrito()

        fun eliminarItemCarrito(kayEliminar:String){
          SharedApp.prefs.removeItem(kayEliminar)
                }
        fun crearListaCarrito(): MutableList<Zapato>{

            val zapatos = ZapatoVenta.zapatos
            val carrito = mutableListOf<Zapato>()

             var nombres = SharedApp.prefs.mSharedPreferences.all.toString()

            Log.e("lol", "crearListaCarrito: $nombres")

            for (z in zapatos)
            {
                if (nombres.indexOf (z.nombre) != -1)carrito.add(z)
            }

            return carrito
        }

        }
}