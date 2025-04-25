package com.example.myapplication.nesne_tabanli_programlama

class Odev2Class {
    //Soru1 celsius'tan F'a çeviren fonksiyon
    fun celsiusToFahrenheit(celsius:Double):Double{
        return celsius * 1.8 + 32
    }

    //Soru2 dikdörtgen çevresi hesaplama metodu
    fun dikdortgeninCevresiHesapla(kısaKenar:Double,uzunKenar:Double):Double{
        return 2*(kısaKenar + uzunKenar)
    }

    //Soru 3 sayının faktoriyel değerini hesaplayan metod
    fun faktoriyelHesapla(sayi:Int) : Int{
        var sonuc = 1
        for (i in 1..sayi){
            sonuc *=i
        }
        return sonuc
    }

    //Soru 4 kaç adet a harfi olduğunu gösteren metod
    fun kacAVar(kelime:String):Int{
        return kelime.count {it=='a' || it=='A'}
    }

    //Soru 1 kenar sayısına göre iç açılar toplamı hesaplayan metod
    fun icAciToplami(kenar_sayisi:Int):Int{
        return (kenar_sayisi-2)*180
    }

    //Soru 2 girilen gün sayısına göre maaş hesabı yapan metod

    fun maasHesapla(gunSayisi:Int): Int {
        val calismaSaati = gunSayisi * 8
        return if (calismaSaati <= 160) {
            calismaSaati * 10
        }
        else{
            val normalSaat =160
            val mesaiSaati = calismaSaati -160
            (normalSaat *10) + (mesaiSaati *20)
        }
    }

    //Soru 3 kota miktarına göre ücret hesaplama
    fun ucretHesapla(kotaMiktari:Int) : Int {
        return if (kotaMiktari <= 50) {
            100
        }
        else {
            val asimMiktari = kotaMiktari - 50
            100 + asimMiktari * 4
        }
    }
}