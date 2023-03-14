package com.example.toolmenubarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.toolbar_search).getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                setPokemon(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    void setPokemon(String pokemon){
        TextView textView = findViewById(R.id.textView);
        ImageView imageView = findViewById(R.id.imageView);

        switch (pokemon){
            case "Bulbasaur":
                textView.setText(pokemon);
                imageView.setImageResource(R.drawable.bulbasaur);
                break;
            case "Dragonite":
                textView.setText(pokemon);
                imageView.setImageResource(R.drawable.dragonite);
                break;
            case "Pikachu":
                textView.setText(pokemon);
                imageView.setImageResource(R.drawable.pikachu);
                break;
        }
    }
}