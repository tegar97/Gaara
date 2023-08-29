package com.example.gaara

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Outfit(
    val name : String,
    val price : String,
    val image : Int ,
    val description : String,
    val brand : String ,
    val size : String,



) : Parcelable
