package com.example.odev7.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odev7.databinding.FragmentAnasayfaBinding
import com.example.odev7.ui.viewmodel.AnasayfaViewModel
import com.example.odev7.utils.gecisYap
import com.example.odev7.R
import com.example.odev7.ui.adapter.YapilacaklarAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.fab.setOnClickListener {
            Navigation.gecisYap(it,R.id.yapilacaklarKayitGecis)
        }

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val yapilacaklarAdapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            binding.yapilacaklarRv.adapter = yapilacaklarAdapter
        }

        binding.yapilacaklarRv.layoutManager = LinearLayoutManager(requireContext())

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {//Harf girdikçe ve sildikçe
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//Ara buttonuna basılınca
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }

    }

