package com.example.yemeksipariset.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yemeksipariset.data.entity.Favoriler

@Dao
interface FavorilerDao {

    @Query("SELECT * FROM favoriler")
    suspend fun getFavoriler(): List<Favoriler>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun favoriEkle(favoriler: Favoriler)

    @Delete
    suspend fun favoriSil(favoriler: Favoriler)

    @Query("SELECT * FROM favoriler WHERE yemek_id = :id")
    suspend fun favoriVarMi(id:Int) : Favoriler?
}