package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.Yapilacaklar
import com.example.todoapp.databinding.CardTasarimiBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaFragmentViewModel
import com.example.todoapp.utils.gecisYap
import com.google.android.material.snackbar.Snackbar

class YapilacaklarAdapter(var mContext: Context,
                          var yapilacaklarListesi:List<Yapilacaklar>,
                          var viewModel:AnasayfaFragmentViewModel):RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimiBinding):RecyclerView.ViewHolder(tasarim.root)
    {
        var tasarim:CardTasarimiBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutinflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimiBinding = DataBindingUtil.inflate(layoutinflater,
            R.layout.card_tasarimi,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacaklar = yapilacaklarListesi.get(position)
        val t =holder.tasarim
        t.yapilacaklarNesnesi = yapilacaklar
        t.SatirCard.setOnClickListener {

            val gecis = AnasayfaFragmentDirections.detayGecis(yapilacak = yapilacaklar)
            Navigation.gecisYap(it,gecis)

        }

        t.imageViewSil.setOnClickListener {

            Snackbar.make(it,"${yapilacaklar.yapilacalar_ad} iş silinsin mi ?",Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacaklar.yapilacaklar_id)
                }.show()

        }
    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }


}