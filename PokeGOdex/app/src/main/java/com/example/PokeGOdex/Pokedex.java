package com.example.PokeGOdex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;


public class Pokedex extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_lista_pokemon);
        ListView lv = (ListView) findViewById(R.id.lvlista);
        ArrayList<Pokemon> itemsCompra = obtenerItems();
        PokemonAdapter adapter = new PokemonAdapter(this, itemsCompra);
        lv.setAdapter(adapter);
    }

    private ArrayList<Pokemon> obtenerItems() {
        ArrayList<Pokemon> items = new ArrayList<>();
        PokemonDB.cargarDatos(getApplicationContext());
        for (int i = 0; i < PokemonDB.getTamaño(); i++) {
            boolean bol = PokemonDB.isAdivinado(i);
            if (bol) {
                items.add(PokemonDB.getPokemon(i));
            } else {
                items.add(new Pokemon(i, "pokeball", null, false));
            }
        }
        return items;
    }
}
