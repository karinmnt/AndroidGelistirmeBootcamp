package com.example.yemeksipariset.data.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.repo.YemeklerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SepetViewModel @Inject constructor(var yemeklerRepo: YemeklerRepo) : ViewModel() {

    var sepetListesi = MutableLiveData<List<SepetYemekler>>()

    fun sepetiGoster(kullaniciAdi: String){
        viewModelScope.launch {
            try {
                var gosterSepet = yemeklerRepo.sepettenGetir(kullaniciAdi)
                sepetListesi.value=gosterSepet
            }catch (e:Exception){
                Log.e("sepetviewmodel","Hata:${e.message}")
            }
        }
    }

    fun sepettenSil(sepetYemekId:Int,kullaniciAdi: String){
        viewModelScope.launch {
            var cevap = yemeklerRepo.sepettenSil(sepetYemekId,kullaniciAdi)
            sepetiGoster(kullaniciAdi)

        }
    }

    fun sepeteEkle(yemek:Yemekler,adet:Int,kullaniciAdi: String){
        viewModelScope.launch {
            var cevap = yemeklerRepo.sepeteEkle(yemek,adet,kullaniciAdi)
            Log.e("sepeteEkle","Durum: ${cevap.succes}, mesaj: ${cevap.message}")
        }
    }

    fun sepeteEkleDuzen(yemek: Yemekler,kullaniciAdet:Int,kullaniciAdi: String){
        viewModelScope.launch {
            try {
                var mevcutSepet = yemeklerRepo.sepettenGetir(kullaniciAdi)

                var ayniYemek = mevcutSepet.find { it.yemek_adi == yemek.yemek_adi }

                if(ayniYemek != null) {
                    var oncekiAdet = ayniYemek.yemek_siparis_adet.toIntOrNull() ?: 0
                    var toplamAdet = oncekiAdet + kullaniciAdet

                    yemeklerRepo.sepettenSil(ayniYemek.sepet_yemek_id.toInt(),kullaniciAdi)

                    yemeklerRepo.sepeteEkle(yemek,toplamAdet,kullaniciAdi)
                    Log.e("sepeteEkle","Adet güncellendi: ${yemek.yemek_adi},adet:$kullaniciAdet")
                } else{
                    yemeklerRepo.sepeteEkle(yemek,kullaniciAdet,kullaniciAdi)
                    Log.e("sepeteEkle","${yemek.yemek_adi}, $kullaniciAdet adet eklendi.")
                }

                sepetiGoster(kullaniciAdi)
            }catch (e:Exception){
                Log.e("sepeteEkleHatasi","Hata: ${e.localizedMessage}")
            }
        }




    }
}