package com.example.sprintshoestap

data class Zapato(var nombre: String, var url: String, var precio: Int)

class ZapatoVenta {
    companion object {
        val zapatos = mutableListOf<Zapato>().apply {
            add(Zapato("Destapador", "https://i.postimg.cc/F1tBKRrS/5ocg5sd5.jpg",40000 ))
            add(Zapato("Crystal", "https://i.postimg.cc/NjtQJG6L/cristal.jpg",132000 ))
            add(Zapato("Funky", "https://i.postimg.cc/VsSs5Vss/ef7541ec4d8d656639815013447f8404-funky-shoes-crazy-shoes.jpg",2200000 ))
            add(Zapato("Escoba", "https://i.postimg.cc/8CPNGynS/escoba.jpg",250032 ))
            add(Zapato("cadena", "https://i.postimg.cc/jdPs4nJG/featured-img-of-post-107276.jpg",333200 ))
            add(Zapato("Sin Taco", "https://i.postimg.cc/xjWfm3qv/f00f1f74a64bf2df3ed6f2158e7d7f38.jpg",255500 ))
            add(Zapato("Steampunk", "https://i.postimg.cc/bwRpKXgg/fsd.jpg",201200 ))
            add(Zapato("GameBoy", "https://i.postimg.cc/NMZc1QGs/gameboy.jpg",444000 ))
            add(Zapato("Perla", "https://i.postimg.cc/v86MGxXc/perla.jpg",456000 ))
            add(Zapato("Crop", "https://i.postimg.cc/X7fbCMRW/sdf.jpg",253200 ))
            add(Zapato("Smile", "https://i.postimg.cc/7Y84hPQX/x720.jpg",443000 ))
        }
    }
}
