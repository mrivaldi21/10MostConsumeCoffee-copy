package com.rivaldi.a10mostconsumecoffee

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Coffe(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable
