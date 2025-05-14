package com.example.myproject.pojo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myproject.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.ui.List_Lesson_Couers;

import java.util.ArrayList;
import java.util.List;

public class AdabterMyCard extends RecyclerView.Adapter<AdabterMyCard.myHolderView> {
    private List<Card_Information> obj_mycards = new ArrayList<>();
    private Context mycontext;
    int positionid;
    public AdabterMyCard(List<Card_Information> obj_mycards, Context mycontext) {
        this.obj_mycards = obj_mycards;
        this.mycontext = mycontext;

    }

    @NonNull
    @Override
    public myHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.style_card_view, parent, false);
        return new myHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolderView holder, int position) {
        Card_Information obj_card = obj_mycards.get(position);
      this.positionid = position;

        holder.image_cardView.setImageResource(obj_card.getImageCoures());
        holder.name_cardView.setText(obj_card.getNameCoures());
        holder.descripton_cardview.setText(obj_card.getDescriptionCoures());

    }
    @Override
    public int getItemCount() {
        return obj_mycards.size();
    }

    public class myHolderView extends RecyclerView.ViewHolder {
        ImageView image_cardView;
        TextView name_cardView;
        TextView descripton_cardview;
        public myHolderView(@NonNull View itemView) {
            super(itemView);
             image_cardView = itemView.findViewById(R.id.image_cardView);
             name_cardView = itemView.findViewById(R.id.name_cardView);
             descripton_cardview = itemView.findViewById(R.id.descripton_cardview);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mycontext, List_Lesson_Couers.class);
                intent.putExtra("pl", getAdapterPosition());
                intent.putExtra("positionid", getAdapterPosition());
                mycontext.startActivity(intent);
            });



        }


    }
}
