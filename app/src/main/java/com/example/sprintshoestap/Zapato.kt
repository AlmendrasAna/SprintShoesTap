package com.example.sprintshoestap

data class Zapato(var nombre: String, var url: String, var precio: Int)

class ZapatoVenta {
    companion object {
        val zapatos = mutableListOf<Zapato>().apply {
            add(Zapato("zapato feo", "https://i.postimg.cc/cCtv5gZP/frut2.png",200000 ))
            add(Zapato("zapato ReFeo", "https://postimg.cc/fSZWVbVv",250000 ))
        }


    }


}
