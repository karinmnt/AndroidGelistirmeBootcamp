package com.example.odev7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.odev7.ui.viewmodel.YapilacaklarDetayViewModel
import com.example.odev7.databinding.FragmentYapilacaklarDetayBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class YapilacaklarDetayFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaklarDetayBinding
    private lateinit var viewModel: YapilacaklarDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacaklarDetayBinding.inflate(inflater, container, false)
        val bundle: YapilacaklarDetayFragmentArgs by navArgs()
        val gelenYapilacak = bundle.yapilacaklar

        binding.editTextYapilacaklar.setText(gelenYapilacak.yapilacaklar_ad)

        binding.buttonGuncelle.setOnClickListener {
            val yapilacaklar_ad = binding.editTextYapilacaklar.text.toString()

            viewModel.guncelle(gelenYapilacak.yapilacaklar_id,yapilacaklar_ad)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
}