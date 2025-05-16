package com.example.xbox.ui.gamepass

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.xbox.data.model.GameItem
import com.example.xbox.data.repository.GameRepository

class GamePassViewModel(
    private val repo: GameRepository = GameRepository()
) : ViewModel() {

    private val _recent = MutableLiveData<List<GameItem>>()
    val recent: LiveData<List<GameItem>> = _recent

    private val _perks = MutableLiveData<List<GameItem>>()
    val perks: LiveData<List<GameItem>> = _perks

    init {
        // Fragment açılır açılmaz listeler hazır
        _recent.value = repo.getRecentlyAdded()
        _perks.value  = repo.getPerks()
    }
}
