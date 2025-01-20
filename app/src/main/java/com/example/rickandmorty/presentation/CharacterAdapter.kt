package com.example.rickandmorty.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.CharactersItemBinding
import com.example.rickandmorty.domain.models.Character

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.CharactersHolder>() {
    var charactersList = ArrayList<Character>()


    inner class CharactersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CharactersItemBinding.bind(item)

        fun bind(character: Character) = with(binding) {

//            Glide.with(itemView.context)
//                .load()
//                .placeholder()
//                .centerCrop()
//                .transform()
//                .into()

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.characters_item, parent, false)
        return CharactersHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        holder.bind(charactersList[position])

    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

}