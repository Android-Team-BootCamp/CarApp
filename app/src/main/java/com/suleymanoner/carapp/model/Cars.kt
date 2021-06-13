package com.suleymanoner.carapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cars")
data class Cars(

    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    val name: String?= null,

    @SerializedName("price")
    val price: String?= null,

    @SerializedName("type")
    val type: String?= null,

    @SerializedName("seat")
    val seat: String?= null,

    @SerializedName("mpg")
    val mpg: String?= null,

    @SerializedName("image")
    val image: String?= null

)