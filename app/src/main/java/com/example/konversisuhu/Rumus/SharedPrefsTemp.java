package com.example.konversisuhu.Rumus;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPrefsTemp {
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;

    public static void setTemperature1 (Context context, String temperature, int index) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("temp_symbol_1", temperature);
        editor.putInt("temp_index_1", index);
        editor.apply();
    }

    public static void setTemperature2 (Context context, String temperature, int index) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
        editor.putString("temp_symbol_2", temperature);
        editor.putInt("temp_index_2", index);
        editor.apply();
    }

    //    get temperature symbol (1) (C, R, F, K)
    public static String getTempSymbol1 (Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString("temp_symbol_1", "");
    }

    //    get temperature symbol (2) (C, R, F, K)
    public static String getTempSymbol2 (Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getString("temp_symbol_2", "");
    }

    //    get temperatures (1) index
    public static int getTempIndex1 (Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt("temp_index_1", 0);
    }
    //    get temperatures (2) index
    public static int getTempIndex2 (Context context) {
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        return pref.getInt("temp_index_2", 0);
    }
}
