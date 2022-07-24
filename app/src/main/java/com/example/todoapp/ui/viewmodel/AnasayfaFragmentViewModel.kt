package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Yapilacaklar
import com.example.todoapp.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaFragmentViewModel @Inject constructor(var krepo:YapilacaklarDaoRepository):ViewModel() {


    var yapilacaklarListesi =MutableLiveData<List<Yapilacaklar>>()

    init {
        yapilacaklariYukle()
        yapilacaklarListesi=krepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){

        krepo.yapilacakAra(aramaKelimesi)
    }

    fun sil(yapilacak_id:Int){
        krepo.yapilacakSil(yapilacak_id)
    }

    fun yapilacaklariYukle(){
        krepo.tumYapilacklariAl()
    }
}

