package com.example.myproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myproject.pojo.AdabterMyCard;
import com.example.myproject.pojo.Card_Information;

import java.util.List;
import java.util.ArrayList;

public class MainActivityApp extends AppCompatActivity {
    List<Card_Information> obj_mycards_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Actionbar();
        LodingCardAdabteronRecycler();
        insetCourses();
    }

    public void Actionbar() {

        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.icon_navy);

    }

    public void LodingCardAdabteronRecycler() {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_card_view);
        AdabterMyCard adabterMyCard = new AdabterMyCard(obj_mycards_List, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adabterMyCard);
    }

    public void insetCourses() {
        obj_mycards_List.add(new Card_Information(
                R.drawable.c, "C++", "Master C++: From Basics to Advanced Programming."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.java, "Java", "Comprehensive Guide to Java Programming."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.paython,
                "Python",
                "Learn Python: Beginner to Advanced Level."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.kotlin,
                "Kotlin",
                "Kotlin for Android: Build Modern Apps."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.sql,
                "SQL",
                "SQL Essentials: Database Management and Queries."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.stuctuer,
                "Data Structures",
                "Learn Data Structures and System Design."
        ));
    }


}