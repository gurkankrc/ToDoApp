package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.data.entity.Yapilacaklar

@Dao
interface YapilacaklarDao {

    @Query("SELECT * FROM yapilacaklar")
    suspend fun tumYapilacaklar():List<Yapilacaklar>

    @Insert
    suspend fun yapilacaklarEkle(yapilacak:Yapilacaklar)

    @Update
    suspend fun yapilacaklarGuncelle(yapilacak:Yapilacaklar)

    @Delete
    suspend fun yapilacaklarSil(yapilacak:Yapilacaklar)

    @Query("SELECT * FROM yapilacaklar WHERE yapilacaklar_ad like '%' || :aramaKelimesi ||'%'")
    suspend fun yapilacaklarAra(aramaKelimesi:String):List<Yapilacaklar>
}