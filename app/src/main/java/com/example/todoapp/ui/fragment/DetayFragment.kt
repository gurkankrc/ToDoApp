package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetayBinding
import com.example.todoapp.ui.viewmodel.DetayFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var tasarim:FragmentDetayBinding
    private lateinit var viewModel:DetayFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay ,container, false)

        tasarim.detayFragment = this
        tasarim.detayToolbarBaslik = "Yapılacak İş Detay"


        val bundle:DetayFragmentArgs by navArgs()
        val gelenyapilacak = bundle.yapilacak
        tasarim.yapilacaklarnesnesi = gelenyapilacak


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayFragmentViewModel by viewModels()
        viewModel =tempViewModel
    }

    fun buttonGuncelle(yapilacak_id:Int,yapilacak_ad:String){

        viewModel.guncelle(yapilacak_id,yapilacak_ad)


    }

}