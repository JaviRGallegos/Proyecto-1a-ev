package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Controllers;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Adapter.RecyclerAdapter;
import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Connections.RAWGConnect;
import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    JSONObject dataPackage;
    JSONArray gameList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        // Creamos el recycler adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        try {
            recyclerAdapter = new RecyclerAdapter(getListGames());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        // Usamos un layout manager para disponer los elementos de la lista de videojuegos
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Añadimos los elementos de la lista de videojuegos a la vista padre con sus métodos
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu, menu);
        Button delete = (Button) menu.findItem(R.id.deleteBtn);
        return false;
    }

    // Control de la acción de pulsar el botón de atrás
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private JSONArray getListGames() throws JSONException {
        JSONObject result;
        JSONArray gameArray;
        RAWGConnect connect = new RAWGConnect();
        // Cogemos el resultado de la petición a la API
        result = connect.getRequest();
        gameArray = result.getJSONArray("results");

        return gameArray;
    }
}
