package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksipariset.R
import com.example.yemeksipariset.data.ui.adapter.SiparisAdapter
import com.example.yemeksipariset.data.ui.viewmodel.SiparislerSayfasiViewModel
import com.example.yemeksipariset.databinding.FragmentSiparislerSayfasiBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SiparislerSayfasiFragment : Fragment() {

    private lateinit var binding: FragmentSiparislerSayfasiBinding
    private val viewModel: SiparislerSayfasiViewModel by viewModels()
    private lateinit var adapter: SiparisAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSiparislerSayfasiBinding.inflate(inflater, container, false)

        // Adapter kurulumu
        adapter = SiparisAdapter(requireContext(), listOf())
        binding.rvSiparisler.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSiparisler.adapter = adapter

        // LiveData gözlemi
        viewModel.siparisListesi.observe(viewLifecycleOwner) { liste ->
            adapter.updateList(liste)

            binding.tvBosSiparis.visibility = if (liste.isEmpty()) View.VISIBLE else View.GONE
        }

        // Temizleme butonu

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        // Eğer dinamik olarak yükleme gerekiyorsa burada yapılabilir.
    }
}

