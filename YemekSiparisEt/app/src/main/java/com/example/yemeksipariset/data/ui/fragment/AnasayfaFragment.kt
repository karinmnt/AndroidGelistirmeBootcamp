package com.example.yemeksipariset.data.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.ui.adapter.YemeklerAdapter
import com.example.yemeksipariset.data.ui.viewmodel.AnasayfaViewModel
import com.example.yemeksipariset.databinding.FragmentAnasayfaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private val viewModel: AnasayfaViewModel by viewModels()
    private lateinit var adapter: YemeklerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        adapter = YemeklerAdapter(
            requireContext(),
            mutableListOf(),
            viewModel
        ){yemek ->
            val gecis = AnasayfaFragmentDirections.gecisDetay(yemek)
            findNavController().navigate(gecis)

        }
        binding.yemeklerRv.adapter = adapter

        binding.yemeklerRv.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)

        viewModel.yemeklerListesi.observe(viewLifecycleOwner){liste->
            adapter.updateYemekList(liste)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                ara(newText.orEmpty())
                return true
            }

        })



        return binding.root
    }


    private fun ara(arananKelime:String){
        val filitreListe = viewModel.yemeklerListesi.value?.filter {
            it.yemek_adi.contains(arananKelime, ignoreCase = true)
        } ?: emptyList()

        adapter.updateYemekList(filitreListe)


    }


    override fun onResume() {
        super.onResume()
        viewModel.yemekleriYukle()    }

}