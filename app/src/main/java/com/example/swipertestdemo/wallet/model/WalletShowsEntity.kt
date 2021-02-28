package com.example.swipertestdemo.wallet.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class WalletShowsEntity(
    @PrimaryKey val id: Long,
    val name: String,
    @Embedded val image: DatabaseImage,
    val summary: String
) {
    class DatabaseImage(
        val medium: String,
        val original: String
    )
}

fun List<WalletShowsEntity>.asDomainModel(): List<WalletShowsResponse> {
    return map {
        WalletShowsResponse(
            id = it.id,
            name = it.name,
            image = WalletShowsResponse.Image(
                medium = it.image.medium,
                original = it.image.original
            ),
            summary = it.summary
        )
    }
}