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
import com.example.pokemon.fragments.DetailFragment;
import com.example.pokemon.fragments.OverviewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OverviewFragment.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onItemSelected(Pokemon pokemon) {
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        detailFragment.setPokemon(pokemon);
    }



}