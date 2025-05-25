package com.example.yemeksipariset.data.di

import android.content.Context
import androidx.room.Room
import com.example.yemeksipariset.data.datasource.YemeklerDataSource
import com.example.yemeksipariset.data.repo.FavorilerRepo
import com.example.yemeksipariset.data.repo.YemeklerRepo
import com.example.yemeksipariset.data.retrofit.ApiUtils
import com.example.yemeksipariset.data.retrofit.YemeklerDao
import com.example.yemeksipariset.data.room.FavorilerDao
import com.example.yemeksipariset.data.room.SiparisDao
import com.example.yemeksipariset.data.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerRepo(yemeklerDataSource: YemeklerDataSource) : YemeklerRepo{
     return YemeklerRepo(yemeklerDataSource)
    }

    @Provides
    @Singleton
    fun provideYemeklerDataSource(yemeklerDao: YemeklerDao) : YemeklerDataSource{
        return YemeklerDataSource(yemeklerDao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }

    @Provides
    @Singleton
    fun provideFavorilerRep(favorilerDao: FavorilerDao) : FavorilerRepo{
        return FavorilerRepo(favorilerDao)
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): Veritabani {
        return Room.databaseBuilder(
            context,
            Veritabani::class.java,
            "yemeksiparis.sqlite"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavorilerDao(veritabani: Veritabani): FavorilerDao {
        return veritabani.getFavorilerDao()
    }


    @Provides
    @Singleton
    fun provideSiparisDao(veritabani: Veritabani): SiparisDao {
        return veritabani.getSiparisDao()
    }
}