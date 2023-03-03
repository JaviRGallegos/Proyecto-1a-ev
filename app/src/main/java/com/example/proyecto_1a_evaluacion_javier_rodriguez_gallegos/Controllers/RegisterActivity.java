package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Connections.DBConnection;
import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.R;

public class RegisterActivity extends AppCompatActivity {
    Button register = (Button) findViewById(R.id.buttonRegister);

    EditText txtName = (EditText) findViewById(R.id.txtPersonName);
    EditText txtPass = (EditText) findViewById(R.id.txtPassword);

    DBConnection myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        myDB = new DBConnection(this);
        myDB.getDBVersion();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(myDB.insert(txtName.getText().toString(), txtPass.getText().toString()) != -1){
                    Toast("Usuario creado correctamente");
                }else{
                    Toast("ERROR: creación fallida. Comprobar Logcar para más detalles del error.");
                }
            }
        });
    }

    public void Toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
