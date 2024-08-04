package com.example.banquemisr.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class FavoriteViewModel : ViewModel() {
    var favoriteList by mutableStateOf<List<Favorite>>(emptyList())
        private set

    fun getFavorites(token: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getFavorites(token).execute()
            if (response.isSuccessful) {
                favoriteList = response.body() ?: emptyList()
            }
        }
    }

    fun addFavorite(token: String, fullName: String, accountNumber: String) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.addFavorite(token, AddFavoriteRequest(fullName, accountNumber)).execute()
            if (response.isSuccessful) {
                getFavorites(token)
            }
        }
    }

    fun deleteFavorite(token: String, favouriteId: Int) {
        viewModelScope.launch {
            val response = RetrofitInstance.api.deleteFavorite(token, favouriteId).execute()
            if (response.isSuccessful) {
                getFavorites(token)
            }
        }
    }
}
