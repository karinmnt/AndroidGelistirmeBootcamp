package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksipariset.R
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.entity.Siparis
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.ui.adapter.SepetAdapter
import com.example.yemeksipariset.data.ui.adapter.SepettenSil
import com.example.yemeksipariset.data.ui.viewmodel.SepetViewModel
import com.example.yemeksipariset.databinding.FragmentSepetBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment(),SepettenSil {

    private lateinit var binding: FragmentSepetBinding
    private val viewModel : SepetViewModel by viewModels()
    private lateinit var SepetAdapter : SepetAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSepetBinding.inflate(inflater,container,false)


        viewModel.sepettenGetir("karin")

        binding.rvSepet.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        SepetAdapter = SepetAdapter(requireContext(), listOf(),this)
        binding.rvSepet.adapter = SepetAdapter



        viewModel.sepetListesi.observe(viewLifecycleOwner){liste ->

                SepetAdapter.updateList(liste)

                val ToplamFiyat = liste.sumOf {
                    val adet = it.yemek_siparis_adet.toIntOrNull() ?: 0
                    adet * it.yemek_fiyat
                }
                binding.tvSepetFiyat.text="$ToplamFiyat ₺"

            binding.tvBosSiparis.visibility = if (liste.isEmpty()) View.VISIBLE else View.GONE
        }


        viewModel.sepettenGetir("karin")

        binding.buttonSepetiOnayla.setOnClickListener {
            val kullaniciAdi = "karin"
            val sepetList = viewModel.sepetListesi.value ?: listOf()

            // 1. Siparişleri Room'a kaydet
            for (item in sepetList) {
                val adet = item.yemek_siparis_adet.toIntOrNull() ?: 1
                val toplamFiyat = adet * item.yemek_fiyat
                val siparis = Siparis(
                    yemek_id = item.sepet_yemek_id,
                    yemek_adi = item.yemek_adi,
                    yemek_resim_adi = item.yemek_resim_adi,
                    toplam_fiyat = toplamFiyat,
                    yemek_adet = adet
                )
                viewModel.siparisEkle(siparis)
            }

            // 2. Sepeti temizle (sunucudan sil)
            for (item in sepetList) {
                viewModel.sepettenSil(item.sepet_yemek_id.toInt(), kullaniciAdi)
            }

            // 3. Kullanıcıya bilgi ver
            Toast.makeText(requireContext(), "Sipariş oluşturuldu. Sepet temizlendi.", Toast.LENGTH_SHORT).show()

        }

        val toolbar = binding.toolbarSepet
        (requireActivity() as AppCompatActivity).setSupportActionBar(toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        (requireActivity() as AppCompatActivity).supportActionBar?.setDisplayShowTitleEnabled(true)

        toolbar.setNavigationOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()
        }






        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.sepettenGetir("karin")
    }

    override fun sepettenSil(sepetYemekId: Int) {
        viewModel.sepettenSil(sepetYemekId,"karin")
    }


}