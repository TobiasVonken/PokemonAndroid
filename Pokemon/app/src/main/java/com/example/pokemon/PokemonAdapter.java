package com.example.pokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.Model.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    private List<Pokemon> dataset;

    private ItemClickListener mItemListener;

    public PokemonAdapter(List<Pokemon> list, ItemClickListener itemClickListener) {
        this.mItemListener =itemClickListener;
        dataset=list;
    }

    @Override
    public PokemonViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position){
        holder.textView.setText(dataset.get(position).name);
        holder.imageView.setImageResource(dataset.get(position).picture);

        holder.itemView.setOnClickListener(view ->{
            mItemListener.onItemClick((dataset.get(position)));
        });
    }



    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public interface ItemClickListener{
        void onItemClick(Pokemon pokemon);
    }
}
