package com.example.odev7.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.odev7.R
import com.example.odev7.databinding.FragmentYapilacaklarKayitBinding
import com.example.odev7.ui.viewmodel.YapilacaklarKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class YapilacaklarKayitFragment : Fragment() {
    private lateinit var binding: FragmentYapilacaklarKayitBinding
    private lateinit var viewModel: YapilacaklarKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYapilacaklarKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val yapilacaklar_ad = binding.editTextYapilacaklar.text.toString()

            viewModel.kaydet(yapilacaklar_ad)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: YapilacaklarKayitViewModel by viewModels()
        viewModel = tempViewModel
    }


}