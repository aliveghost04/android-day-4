package com.example.erick.remoteconnection;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Erick on 05/08/2017.
 */

public class FruitRecyclerViewAdapter extends RecyclerView.Adapter<FruitRecyclerViewAdapter.MyRecyclerItemViewHolder>{

    private List<Fruit> fruits;
    private Context context;

    public FruitRecyclerViewAdapter(Context context, List<Fruit> fruits) {
        this.context = context;
        this.fruits = fruits;
    }

    @Override
    public MyRecyclerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.card_view_layout, parent, false);
        return new FruitRecyclerViewAdapter.MyRecyclerItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerItemViewHolder holder, int position) {
        holder.tvId.setText(String.valueOf(fruits.get(position).getId()));
        Glide.with(context)
                .load(fruits.get(position).getImageUrl())
                .into(holder.ivImage);
        holder.tvDescription.setText(fruits.get(position).getDescription());
        holder.tvName.setText(fruits.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    public class MyRecyclerItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private TextView tvName;
        private ImageView ivImage;
        private TextView tvDescription;

        public MyRecyclerItemViewHolder(View itemView) {
            super(itemView);
            tvId = (TextView) itemView.findViewById(R.id.fruitId);
            tvName = (TextView) itemView.findViewById(R.id.fruitName);
            ivImage = (ImageView) itemView.findViewById(R.id.fruitImage);
            tvDescription = (TextView) itemView.findViewById(R.id.fruitDescription);
        }
    }
}
