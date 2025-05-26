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
import com.example.yemeksipariset.data.ui.viewmodel.SepetViewModel
import com.example.yemeksipariset.databinding.FragmentYemekDetayBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class YemekDetayFragment : Fragment() {

    private lateinit var binding: FragmentYemekDetayBinding
    private val viewModel: SepetViewModel by viewModels()
    private var adet = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYemekDetayBinding.inflate(inflater,container, false)

        val bundle:YemekDetayFragmentArgs by navArgs()
        val yemek = bundle.yemekNesnesi
        binding.detayYemek = yemek


        val resimAdi = yemek.yemek_resim_adi.removeSuffix(".png")
        val resimId = resources.getIdentifier(resimAdi,"drawable",requireContext().packageName)

        binding.ivYemekDetay.setImageResource(resimId)

        binding.ivGeri.setOnClickListener {
            val gecis = YemekDetayFragmentDirections.gecisDetayAna()
            Navigation.findNavController(it).navigate(gecis)
        }

        binding.buttonArti.setOnClickListener {
            adet++
            binding.tvAdet.text=adet.toString()
            binding.tvFiyatDetay.text = (yemek.yemek_fiyat.toInt()*adet).toString()
        }
        binding.buttonEksi.setOnClickListener {
            if (adet >1){
                adet--
                binding.tvAdet.text=adet.toString()
                binding.tvFiyatDetay.text=(yemek.yemek_fiyat.toInt()*adet).toString()
            }else{
                Snackbar.make(it,"Adet 1'den az olamaz!", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.buttonSepeteEkle.setOnClickListener {

            viewModel.sepeteEkleVeyaGuncelle(yemek, adet, "karin")

            Snackbar.make(it,"${yemek.yemek_adi} sepete eklendi.", Snackbar.LENGTH_SHORT).show()

        }



        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepettenGetir("karin")
    }

}