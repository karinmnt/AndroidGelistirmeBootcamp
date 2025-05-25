package com.example.yemeksipariset.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriler")
data class Favoriler (@PrimaryKey @ColumnInfo(name = "yemek_id")
                      val yemek_id: Int,
                      @ColumnInfo(name = "yemek_adi")  val yemek_adi:String,
                      @ColumnInfo(name = "yemek_resim_adi") val yemek_resim_adi:String,
                      @ColumnInfo (name="yemek_fiyat") val yemek_fiyat:Int){}