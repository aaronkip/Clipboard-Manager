package com.kenova.clipboard.models

data class Clip(var title: String, var content: String) {

}

public object Supplier {
    val clips = listOf<Clip>(
        Clip("ClipData1",""),
        Clip("ClipData2",""),
        Clip("ClipData3","")
    )
}