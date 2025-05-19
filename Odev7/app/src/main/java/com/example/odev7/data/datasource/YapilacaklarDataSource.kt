package com.example.odev7.data.datasource

import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.room.YapilacaklarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YapilacaklarDataSource(var yapilacaklarDao: YapilacaklarDao) {
    suspend fun kaydet(yapilacaklar_ad: String){
        val yeniYapilacak = Yapilacaklar(0,yapilacaklar_ad)
        yapilacaklarDao.kaydet(yeniYapilacak)
    }

    suspend fun guncelle(yapilacaklar_id:Int,yapilacaklar_ad: String){
        val guncellenenYapilacak = Yapilacaklar(yapilacaklar_id,yapilacaklar_ad)
        yapilacaklarDao.guncelle(guncellenenYapilacak)
    }

    suspend fun sil(yapilacaklar_id:Int){
        val silinenYapilacak = Yapilacaklar(yapilacaklar_id,"")
        yapilacaklarDao.sil(silinenYapilacak)
    }

    suspend fun yapilacaklarYukle() : List<Yapilacaklar> = withContext(Dispatchers.IO) {
        return@withContext  yapilacaklarDao.yapilacaklarYukle()
    }

    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar> = withContext(Dispatchers.IO) {


        return@withContext  yapilacaklarDao.ara(aramaKelimesi)
    }
}