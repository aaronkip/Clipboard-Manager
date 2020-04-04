package com.kenova.clipboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kenova.clipboard.R
import com.kenova.clipboard.models.Clip
import kotlinx.android.synthetic.main.list_item.view.*

class ClipAdapter(val context: Context,val clips: List<Clip>): RecyclerView.Adapter<ClipAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClipAdapter.MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }
    override fun getItemCount(): Int {
        return clips.size
    }

    override fun onBindViewHolder(holder: ClipAdapter.MyViewHolder, position: Int) {
        val clip = clips[position]
        holder.setData(clip, position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun setData(clip: Clip?, pos: Int){
            itemView.itemTitle.text = clip!!.title
        }
    }
}