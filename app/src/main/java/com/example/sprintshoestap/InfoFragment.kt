package com.example.sprintshoestap

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.sprintshoestap.databinding.FragmentInfoBinding
import android.content.SharedPreferences
import kotlinx.coroutines.SupervisorJob

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var mSharedPreferences: SharedPreferences
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString("nombre")
            param2 = it.getString("url")
            param3 = it.getString("precio")
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mSharedPreferences = requireActivity().applicationContext.getSharedPreferences("cookie", Context.MODE_PRIVATE)

        binding = FragmentInfoBinding.inflate(LayoutInflater.from(activity))
        initAdapter()
               binding.agregarCarritoB.setOnClickListener{
                mSharedPreferences.edit().putString(param1,param1).apply()
                   Log.e("bind: ","baandfsdfa" )

        }


        return (binding.root)
    }

        fun initAdapter(){
          binding.nombreInfoTxt.text = " $param1"
          binding.imaInfoZapato.load(param2)
          binding.precioInfoTxt.text = "$ $param3"
         }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InfoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}