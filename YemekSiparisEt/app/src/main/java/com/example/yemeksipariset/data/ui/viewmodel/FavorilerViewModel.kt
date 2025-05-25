package com.example.yemeksipariset.data.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksipariset.data.entity.Favoriler
import com.example.yemeksipariset.data.repo.FavorilerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavorilerViewModel @Inject constructor(private val favorilerRepo: FavorilerRepo) : ViewModel(){

    val favoriListesi = MutableLiveData<List<Favoriler>>()

    fun favorileriYukle(){
        viewModelScope.launch {
            favoriListesi.value = favorilerRepo.getFavoriler()
            Log.d("favoi yükle","favoriler: ${favoriListesi.value}")
        }
    }

    fun favoriEkle(yemekler:Favoriler){
        viewModelScope.launch {
            favorilerRepo.favoriEkle(yemekler)
            favorileriYukle()
        }
    }

    fun favoriSil(yemekler: Favoriler){
        viewModelScope.launch {
            favorilerRepo.favoriSil(yemekler)
            favorileriYukle()
        }
    }

    fun favorileriKontrolEt(id:Int, onSonuc: ( Boolean) -> Unit){
        viewModelScope.launch {
            val favVarMi = favorilerRepo.favoriVarMi(id)
            onSonuc(favVarMi)
        }
    }


}