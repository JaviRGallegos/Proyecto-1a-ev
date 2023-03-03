package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Connections;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class RAWGConnect extends AsyncTask {
    private final String URL = "https://api.rawg.io/api/games";

    private final String KEY = "4d3c28d950164156b5c0a0c53af3ec0f";

    public JSONObject getRequest(){
        JSONObject result = null;
        HttpURLConnection conn;

        try{
            URL url = new URL(URL + "?key=" + KEY);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");

            if(conn.getResponseCode() == conn.HTTP_OK){
                result = new JSONObject((Map) conn.getInputStream());
            }


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }

    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled(Object o) {
        super.onCancelled(o);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
