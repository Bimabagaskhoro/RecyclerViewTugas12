package com.bimabagaskhoro.recyclerviewtugas12

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    var name: String,
    var price: String,
    var avatar: String
): Parcelable
