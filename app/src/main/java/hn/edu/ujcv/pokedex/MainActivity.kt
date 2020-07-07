package hn.edu.ujcv.pokedex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.VolleyError

import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import hn.edu.ujcv.pokedex.pokemon.list.PokemonResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url = "https://pokeapi.co/api/v2/pokemon?limit=5&offset=0"

        val vs = VolleySingleton(this)

        val request = StringRequest(Request.Method.GET,url,{
                response: String? ->
            //textView.text = response
            //var jsonObject= JSONObject(response)
            //var jsonArray = jsonObject.getJSONArray("results")
            //jsonObject = jsonArray.getJSONObject(4);
            //textView.text = jsonObject.getString("name")

            val gson = Gson()

            var pokemonResponse = gson.fromJson(response,PokemonResponse::class.java)

            textView.text =  pokemonResponse.results.get(1).name



        },{error: VolleyError? ->

        })

        vs.addToRequestQueue(request)
    }
}
