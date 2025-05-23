package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yemeksipariset.R
import com.example.yemeksipariset.data.ui.viewmodel.SepetViewModel
import com.example.yemeksipariset.databinding.FragmentYemekDetayBinding


class YemekDetayFragment : Fragment() {

    private lateinit var binding: FragmentYemekDetayBinding
    private val viewModel: SepetViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYemekDetayBinding.inflate(inflater, container, false)

        val bundle:YemekDetayFragmentArgs by navArgs()
        val yemek = bundle.yemekNesnesi


        val resimAdi = yemek.yemek_resim_adi.removeSuffix(".png")
        val resimId = resources.getIdentifier(resimAdi,"drawable",requireContext().packageName)

        binding.ivYemekDetay.setImageResource(resimId)



        return binding.root
    }

}