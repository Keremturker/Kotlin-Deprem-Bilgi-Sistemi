package com.keremturker.deprembilgisistemi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.keremturker.deprembilgisistemi.model.Deprem
import com.keremturker.deprembilgisistemi.R

class DepremAdapter(val deprem_List: ArrayList<Deprem>) :
    RecyclerView.Adapter<DepremAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_deprem, parent, false)

        return ViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.txt_tarih.text= deprem_List[position].tarih
        holder.txt_yer.text= deprem_List[position].yer
        holder.txt_siddet.text= deprem_List[position].buyukluk
        holder.txt_derinlik.text= deprem_List[position].derinlik

    }

    override fun getItemCount(): Int {

        return deprem_List.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txt_tarih = itemView.findViewById<TextView>(R.id.txttarih)
        val txt_yer = itemView.findViewById<TextView>(R.id.txtyer)
        val txt_siddet = itemView.findViewById<TextView>(R.id.txtsiddet)
        val txt_derinlik = itemView.findViewById<TextView>(R.id.txtderinlik)


    }


}