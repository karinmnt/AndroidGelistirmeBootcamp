package com.example.yemeksipariset.data.di

import com.example.yemeksipariset.data.datasource.YemeklerDataSource
import com.example.yemeksipariset.data.repo.YemeklerRepo
import com.example.yemeksipariset.data.retrofit.ApiUtils
import com.example.yemeksipariset.data.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
}