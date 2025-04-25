package com.example.myapplication.nesne_tabanli_programlama

fun main() {
    //Soru 1
    val odev = Odev2Class()
    val fahrenheit = odev.celsiusToFahrenheit(25.3)
    println("25.3°C = $fahrenheit °F")

    //Soru 2
    val dikdortgenCevresi = odev.dikdortgeninCevresiHesapla(12.3,20.6)
    println("Dikdörtgenin Çevresi = $dikdortgenCevresi")

    //Soru 3
    val faktoriyel = odev.faktoriyelHesapla(5)
    println("Faktoriyel sonucu = $faktoriyel")

    //Soru 4

    val kacTaneAVar = odev.kacAVar("Ağaç Kakan")
    println("A adeti :$kacTaneAVar")

    //Soru 1

    val icAcilarToplami = odev.icAciToplami(5)
    println("İç açılar toplamı = $icAcilarToplami")

    //Soru 2
    val maas = odev.maasHesapla(27)
    println("Maaş = $maas")

    //Soru 3
    val ucret = odev.ucretHesapla(126)
    println("ücret = $ucret")
}