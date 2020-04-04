package com.kenova.clipboard

import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kenova.clipboard.adapters.ClipAdapter
import com.kenova.clipboard.models.Clip
import com.kenova.clipboard.models.Supplier
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = ClipAdapter(this, Supplier.clips)
        recyclerView.adapter = adapter

        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.addPrimaryClipChangedListener {
            val textToPaste: String = clipboard.primaryClip?.getItemAt(0)?.text.toString().trim()
            Supplier.clips.toMutableList().add(Clip(textToPaste,""))
        }

    }
}
