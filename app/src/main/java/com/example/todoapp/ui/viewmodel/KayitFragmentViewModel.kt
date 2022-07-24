package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KayitFragmentViewModel  @Inject constructor(var krepo:YapilacaklarDaoRepository):ViewModel() {



    fun kayit(yapilacak_ad:String){

        krepo.yapilacalarKayit(yapilacak_ad)

    }
}