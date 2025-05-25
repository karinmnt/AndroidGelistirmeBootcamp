package com.example.yemeksipariset.data.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yemeksipariset.data.entity.SepetYemekler
import com.example.yemeksipariset.data.entity.Siparis
import com.example.yemeksipariset.data.entity.Yemekler
import com.example.yemeksipariset.data.repo.YemeklerRepo
import com.example.yemeksipariset.data.room.SiparisDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SepetViewModel @Inject constructor(var yemeklerRepo: YemeklerRepo, var siparisDao: SiparisDao) : ViewModel() {

    var sepetListesi = MutableLiveData<List<SepetYemekler>>()

    fun sepettenGetir(kullaniciAdi: String) {
        viewModelScope.launch {
            try {
                val gosterSepet = yemeklerRepo.sepettenGetir(kullaniciAdi)
                Log.e("sepetviewmodel", "Güncel sepet: $gosterSepet")
                sepetListesi.value=gosterSepet
            }catch (e:Exception){
                Log.e("sepetviewmodel","Hata:${e.message}")
            }
        }
    }

    fun sepettenSil(sepetYemekId:Int,kullaniciAdi: String){
        viewModelScope.launch {
            val cevap = yemeklerRepo.sepettenSil(sepetYemekId,kullaniciAdi)
            sepettenGetir(kullaniciAdi)

        }
    }

    fun sepeteEkle(yemek:Yemekler,adet:Int,kullaniciAdi: String){
        viewModelScope.launch {
            val cevap = yemeklerRepo.sepeteEkle(yemek,adet,kullaniciAdi)
            Log.e("sepeteEkle","Durum: ${cevap.success}, mesaj: ${cevap.message}")
            sepettenGetir(kullaniciAdi)
        }
    }

    fun sepeteEkleVeyaGuncelle(yemek: Yemekler, adet: Int, kullaniciAdi: String) {
        viewModelScope.launch {
            try {
                val mevcutSepet = try {
                    yemeklerRepo.sepettenGetir(kullaniciAdi)
                } catch (e: Exception) {
                    Log.e("HATA", "Sepet alınamadı: ${e.message}")
                    emptyList()
                }

                val varOlan = mevcutSepet.find { it.yemek_adi.equals(yemek.yemek_adi, ignoreCase = true) }
                Log.e("sepeteEkleGuncelle", "Sepette var mı? ${varOlan?.yemek_adi ?: "YOK"}")

                if (varOlan != null) {
                    val yeniAdet = varOlan.yemek_siparis_adet.toInt() + adet
                    yemeklerRepo.sepettenSil(varOlan.sepet_yemek_id.toInt(), kullaniciAdi)
                    yemeklerRepo.sepeteEkle(yemek, yeniAdet, kullaniciAdi)
                    Log.e("sepeteEkleGuncelle", "Var olan güncellendi: ${yemek.yemek_adi}, yeni adet: $yeniAdet")
                } else {
                    // Sepette yoksa doğrudan ekle
                    yemeklerRepo.sepeteEkle(yemek, adet, kullaniciAdi)
                    Log.e("sepeteEkleGuncelle", "Yeni eklendi: ${yemek.yemek_adi}, adet: $adet")
                }

                sepettenGetir(kullaniciAdi)
            } catch (e: Exception) {
                Log.e("sepeteEkleGuncelle", "Hata: ${e.message}")
            }
            sepettenGetir(kullaniciAdi)
        }
    }

    fun siparisEkle(siparis: Siparis){
        viewModelScope.launch {
            siparisDao.siparisEkle(siparis)
        }
    }



}