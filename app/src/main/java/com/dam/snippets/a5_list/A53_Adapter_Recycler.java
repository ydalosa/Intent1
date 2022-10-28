package com.dam.snippets.a5_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.snippets.R;

public class A53_Adapter_Recycler extends RecyclerView.Adapter<A53_Adapter_Recycler.ItemViewHolder> {

    private Context context;
    private String[] stagiaires, descs;
    private int[] avatars;

    public A53_Adapter_Recycler(Context context, String[] stagiaires, String[] descs, int[] avatars) {
        this.context = context;
        this.stagiaires = stagiaires;
        this.descs = descs;
        this.avatars = avatars;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_a53_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.ivImage.setImageResource(avatars[position]);
        holder.tvTitre.setText(stagiaires[position]);
        holder.tvDesc.setText(descs[position]);
    }

    @Override
    public int getItemCount() {
        return avatars.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivImage;
        private TextView tvTitre, tvDesc;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
           ivImage = itemView.findViewById(R.id.ivImage);
           tvTitre = itemView.findViewById(R.id.tvTitre);
           tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }
}
