package hn.edu.ujcv.pokedex.pokemon

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.android.volley.toolbox.NetworkImageView
import hn.edu.ujcv.pokedex.R

class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val urlText = itemView.findViewById<TextView>(R.id.pokeurl)
        val nombre = itemView.findViewById<TextView>(R.id.pokeText)
}