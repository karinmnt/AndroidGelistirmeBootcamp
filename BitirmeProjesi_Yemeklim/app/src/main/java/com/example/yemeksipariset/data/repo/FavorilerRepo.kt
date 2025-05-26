package com.example.yemeksipariset.data.repo

import com.example.yemeksipariset.data.entity.Favoriler
import com.example.yemeksipariset.data.room.FavorilerDao
import javax.inject.Inject

class FavorilerRepo @Inject constructor(private val favorilerDao : FavorilerDao) {
    suspend fun favoriEkle(yemekler:Favoriler){
        favorilerDao.favoriEkle(yemekler)
    }

    suspend fun favoriSil(yemekler: Favoriler){
        favorilerDao.favoriSil(yemekler)
    }

    suspend fun getFavoriler() : List<Favoriler>{
        return favorilerDao.getFavoriler()
    }

    suspend fun favoriVarMi(id:Int) : Boolean{
        return favorilerDao.favoriVarMi(id) != null
    }
}