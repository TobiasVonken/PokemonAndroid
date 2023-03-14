package com.example.pokemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pokemon.Model.Pokemon;
import com.example.pokemon.R;


public class DetailFragment extends Fragment {

    public DetailFragment() {
        // Required empty public constructor
    }

    TextView textView;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        textView = view.findViewById(R.id.textView);
        imageView = view.findViewById(R.id.imageView);
        return view;

    }

    public void setPokemon(Pokemon pokemon) {
        textView.setText(pokemon.name);
        imageView.setImageResource(pokemon.picture);
    }
}