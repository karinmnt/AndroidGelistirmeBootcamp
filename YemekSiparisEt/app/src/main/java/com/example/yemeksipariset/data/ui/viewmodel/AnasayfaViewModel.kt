package com.example.yemeksipariset.data.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.repo.YemeklerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var yemeklerRepo: YemeklerRepo) : ViewModel(){
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
    }
    fun yemekleriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                yemeklerListesi.value = yemeklerRepo.yemekleriYukle()

            }catch (e:Exception){}
        }

    }
}