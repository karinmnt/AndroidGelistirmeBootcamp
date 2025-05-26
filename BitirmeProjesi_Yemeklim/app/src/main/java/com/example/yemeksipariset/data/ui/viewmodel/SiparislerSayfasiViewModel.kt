package com.example.yemeksipariset.data.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksipariset.data.entity.Siparis
import com.example.yemeksipariset.data.repo.SiparisRepo
import com.example.yemeksipariset.data.room.SiparisDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SiparislerSayfasiViewModel @Inject constructor(
    private val siparisDao: SiparisDao
) : ViewModel() {

    val siparisListesi: LiveData<List<Siparis>> = siparisDao.tumSiparisleriGetir()

    fun siparisleriTemizle() {
        viewModelScope.launch {
            siparisDao.tumSiparisleriSil()
        }
    }
}