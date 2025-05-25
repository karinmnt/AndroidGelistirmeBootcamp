package com.example.yemeksipariset.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.yemeksipariset.data.entity.Siparis

@Dao
interface SiparisDao {

    @Insert
    suspend fun siparisEkle(siparis: Siparis)

    @Query("SELECT * FROM siparisler ORDER BY yemek_id DESC")
    fun tumSiparisleriGetir(): LiveData<List<Siparis>>

    @Query("DELETE FROM siparisler")
    suspend fun tumSiparisleriSil()
}
