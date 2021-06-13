package com.suleymanoner.carapp.model

import android.os.Parcel
import android.os.Parcelable
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

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(price)
        parcel.writeString(type)
        parcel.writeString(seat)
        parcel.writeString(mpg)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cars> {
        override fun createFromParcel(parcel: Parcel): Cars {
            return Cars(parcel)
        }

        override fun newArray(size: Int): Array<Cars?> {
            return arrayOfNulls(size)
        }
    }
}