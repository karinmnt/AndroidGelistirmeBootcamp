package com.example.yemeksipariset.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yemeksipariset.data.entity.Favoriler
import com.example.yemeksipariset.data.entity.Siparis

@Database(entities = [Favoriler::class, Siparis::class], version =3)
abstract class Veritabani : RoomDatabase() {

    abstract fun getFavorilerDao() : FavorilerDao
    abstract fun getSiparisDao() : SiparisDao
}