package com.example.myproject.pojo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.ui.List_Lesson_Couers;
import com.example.myproject.ui.Video_Activity;

import java.util.List;
import android.content.Intent;
import android.widget.Toast;

public class AdabterMyCardVideo extends RecyclerView.Adapter<AdabterMyCardVideo.myHolderView> {
    private List<video_card_information> obj_mycardsList;
    private Context mycontext;
    int position;
List_Lesson_Couers list_lesson_couers = new List_Lesson_Couers();
    public AdabterMyCardVideo(List<video_card_information> obj_mycards, Context mycontext) {
        this.obj_mycardsList = obj_mycards;
        this.mycontext = mycontext;
    }

    @NonNull
    @Override
    public myHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_video, parent, false);
        return new myHolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolderView holder, int position) {
        video_card_information obj_card = obj_mycardsList.get(position);
        holder.image_video.setImageResource(obj_card.getImage_video());
        holder.title_video.setText(obj_card.getTitle_video());
        holder.desc_video.setText(obj_card.getDesc_video());

        SharedPreferences sharedPreferences = mycontext.getSharedPreferences("Favorites", Context.MODE_PRIVATE);
        boolean isFavorite = sharedPreferences.getBoolean("video_" + position, false);
        if (isFavorite) {
            holder.favorty.setImageResource(R.drawable.favo);
        } else {
            holder.favorty.setImageResource(R.drawable.disfavo);
        }
    }

    @Override
    public int getItemCount() {
        return obj_mycardsList.size();
    }

    public class myHolderView extends RecyclerView.ViewHolder {
        ImageView image_video;
        TextView title_video;
        TextView desc_video;
        ImageView favorty;

        public myHolderView(@NonNull View itemView) {
            super(itemView);
            image_video = itemView.findViewById(R.id.image_video);
            title_video = itemView.findViewById(R.id.title_video);
            desc_video = itemView.findViewById(R.id.desc_video);
            favorty = itemView.findViewById(R.id.favorty);

            favorty.setOnClickListener(v -> {
                int position = getAdapterPosition();

                SharedPreferences sharedPreferences = mycontext.getSharedPreferences("Favorites", Context.MODE_PRIVATE);
                boolean isFavorite = sharedPreferences.getBoolean("video_" + position, false);

                isFavorite = !isFavorite;

                if (isFavorite) {
                    favorty.setImageResource(R.drawable.favo);
                } else {
                    favorty.setImageResource(R.drawable.disfavo);
                }

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("video_" + position, isFavorite);
                editor.apply();
            });

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(mycontext, Video_Activity.class);
                int positionInAdapter = getAdapterPosition();

                Intent parentIntent = ((Activity) mycontext).getIntent();
                int positionidFromMyCard = parentIntent.getIntExtra("positionid", -1);

                intent.putExtra("p", positionInAdapter);
                intent.putExtra("pl", positionidFromMyCard);
                mycontext.startActivity(intent);
            });
        }
    }
}
