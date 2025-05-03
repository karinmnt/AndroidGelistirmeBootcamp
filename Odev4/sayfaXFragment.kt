package com.example.odev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.odev4.databinding.FragmentAnasayfaBinding
import com.example.odev4.databinding.FragmentSayfaXBinding


class sayfaXFragment : Fragment() {

    private lateinit var binding: FragmentSayfaXBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSayfaXBinding.inflate(inflater, container, false)

        binding.buttonYXSayfasi.setOnClickListener {
            val gecisXY = sayfaXFragmentDirections.sayfaYgecis()
            Navigation.findNavController(it).navigate(gecisXY)
        }

        return binding.root
    }

}