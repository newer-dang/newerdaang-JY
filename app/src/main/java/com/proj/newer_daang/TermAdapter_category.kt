package com.proj.newer_daang

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TermAdapter_category(private val context: Context) : RecyclerView.Adapter<TermAdapter_category.ViewHolder>(){
    var cateList = mutableListOf<CateData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermAdapter_category.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_category,parent,false)
        return ViewHolder(view)


    }

    override fun getItemCount(): Int = cateList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cateList[position])
    }


    interface OnItemClickListener{
        fun onItemClick(v:View, data: CateData, pos: Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTerm: TextView = itemView.findViewById(R.id.term_name)

        fun bind(item: CateData) {
            tvTerm.text = item.name
            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }

        }



    }
    data class CateData (
        val name : String
    )

}