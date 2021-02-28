package com.example.swipertestdemo.wallet.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WalletShowsResponse(
    val id: Long,
    val name: String,
    val image: Image,
    val summary: String
) : Parcelable {
    @Parcelize
    data class Image(
        val medium: String,
        val original: String
    ) : Parcelable
}

fun List<WalletShowsResponse>.asDatabaseModel(): Array<WalletShowsEntity> {
    return map {
        WalletShowsEntity(
            id = it.id,
            name = it.name,
            image = WalletShowsEntity.DatabaseImage(
                medium = it.image.medium,
                original = it.image.original
            ),
            summary = it.summary
        )
    }.toTypedArray()
}