package com.kenova.clipboard.models

data class Clip(var title: String, var content: String) {

}

public object Supplier {

    //Todo: Replace model with live db
    val clips = listOf<Clip>(

        Clip("ClipData1","This is the content of the first index clipboard"),
        Clip("ClipData2","Dummy content of the second index clipboard"),
        Clip("ClipData3","Example data for the third index clipboard, extending this to a more longer text will be worthwhile in testing the text support height of the recycler view item. Hope this is long enough")
    )
}