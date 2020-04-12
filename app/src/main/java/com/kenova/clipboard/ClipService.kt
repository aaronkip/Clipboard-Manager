package com.kenova.clipboard

import android.app.Service
import android.content.ClipboardManager
import android.content.ClipboardManager.OnPrimaryClipChangedListener
import android.content.Context
import android.content.Intent
import android.os.IBinder
import com.kenova.clipboard.models.Clip
import com.kenova.clipboard.models.Supplier
import java.util.concurrent.Executors

class ClipService : Service() {
    private val mThreadPool = Executors.newSingleThreadExecutor()
    private var mClipboardManager: ClipboardManager? = null

    override fun onCreate() {
        super.onCreate()
        mClipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        assert(mClipboardManager != null)
        mClipboardManager!!.addPrimaryClipChangedListener(
            mOnPrimaryClipChangedListener
        )
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private val mOnPrimaryClipChangedListener = OnPrimaryClipChangedListener {
            val clipdata = mClipboardManager!!.primaryClip!!.getItemAt(0).text.toString().trim()
            Supplier.clips.toMutableList().add(Clip(clipdata,clipdata))
    }

}