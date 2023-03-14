package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pokemon.Model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Pokemon> list = new ArrayList<>();
        list.add(new Pokemon(R.drawable.bulbasaur, "Bulbasaur"));
        list.add(new Pokemon(R.drawable.dragonite, "Dragonite"));
        list.add(new Pokemon(R.drawable.pikachu, "Pikachu"));

        recyclerView.setAdapter(new PokemonAdapter(list, new PokemonAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Pokemon pokemon) {
                showToast(pokemon.name);
            }
        }));


    }

    private void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}