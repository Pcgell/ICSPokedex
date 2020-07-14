package hn.edu.ujcv.pokedex

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.INFO
import android.widget.LinearLayout
import com.android.volley.Request
import com.android.volley.VolleyError

import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import hn.edu.ujcv.pokedex.pokemon.PokemonAdapter
import hn.edu.ujcv.pokedex.pokemon.list.PokemonResponse
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Level
import java.util.logging.LogRecord
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
        fun getContext():Context{
            return context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContext(this);

        val url = "https://pokeapi.co/api/v2/pokemon?limit=35&offset=0"

        val vs = VolleySingleton(this)

        val request = StringRequest(Request.Method.GET,url,{
                response: String? ->

            val gson = Gson()

            var pokemonResponse = gson.fromJson(response,PokemonResponse::class.java)

            pokeRV.adapter = PokemonAdapter(pokemonResponse)
            pokeRV.layoutManager = LinearLayoutManager(this)


        },{error: VolleyError? ->
            Logger.getAnonymousLogger().log(LogRecord(Level.INFO,error.toString()))

            val gson = Gson()
            var pokemonResponse = gson.fromJson<PokemonResponse>(mockResponse,PokemonResponse::class.java)
            pokeRV.adapter = PokemonAdapter(pokemonResponse);
            pokeRV.layoutManager = LinearLayoutManager(this)

        })

        vs.addToRequestQueue(request)
    }


    val mockResponse = "{\"count\":964,\"next\":\"https://pokeapi.co/api/v2/pokemon?offset=35&limit=35\",\"previous\":null,\"results\":[{\"name\":\"bulbasaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/1/\"},{\"name\":\"ivysaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/2/\"},{\"name\":\"venusaur\",\"url\":\"https://pokeapi.co/api/v2/pokemon/3/\"},{\"name\":\"charmander\",\"url\":\"https://pokeapi.co/api/v2/pokemon/4/\"},{\"name\":\"charmeleon\",\"url\":\"https://pokeapi.co/api/v2/pokemon/5/\"},{\"name\":\"charizard\",\"url\":\"https://pokeapi.co/api/v2/pokemon/6/\"},{\"name\":\"squirtle\",\"url\":\"https://pokeapi.co/api/v2/pokemon/7/\"},{\"name\":\"wartortle\",\"url\":\"https://pokeapi.co/api/v2/pokemon/8/\"},{\"name\":\"blastoise\",\"url\":\"https://pokeapi.co/api/v2/pokemon/9/\"},{\"name\":\"caterpie\",\"url\":\"https://pokeapi.co/api/v2/pokemon/10/\"},{\"name\":\"metapod\",\"url\":\"https://pokeapi.co/api/v2/pokemon/11/\"},{\"name\":\"butterfree\",\"url\":\"https://pokeapi.co/api/v2/pokemon/12/\"},{\"name\":\"weedle\",\"url\":\"https://pokeapi.co/api/v2/pokemon/13/\"},{\"name\":\"kakuna\",\"url\":\"https://pokeapi.co/api/v2/pokemon/14/\"},{\"name\":\"beedrill\",\"url\":\"https://pokeapi.co/api/v2/pokemon/15/\"},{\"name\":\"pidgey\",\"url\":\"https://pokeapi.co/api/v2/pokemon/16/\"},{\"name\":\"pidgeotto\",\"url\":\"https://pokeapi.co/api/v2/pokemon/17/\"},{\"name\":\"pidgeot\",\"url\":\"https://pokeapi.co/api/v2/pokemon/18/\"},{\"name\":\"rattata\",\"url\":\"https://pokeapi.co/api/v2/pokemon/19/\"},{\"name\":\"raticate\",\"url\":\"https://pokeapi.co/api/v2/pokemon/20/\"},{\"name\":\"spearow\",\"url\":\"https://pokeapi.co/api/v2/pokemon/21/\"},{\"name\":\"fearow\",\"url\":\"https://pokeapi.co/api/v2/pokemon/22/\"},{\"name\":\"ekans\",\"url\":\"https://pokeapi.co/api/v2/pokemon/23/\"},{\"name\":\"arbok\",\"url\":\"https://pokeapi.co/api/v2/pokemon/24/\"},{\"name\":\"pikachu\",\"url\":\"https://pokeapi.co/api/v2/pokemon/25/\"},{\"name\":\"raichu\",\"url\":\"https://pokeapi.co/api/v2/pokemon/26/\"},{\"name\":\"sandshrew\",\"url\":\"https://pokeapi.co/api/v2/pokemon/27/\"},{\"name\":\"sandslash\",\"url\":\"https://pokeapi.co/api/v2/pokemon/28/\"},{\"name\":\"nidoran-f\",\"url\":\"https://pokeapi.co/api/v2/pokemon/29/\"},{\"name\":\"nidorina\",\"url\":\"https://pokeapi.co/api/v2/pokemon/30/\"},{\"name\":\"nidoqueen\",\"url\":\"https://pokeapi.co/api/v2/pokemon/31/\"},{\"name\":\"nidoran-m\",\"url\":\"https://pokeapi.co/api/v2/pokemon/32/\"},{\"name\":\"nidorino\",\"url\":\"https://pokeapi.co/api/v2/pokemon/33/\"},{\"name\":\"nidoking\",\"url\":\"https://pokeapi.co/api/v2/pokemon/34/\"},{\"name\":\"clefairy\",\"url\":\"https://pokeapi.co/api/v2/pokemon/35/\"}]}";
}
