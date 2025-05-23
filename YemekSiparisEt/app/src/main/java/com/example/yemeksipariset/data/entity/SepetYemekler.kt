package com.example.yemeksipariset.data.entity

import java.io.Serializable

class SepetYemekler (var sepet_yemek_id : Int,
             var yemek_adi : String,
             var yemek_resim_adi : String,
             var yemek_fiyat : Int,
             var yemek_siparis_adet : String,
             var kullanici_adi : String) : Serializable {
}