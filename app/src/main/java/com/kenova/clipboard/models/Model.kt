package com.kenova.clipboard.models

data class Clip(var title: String, var content: String) {

}

public object Supplier {
    val clips = listOf<Clip>(
        Clip("ClipData1","This is the content of the first index clipboard"),
        Clip("ClipData2","Dummy content of the second index clipboard"),
        Clip("ClipData3","Example data for the third index clipboard")
    )
}