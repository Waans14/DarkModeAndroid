package com.millenialzdev.mydarkmode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {

    private SwitchMaterial switch_tema;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switch_tema = findViewById(R.id.switch_tema);

        int saveMode = SaveTema.getSaveThema(this);
        AppCompatDelegate.setDefaultNightMode(saveMode);

        switch_tema.setChecked(saveMode == AppCompatDelegate.MODE_NIGHT_YES);

        switch_tema.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                SaveTema.saveThema(this, AppCompatDelegate.MODE_NIGHT_YES);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                switch_tema.setChecked(true);
            }else {
                SaveTema.saveThema(this, AppCompatDelegate.MODE_NIGHT_NO);
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                switch_tema.setChecked(false);
            }
        });
    }
}