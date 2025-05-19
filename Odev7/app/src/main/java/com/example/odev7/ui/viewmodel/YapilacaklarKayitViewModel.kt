package com.example.odev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.odev7.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class YapilacaklarKayitViewModel @Inject constructor(var yapilacaklarRepository:YapilacaklarRepository) : ViewModel() {

    fun kaydet(yapilacaklar_ad: String){
        CoroutineScope(Dispatchers.Main).launch {
            yapilacaklarRepository.kaydet(yapilacaklar_ad)
        }
    }
}