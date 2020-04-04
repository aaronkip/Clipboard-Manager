package com.kenova.clipboard.models

data class Clip(var title: String, var content: String) {

}

object Supplier {
    val clips = listOf<Clip>()
}