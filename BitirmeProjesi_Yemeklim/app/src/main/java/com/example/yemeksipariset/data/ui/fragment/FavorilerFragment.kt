package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.ui.adapter.FavorilerAdapter
import com.example.yemeksipariset.data.ui.viewmodel.FavorilerViewModel
import com.example.yemeksipariset.databinding.FragmentFavorilerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavorilerFragment : Fragment() {

    private lateinit var binding: FragmentFavorilerBinding
    private val viewModel: FavorilerViewModel by viewModels()
    private lateinit var favAdapter: FavorilerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavorilerBinding.inflate(inflater, container, false)

        favAdapter = FavorilerAdapter(
            requireContext(),
            favoriListesi = listOf(),
            onFavorilerSil = { silinecekYemek ->
                viewModel.favoriSil(silinecekYemek)
            },
            onItemClick = { favori ->
                val yemek = Yemekler(
                    yemek_id = 0, // Eğer ID kullanılmıyorsa 0 geçilebilir
                    yemek_adi = favori.yemek_adi,
                    yemek_resim_adi = favori.yemek_resim_adi,
                    yemek_fiyat = favori.yemek_fiyat
                )

                val action = FavorilerFragmentDirections
                    .actionFavorilerFragmentToYemekDetayFragment(yemek)

                findNavController().navigate(action)
            }
        )

        binding.rvFavoriler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = favAdapter
        }

        viewModel.favoriListesi.observe(viewLifecycleOwner) { liste ->
            favAdapter.updateList(liste)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.favorileriYukle()
    }
}
