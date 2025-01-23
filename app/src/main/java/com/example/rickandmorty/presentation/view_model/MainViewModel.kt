package com.example.rickandmorty.presentation.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.data.dto.CharacterRequest
import com.example.rickandmorty.domain.interactor.CharacterInteractor
import com.example.rickandmorty.domain.models.Character
import kotlinx.coroutines.launch

class MainViewModel(
    private val characterInteractor: CharacterInteractor
) : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters

    fun loadCharacters() {
        viewModelScope.launch {
            try {
                Log.d("MainViewModel", "Starting to load characters")
                val characters = characterInteractor.getCharacters(CharacterRequest())
                Log.d("MainViewModel", "Loaded characters: ${characters.size}")
                _characters.value = characters
            } catch (e: Exception) {
                Log.e("MainViewModel", "Error loading characters", e)
                // Обработка ошибок
            }
        }
    }
}