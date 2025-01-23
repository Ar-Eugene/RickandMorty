package com.example.rickandmorty.presentation

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.rickandmorty.R
import com.example.rickandmorty.databinding.CharactersItemBinding
import com.example.rickandmorty.domain.models.Character
import com.example.rickandmorty.domain.models.enums.Status
import jp.wasabeef.glide.transformations.GrayscaleTransformation


class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharactersHolder>() {
    private var charactersList = ArrayList<Character>()

    fun setData(newList: ArrayList<Character>) {
        Log.d("CharacterAdapter", "Setting new data with size: ${newList.size}")
        charactersList.clear()
        charactersList.addAll(newList)
        notifyDataSetChanged()
    }

    inner class CharactersHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CharactersItemBinding.bind(item)

        fun bind(character: Character) = with(binding) {
            charactersName.text = character.name
            charactersGender.text = character.gender.toString().lowercase()
            charactersLocation.text = character.location.name
            charactersSpecies.text = character.species + ", "

            when (character.status) {
                Status.ALIVE -> {
                    charactersStatus.text = "ALIVE"
                    charactersStatus.setTextColor(Color.parseColor("#319F16"))
                    charactersStatus.setBackgroundResource(R.drawable.rouder_status_alive)
                    Glide.with(itemView.context)
                        .load(character.image)
                        .centerCrop()
                        .transform(RoundedCorners(100))
                        .into(charactersImage)
                }

                Status.DEAD -> {
                    charactersStatus.text = "DEAD"
                    charactersStatus.setTextColor(Color.parseColor("#E93800"))
                    charactersStatus.setBackgroundResource(R.drawable.rounder_status_dead)
                    Glide.with(itemView.context)
                        .load(character.image)
                        .centerCrop()
                        .placeholder(ColorDrawable(Color.parseColor("#0000001A")))
                        .transform(GrayscaleTransformation(), RoundedCorners(100))
                        .into(charactersImage)
                }

                Status.UNKNOWN -> {
                    charactersStatus.text = "UNKNOWN"
                    charactersStatus.setTextColor(Color.parseColor("#A0A0A0"))
                    charactersStatus.setBackgroundResource(R.drawable.rounder_status_unknown)
                    Glide.with(itemView.context)
                        .load(character.image)
                        .centerCrop()
                        .transform(RoundedCorners(100))
                        .into(charactersImage)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.characters_item, parent, false)
        return CharactersHolder(view)
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        Log.d("CharacterAdapter", "Binding view holder at position: $position")
        holder.bind(charactersList[position])
    }

    override fun getItemCount(): Int {
        Log.d("CharacterAdapter", "Current list size: ${charactersList.size}")
        return charactersList.size
    }
}