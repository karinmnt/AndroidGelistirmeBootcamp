package com.example.odev7.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev7.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao { //Dao : Database Access Object
    @Query("SELECT * FROM yapilacaklar")
    suspend fun yapilacaklarYukle() : List<Yapilacaklar>

    @Insert
    suspend fun kaydet(yapilacaklar: Yapilacaklar)

    @Update
    suspend fun guncelle(yapilacaklar: Yapilacaklar)

    @Delete
    suspend fun sil(yapilacaklar:Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacaklar_ad LIKE '%'|| :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Yapilacaklar>
}