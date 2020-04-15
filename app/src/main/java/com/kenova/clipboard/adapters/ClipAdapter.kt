package com.kenova.clipboard.adapters

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.kenova.clipboard.R
import com.kenova.clipboard.models.Clip
import kotlinx.android.synthetic.main.list_item.view.*
import java.security.AccessController.getContext

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

        var clipData: Clip? = null
        var currentPosition: Int = 0
        init {

            itemView.shareItem.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, clipData!!.content )
                intent.type="text/plain"

                context.startActivity(Intent.createChooser(intent, "Share with:"))
            }

            itemView.setOnClickListener {
                //Todo: Research on inserting text to clipboard using clipdata format
                val data = ClipData.newPlainText("data",clipData!!.content)
                val clipboard = CLIPBOARD_SERVICE as ClipboardManager
                clipboard.setPrimaryClip(data)

            }
        }

        fun setData(clip: Clip?, pos: Int){
            itemView.itemTitle.text = clip!!.title
            itemView.itemContent.text = clip!!.content
            this.clipData = clip
            this.currentPosition = pos
        }
    }
}
