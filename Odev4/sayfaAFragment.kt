package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.odev4.databinding.FragmentAnasayfaBinding
import com.example.odev4.databinding.FragmentSayfaABinding


class sayfaAFragment : Fragment() {

    private lateinit var binding: FragmentSayfaABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSayfaABinding.inflate(inflater, container, false)

        binding.buttonB.setOnClickListener {
            val gecisB = sayfaAFragmentDirections.sayfaBGecis()
            findNavController().navigate(gecisB)
        }

        return binding.root
    }


}