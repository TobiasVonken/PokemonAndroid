package com.example.pokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
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

    private FragmentManager manager;

    public MainActivity() {
        this.manager = this.getSupportFragmentManager();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.Layout_Default) != null){

            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detailFragment))
                    .show(manager.findFragmentById(R.id.overviewFragment))
                    .commit();
        }
        if(findViewById(R.id.Layout_landscape) != null){
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.overviewFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(Pokemon pokemon) {
        if(findViewById(R.id.Layout_Default) != null){
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.overviewFragment))
                    .show(manager.findFragmentById(R.id.detailFragment))
                    .addToBackStack(null)
                    .commit();
        }
        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);

        detailFragment.setPokemon(pokemon);
    }



}