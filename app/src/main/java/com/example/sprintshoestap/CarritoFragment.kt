package com.example.sprintshoestap

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sprintshoestap.CarritoCompra.Companion.crearListaCarrito
import com.example.sprintshoestap.databinding.FragmentCarritoBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarritoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarritoFragment : Fragment(), AdapterCarrito.EliminarItemCarrito {
    private lateinit var binding: FragmentCarritoBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarritoBinding.inflate(LayoutInflater.from(activity))

        initAdapter()

        return (binding.root)
    }

    fun initAdapter() {
        val adapter = AdapterCarrito()

        val listadoZapatosVentas = crearListaCarrito()
        binding.recyclerCarrito.getAdapter()?.notifyItemInserted(ZapatoVenta.zapatos.size);


        adapter.setData(listadoZapatosVentas)
        adapter.callback = this
        binding.recyclerCarrito.adapter = adapter

        binding.eliminarCarritoB.setOnClickListener {
            SharedApp.prefs.clean()
            adapter.carritoZapatoParaVender.clear()
            adapter.notifyDataSetChanged()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CarritoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CarritoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun eliminarItem(kay: String) {
        SharedApp.prefs.removeItem(kay)

    }
}