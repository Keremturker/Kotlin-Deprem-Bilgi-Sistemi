package com.keremturker.deprembilgisistemi.model

import com.google.gson.annotations.SerializedName

data class Deprem(
    @SerializedName("tarih") val tarih: String?,
    @SerializedName("saat") val saat: String?,
    @SerializedName("enlem") val enlem: String?,
    @SerializedName("boylam") val boylam: String?,
    @SerializedName("derinlik") val derinlik: String?,
    @SerializedName("buyukluk") val buyukluk: String?,
    @SerializedName("yer") val yer: String?,
    @SerializedName("sehir") val sehir: String?

)
