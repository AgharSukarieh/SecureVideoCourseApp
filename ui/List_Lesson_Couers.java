package com.example.myproject.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.R;
import com.example.myproject.pojo.AdabterMyCardVideo;
import com.example.myproject.pojo.video_card_information;

import java.util.List;
import java.util.ArrayList;

public class List_Lesson_Couers extends AppCompatActivity {
    List<video_card_information> obj_mycards_List = new ArrayList<>();
    TextView like_count, dislike_count;
    int like;
    int dislike;
    int positionlist;

    public int getPositionlist() {
        return positionlist;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_lesson_couers);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_recycler_card_view), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent intent = getIntent();
        like = intent.getIntExtra("like_count", 0);
        dislike = intent.getIntExtra("dislike_count", 0);

        savePreferences();
        loadPreferences();
        setAdabterMyCardVideo();
setLessons();

    }

    public void setAdabterMyCardVideo() {
        AdabterMyCardVideo adabterMyCardVideo = new AdabterMyCardVideo(obj_mycards_List, this);
        RecyclerView recyclerView = findViewById(R.id.my_recycler_card_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adabterMyCardVideo);
        Intent intent = getIntent();
        positionlist = intent.getIntExtra("pl", 0);

    }

public void setLessons() {
if (positionlist == 0) {
        setCPlusPlusLessons();
    } else if (positionlist == 1) {
        setJavaLessons();
    } else if (positionlist == 2) {
        setPythonLessons();
    } else if (positionlist == 3) {
        setKotlinLessons();
    } else if (positionlist == 4) {
        setSQLLessons();
    } else if (positionlist == 5) {
        setDataStructuresLessons();
    }

}

public void setKotlinLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.kotlinn, "Kotlin", "Kotlin for beginners to advanced level"));
    obj_mycards_List.add(new video_card_information(R.drawable.kotlinn, "Kotlin", "Learn Kotlin for Android development"));
    obj_mycards_List.add(new video_card_information(R.drawable.kotlinn, "Kotlin", "Master Kotlin with practical examples"));
}

public void setPythonLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.pythonn, "Python", "Python for beginners to advanced level"));
    obj_mycards_List.add(new video_card_information(R.drawable.pythonn, "Python", "Learn Python for Data Science"));
    obj_mycards_List.add(new video_card_information(R.drawable.pythonn, "Python", "Master Python programming with examples"));
}

public void setSQLLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.sqll, "SQL Database", "SQL Basics and Advanced Queries"));
    obj_mycards_List.add(new video_card_information(R.drawable.sqll, "SQL Database", "Learn SQL from zero to hero"));
    obj_mycards_List.add(new video_card_information(R.drawable.sqll, "SQL Database", "Advanced SQL concepts and optimization"));
}

public void setJavaLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.javaa, "Java", "Learn Java for beginners"));
    obj_mycards_List.add(new video_card_information(R.drawable.javaa, "Java", "Comprehensive Java programming course"));
    obj_mycards_List.add(new video_card_information(R.drawable.javaa, "Java", "Java for Android Development"));
}

public void setCPlusPlusLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.cplus, "C++", "Learn C++ programming from scratch"));
    obj_mycards_List.add(new video_card_information(R.drawable.cplus, "C++", "C++ for beginners to advanced"));
    obj_mycards_List.add(new video_card_information(R.drawable.cplus, "C++", "C++ programming for software development"));
}

public void setDataStructuresLessons() {
    obj_mycards_List.add(new video_card_information(R.drawable.stru, "Data Structures", "Data Structures for beginners"));
    obj_mycards_List.add(new video_card_information(R.drawable.stru, "Data Structures", "Advanced Data Structures and Algorithms"));
    obj_mycards_List.add(new video_card_information(R.drawable.stru, "Data Structures", "Master Data Structures in C++"));
}


public void savePreferences() {
    SharedPreferences sharedPreferences = getSharedPreferences("VideoPrefs", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("like", like);
    editor.putInt("dislike", dislike);
    editor.apply();
}

private void loadPreferences() {
    SharedPreferences sharedPreferences = getSharedPreferences("VideoPrefs", MODE_PRIVATE);
    like = sharedPreferences.getInt("like", 0);
    dislike = sharedPreferences.getInt("dislike", 0);
}

}