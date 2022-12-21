package com.example.aplikasi_music

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class RecycleViewAdapter(private val musiclist : ArrayList<data_music>) :
    RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder>() {

    private lateinit var listnercard : onclicllistener

    interface onclicllistener{

        fun onpitez(urutan : Int)

    }
    fun setonclixk(isa: onclicllistener){
        listnercard = isa

    }

    class MyViewHolder(itemView: View,isa: onclicllistener) : RecyclerView.ViewHolder(itemView){
    val judul : TextView = itemView.findViewById(R.id.judul2)
        val album : TextView = itemView.findViewById(R.id.album)
        val card : CardView = itemView.findViewById(R.id.cardgg);
init {
    itemView.setOnClickListener(){
        isa.onpitez(adapterPosition)
    }
}
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
      val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return MyViewHolder(itemView,listnercard);
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemee = musiclist[position]
        holder.judul.text = itemee.judulmsk
        holder.album.text = itemee.album


    }

    override fun getItemCount(): Int {
        return musiclist.size
    }





}
