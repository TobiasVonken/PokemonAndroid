package com.example.pokemon.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pokemon.MainActivity;
import com.example.pokemon.Model.Pokemon;
import com.example.pokemon.PokemonAdapter;
import com.example.pokemon.R;

import java.util.ArrayList;
import java.util.List;

public class OverviewFragment extends Fragment {

    public interface OnClickListener{
        void onItemSelected(Pokemon pokemon);
    }

    OnClickListener listener;

    public OverviewFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_overview, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        List<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(R.drawable.bulbasaur, "Bulbasaur"));
        list.add(new Pokemon(R.drawable.dragonite, "Dragonite"));
        list.add(new Pokemon(R.drawable.pikachu, "Pikachu"));

        recyclerView.setAdapter(new PokemonAdapter(list, new PokemonAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Pokemon pokemon) {
                showToast(pokemon.name);
                if(listener != null){
                    listener.onItemSelected((pokemon));
                }
            }
        }));

        return view;
    }

    private void showToast(String message){
        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listener = (MainActivity) getActivity();
    }
}