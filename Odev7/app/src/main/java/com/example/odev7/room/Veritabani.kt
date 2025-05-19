package com.example.odev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.odev7.data.entity.Yapilacaklar
import com.example.odev7.room.YapilacaklarDao

@Database(entities = [Yapilacaklar::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getYapilacaklarDao() : YapilacaklarDao
}

