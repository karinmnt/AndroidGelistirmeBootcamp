package com.example.xbox.data.repository

import com.example.xbox.R
import com.example.xbox.data.model.GameItem

class GameRepository {

    fun getRecentlyAdded(): List<GameItem> {
        return listOf(
            GameItem(R.drawable.doom),
            GameItem(R.drawable.anno),
            GameItem(R.drawable.dredge),
            GameItem(R.drawable.clairobscure),
            GameItem(R.drawable.farcry)

        )

    }

    fun getPerks(): List<GameItem> {
        return listOf(
            // Perks için benzer GameItem listesi
        )
    }
}
