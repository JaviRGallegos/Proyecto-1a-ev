package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Controllers;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.R;



import io.easyprefs.Prefs;
// Usamos la librería EasyPrefs para facilitar el manejo de los ajustes
public class SettingActivity extends AppCompatActivity{

    private Switch darkTheme;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_layout);

        darkTheme = findViewById(R.id.switchDarkTheme);

        darkTheme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Prefs.write().content("dark_theme", b).commit();
                Functions.applyTheme();
            }
        });
    }
}
