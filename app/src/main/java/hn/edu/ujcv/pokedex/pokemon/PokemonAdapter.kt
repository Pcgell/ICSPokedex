package hn.edu.ujcv.pokedex.pokemon

import PokemonDetailsResponse
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import hn.edu.ujcv.pokedex.MainActivity
import hn.edu.ujcv.pokedex.R
import hn.edu.ujcv.pokedex.VolleySingleton
import hn.edu.ujcv.pokedex.pokemon.list.PokemonResponse
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger

class PokemonAdapter(private val pr: PokemonResponse) : Adapter<PokemonViewHolder>() {

    override fun getItemCount(): Int {
        return pr.results.count()
    }

    override fun onBindViewHolder(pvh: PokemonViewHolder, position: Int) {
        pvh.nombre.setText(pr.results[position].name)
        pvh.urlText.setText(pr.results[position].url)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PokemonViewHolder {
        val context = p0.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val pokemonView = inflater.inflate(R.layout.pokemon_layout, p0, false)
        // Return a new holder instance
        return PokemonViewHolder(pokemonView)
    }
}