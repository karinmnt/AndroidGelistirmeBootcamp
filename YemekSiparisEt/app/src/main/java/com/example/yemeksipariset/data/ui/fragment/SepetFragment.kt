package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.yemeksipariset.R
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.ui.adapter.SepetAdapter
import com.example.yemeksipariset.data.ui.adapter.SepettenSil
import com.example.yemeksipariset.data.ui.viewmodel.SepetViewModel
import com.example.yemeksipariset.databinding.FragmentSepetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment(),SepettenSil {

    private lateinit var binding: FragmentSepetBinding
    private val viewModel : SepetViewModel by viewModels()
    private lateinit var SepetAdapter:SepetAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetBinding.inflate(inflater,container,false)

        val bundle:YemekDetayFragmentArgs by navArgs()
        val yemek = bundle.yemekNesnesi

        viewModel.sepetiGoster("karin")

            viewModel.sepetListesi.observe(viewLifecycleOwner){liste ->

                SepetAdapter = SepetAdapter(requireContext(),liste,this)
                binding.rvSepet.adapter = SepetAdapter

                val ToplamFiyat = liste.sumOf {
                    val adet = it.yemek_siparis_adet.toIntOrNull() ?: 0
                    adet * it.yemek_fiyat
                }
                binding.tvSepetFiyat.text="$ToplamFiyat ₺"
            }

        binding.buttonSepetiOnayla.setOnClickListener {
            var gecis = SepetFragmentDirections.gecisSepettenSiparis()
            Navigation.findNavController(it).navigate(gecis)
        }

        binding.ivSepetGeri.setOnClickListener {
            var gecis = SepetFragmentDirections.gecisSpettenDetay(yemekNesnesi = yemek)
            Navigation.findNavController(it).navigate(gecis)
        }



        return binding.root
    }

    override fun sepettenSil(sepetYemekId: Int) {
        viewModel.sepettenSil(sepetYemekId,"karin")
    }


}