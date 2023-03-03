package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Connections.DBConnection;
import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtUser = (EditText) findViewById(R.id.editTextTextPersonName);
    EditText txtPassword = (EditText) findViewById(R.id.editTextTextPassword);
    Button btnRegister = (Button) findViewById(R.id.registerbtn);
    Button btnLogin = (Button) findViewById(R.id.loginbutton);

    DBConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegister = new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(intentRegister);
            }
        });

    }

    private void login() {
        String user = txtUser.getText().toString();
        String password = txtPassword.getText().toString();
        // TODO: función para login
        conn = new DBConnection(this);
        ArrayList<String[]> users = new ArrayList<>();
        users = conn.getAllUsers();
        for (String[] userRow : users){
            if(userRow[0] == user && userRow[1] == password){
                Intent intentHome = new Intent(MainActivity.this, HomeActivity.class);
                MainActivity.this.startActivity(intentHome);
            }
            else{
                Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        }

    }


}