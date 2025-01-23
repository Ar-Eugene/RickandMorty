package com.example.rickandmorty.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.databinding.ActivityMainBinding
import com.example.rickandmorty.presentation.CharacterAdapter
import com.example.rickandmorty.presentation.view_model.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val adapter = CharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeViewModel()
        viewModel.loadCharacters()

    }

    private fun setupRecyclerView() {
        binding.itemRickAndMortyRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
            Log.d("MainActivity", "RecyclerView setup completed")
        }
    }

    private fun observeViewModel() {
        viewModel.characters.observe(this) { characters ->
            Log.d("MainActivity", "Received characters: ${characters.size}")
            adapter.setData(ArrayList(characters))
        }
    }
}

