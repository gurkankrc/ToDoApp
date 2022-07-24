package com.example.todoapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.YapilacaklarDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetayFragmentViewModel @Inject constructor(var krepo:YapilacaklarDaoRepository):ViewModel() {



    fun guncelle(yapilacak_id:Int,yapilacak_ad:String){

        krepo.yapilacakGuncelle(yapilacak_id,yapilacak_ad)


    }
}