package com.example.PokeGOdex;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * base de datos hecha en java clase
 */
public class PokemonDB {
    private static ArrayList<Pokemon> listaPokemon = new ArrayList<>(Arrays.asList(
            new Pokemon(0, "bulbasaur", "s_bulbasaur", false)
            , new Pokemon(1, "ivysaur", "s_ivysaur", false)
            , new Pokemon(2, "venasaur", "s_venasaur", false)
            , new Pokemon(3, "charmander", "s_charmander", false)
            , new Pokemon(4, "charmeleon", "s_charmeleon", false)
            , new Pokemon(5, "charizard", "s_charizard", false)
            , new Pokemon(6, "squirtle", "s_squirtle", false)
            , new Pokemon(7, "wartortle", "s_wartortle", false)
            , new Pokemon(8, "blastoise", "s_blastoise", false)
            , new Pokemon(9, "caterpie", "s_caterpie", false)
            , new Pokemon(10, "metapod", "s_metapod", false)
            , new Pokemon(11, "butterfree", "s_butterfree", false)
            , new Pokemon(12, "weedle", "s_weedle", false)
            , new Pokemon(13, "kakuna", "s_kakuna", false)
            , new Pokemon(14, "beedrill", "s_beedrill", false)
            , new Pokemon(15, "pidgey", "s_pidgey", false)
            , new Pokemon(16, "pidgeotto", "s_pidgeotto", false)
            , new Pokemon(17, "pidgeot", "s_pidgeot", false)
            , new Pokemon(18, "rattata", "s_rattata", false)
            , new Pokemon(19, "raticate", "s_raticate", false)
            , new Pokemon(20, "spearow", "s_spearow", false)
            , new Pokemon(21, "fearow", "s_fearow", false)
            , new Pokemon(22, "ekans", "s_ekans", false)
            , new Pokemon(23, "arbok", "s_arbok", false)
            , new Pokemon(24, "pikachu", "s_pikachu", false)
            , new Pokemon(25, "raichu", "s_raichu", false)
            , new Pokemon(26, "sandshrew", "s_sandshrew", false)
            , new Pokemon(27, "sandslash", "s_sandslash", false)
            , new Pokemon(28, "nidoran", "s_nidoran", false)
            , new Pokemon(29, "nidorina", "s_nidorina", false)
            , new Pokemon(30, "nidoqueen", "s_nidoqueen", false)
            , new Pokemon(31, "cloyster", "s_cloyster", false)
            , new Pokemon(32, "gloom", "s_gloom", false)
            , new Pokemon(33, "krabby", "s_krabby", false)
            , new Pokemon(34, "magmar", "s_magmar", false)
            , new Pokemon(35, "marowak", "s_marowak", false)
            , new Pokemon(36, "snorlax", "s_snorlax", false)
            , new Pokemon(37, "starmie", "s_starmie", false)
            , new Pokemon(38, "vulpix", "s_vulpix", false)
    ));

    public static int ADIVINADOS = 0;

    public static int INTENTOS = 3;
    public static int NUMEROGENERADO = 0;
    private static boolean ACTIVATE_SOUND = true;

    public static String getNombre(int id) {
        return listaPokemon.get(id).getNombre().toLowerCase().replace(" ", "_");
    }

    public static String getSombra(int id) {
        return listaPokemon.get(id).getSombra().toLowerCase().replace(" ", "_");
    }

    public static Pokemon getPokemon(int id) {
        return listaPokemon.get(id);
    }

    public static int getTamaño() {
        return listaPokemon.size();
    }

    public static boolean isAdivinado(int id) {
        return listaPokemon.get(id).isAdivinado();
    }

    public static void setAdivinado(int id, boolean valor) {
        listaPokemon.get(id).setAdivinado(valor);
    }

    public static void cargarDatos(Context c) {
        SharedPreferences mispreferencias = c.getSharedPreferences("DatosJuego", Context.MODE_PRIVATE);
        INTENTOS = mispreferencias.getInt("INTENTOS", 3);
        ADIVINADOS = mispreferencias.getInt("ADIVINADOS", 0);
        ACTIVATE_SOUND = mispreferencias.getBoolean("SONIDO", true);
        for (Pokemon elemento : listaPokemon) {
            elemento.setAdivinado(mispreferencias.getBoolean(elemento.getNombre(), false));
        }
    }

    public static void guardarDatos(Context c) {
        SharedPreferences mispreferencias = c.getSharedPreferences("DatosJuego", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putInt("INTENTOS", INTENTOS);
        editor.putInt("ADIVINADOS", ADIVINADOS);
        editor.putBoolean("SONIDO", ACTIVATE_SOUND);
        for (Pokemon elemento : listaPokemon) {
            editor.putBoolean(elemento.getNombre(), elemento.isAdivinado());
        }
        editor.apply();
    }

    public static void cargarConfiguracion(Context c) {
        SharedPreferences mispreferencias = c.getSharedPreferences("DatosConfiguracion", Context.MODE_PRIVATE);
        ACTIVATE_SOUND = mispreferencias.getBoolean("SONIDO", true);
    }

    public static void guardarConfiguracion(Context c) {
        SharedPreferences mispreferencias = c.getSharedPreferences("DatosConfiguracion", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mispreferencias.edit();
        editor.putBoolean("SONIDO", ACTIVATE_SOUND);
        editor.apply();
    }

    public static void removerConfiguracion(Context c) {
        SharedPreferences settings = c.getSharedPreferences("DatosConfiguracion", Context.MODE_PRIVATE);
        settings.edit().clear().apply();
    }

    public static void removerDatos(Context c) {
        SharedPreferences settings = c.getSharedPreferences("DatosJuego", Context.MODE_PRIVATE);
        settings.edit().clear().apply();
    }

    public static boolean isPokemon(String x) {
        return listaPokemon.get(NUMEROGENERADO).getNombre().equalsIgnoreCase(x);
    }

    public static void DisminuirIntentos() {
        INTENTOS--;
    }

    public static boolean isGameOver() {
        return INTENTOS == 0;
    }

    public static boolean isWin() {
        return ADIVINADOS == getTamaño();
    }

    public static boolean isACTIVATE_SOUND() {
        return ACTIVATE_SOUND;
    }

    public static void setACTIVATE_SOUND(boolean ACTIVATE_SOUND) {
        PokemonDB.ACTIVATE_SOUND = ACTIVATE_SOUND;
    }
}
