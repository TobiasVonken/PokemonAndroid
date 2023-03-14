package com.example.pokemon;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    TextView textView;

    public PokemonViewHolder(@NonNull View view) {
        super(view);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);

    }
}
