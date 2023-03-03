package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Adapter;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Models.VideoGame;
import com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    JSONArray listGames;

    public RecyclerAdapter(JSONArray listGames) {
        this.listGames = listGames;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_game_layout, parent, false);
        RecyclerHolder recyclerHolder = new RecyclerHolder(view);

        return recyclerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerHolder holder, int position) {
        try {
            Drawable background;

            VideoGame videoGame = null;
            JSONObject game;
            game = (JSONObject) listGames.get(position);
            videoGame.setTitle(game.getString("name"));
            videoGame.setRelease_date(game.getString("released"));
            // La respuesta de la api devuelve una URL, no la imagen como tal, por lo que  tenemos que crear un InputStream para coger la imagen
            InputStream getImage = (InputStream) new URL(game.getString("background_image")).getContent();
            background = Drawable.createFromStream(getImage, "src name");
            videoGame.setImage(background);


        } catch (JSONException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        return listGames.length();
    }

    public class RecyclerHolder extends RecyclerView.ViewHolder {
        ImageView imgVideoGame;
        TextView txtViewTitle;
        TextView txtViewGenre;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            imgVideoGame = itemView.findViewById(R.id.imgVideoGame);
            txtViewTitle = itemView.findViewById(R.id.txtViewTitle);
            txtViewGenre = itemView.findViewById(R.id.txtViewGenre);

        }
    }
}
