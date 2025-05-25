package com.example.yemeksipariset.data.repo

import com.example.yemeksipariset.data.entity.Siparis
import com.example.yemeksipariset.data.room.SiparisDao
import javax.inject.Inject

class SiparisRepo @Inject constructor(private val siparisDao : SiparisDao) {
    fun siparisleriGetir() = siparisDao.tumSiparisleriGetir()
    suspend fun siparisEkle(siparis: Siparis)=siparisDao.siparisEkle(siparis)
    suspend fun tumSiparisleriSil() = siparisDao.tumSiparisleriSil()
}