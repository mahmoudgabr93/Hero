package com.example.gabrm.retrofitjsonexample.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gabrm.retrofitjsonexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Hero> heroList;
    private Context context;

    public MyAdapter(List<Hero> heroList, Context context) {
        this.heroList = heroList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_list,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Hero hero=  heroList.get(i);
        viewHolder.textname.setText(hero.getName());
        viewHolder.textrealname.setText(hero.getBio());
        Picasso.get().load(hero.getImageurl()).into(viewHolder.imageView);

    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textname,textrealname;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textname = itemView.findViewById(R.id.nametext);
            textrealname = itemView.findViewById(R.id.realnametext);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
