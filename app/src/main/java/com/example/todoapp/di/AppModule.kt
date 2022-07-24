package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.repo.YapilacaklarDaoRepository
import com.example.todoapp.room.Veritabani
import com.example.todoapp.room.YapilacaklarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarDaoRepository(kdao:YapilacaklarDao):YapilacaklarDaoRepository{
        return YapilacaklarDaoRepository(kdao)
    }


    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context:Context):YapilacaklarDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"yapilacaklar.sqlite")
            .createFromAsset("yapilacaklar.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}