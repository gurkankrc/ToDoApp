package com.example.todoapp.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.entity.Yapilacaklar
import com.example.todoapp.room.YapilacaklarDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacaklarDaoRepository(var kdao:YapilacaklarDao) {

    var yapilcaklarListesi :MutableLiveData<List<Yapilacaklar>>
    init {
        yapilcaklarListesi = MutableLiveData()
    }

    fun yapilacaklariGetir():MutableLiveData<List<Yapilacaklar>>{
        return yapilcaklarListesi
    }

    fun yapilacalarKayit(yapilacak_ad:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
           val yeniYapilacak =Yapilacaklar(0,yapilacak_ad)
            kdao.yapilacaklarEkle(yeniYapilacak)

        }
    }

    fun yapilacakGuncelle(yapilacak_id:Int,yapilacak_ad:String){

        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenYapilacak =Yapilacaklar(yapilacak_id,yapilacak_ad)
            kdao.yapilacaklarGuncelle(guncellenenYapilacak)

        }


    }

    fun yapilacakAra(aramaKelimesi:String){

        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilcaklarListesi.value = kdao.yapilacaklarAra(aramaKelimesi)
        }

    }

    fun yapilacakSil(yapilacak_id:Int){

        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenYapilacak =Yapilacaklar(yapilacak_id,"")
            kdao.yapilacaklarSil(silinenYapilacak)
            tumYapilacklariAl()

        }
    }

    fun tumYapilacklariAl(){

        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilcaklarListesi.value = kdao.tumYapilacaklar()
        }

    }
}