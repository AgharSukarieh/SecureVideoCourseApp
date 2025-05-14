package com.example.myproject.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myproject.R;
import com.example.myproject.pojo.AdabterMyCard;
import com.example.myproject.pojo.Card_Information;

import java.util.List;
import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;

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
        style();
    }

    public void Actionbar() {
        Toolbar toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.menu5);

    }

    public void LodingCardAdabteronRecycler() {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_card_view);
        AdabterMyCard adabterMyCard = new AdabterMyCard(obj_mycards_List, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adabterMyCard);
    }
    public void style()
    {        ImageView logo = findViewById(R.id.logomain);
        Glide.with(this).load(R.drawable.logobar).into(logo);
        ImageView cnterimage = findViewById(R.id.imagecenter);
        Glide.with(this).load(R.drawable.cnterimage).into(cnterimage);
    }
    public void insetCourses() {
        obj_mycards_List.add(new Card_Information(
                R.drawable.cpp, "C++", "Master C++: From Basics to Advanced Programming."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.java, "Java", "Comprehensive Guide to Java Programming."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.python,
                "Python",
                "Learn Python: Beginner to Advanced Level."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.k,
                "Kotlin",
                "Kotlin for Android: Build Modern Apps."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.sqlll,
                "SQL",
                "SQL Essentials: Database Management and Queries."
        ));
        obj_mycards_List.add(new Card_Information(
                R.drawable.str,
                "Data Structures",
                "Learn Data Structures and System Design."
        ));
    }


}