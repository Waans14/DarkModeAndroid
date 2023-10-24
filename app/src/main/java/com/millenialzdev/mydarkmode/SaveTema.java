package com.millenialzdev.mydarkmode;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;

public class SaveTema {

    private static final String SHARED_TEMA_NAME = "tema_shared";
    private static final String KEY_TEMA_MODE = "tema_mode";

    public static void saveThema(Context context, int temaMode){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_TEMA_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_TEMA_MODE, temaMode);
        editor.apply();
    }

    public static int getSaveThema(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_TEMA_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(KEY_TEMA_MODE, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }
}
