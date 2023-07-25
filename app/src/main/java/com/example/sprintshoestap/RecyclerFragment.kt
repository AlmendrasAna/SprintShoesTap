package com.example.sprintshoestap

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sprintshoestap.databinding.FragmentRecyclerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerFragment : Fragment(), Adapter.ZapatosCallBack {
    private lateinit var binding: FragmentRecyclerBinding

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

        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(LayoutInflater.from(activity))
        initAdapter()
        return (binding.root)
    }

    fun initAdapter() {
        val adapter = Adapter()
        val listadoZapatosVentas = ZapatoVenta.zapatos
        adapter.setData(listadoZapatosVentas)
        adapter.callback = this
        binding.recyclerView.adapter = adapter

        binding.carritoCompras2B.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_carritoFragment)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = RecyclerFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
    }

    override fun showInfoFragmen(zapato: Zapato) {
        val bundle = Bundle()
        bundle.putString("nombre", zapato.nombre.toString())
        bundle.putString("url", zapato.url.toString())
        bundle.putString("precio", zapato.precio.toString())
        findNavController().navigate(R.id.action_recyclerFragment_to_infoFragment, bundle)
        Log.e("bind: ", zapato.nombre)

    }

}