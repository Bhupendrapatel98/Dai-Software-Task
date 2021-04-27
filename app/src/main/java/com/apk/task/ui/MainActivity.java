package com.apk.task.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.apk.task.R;
import com.apk.task.adapter.ShowImageAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    CardView btn;
    RecyclerView recyclerView;
    ShowImageAdapter showImageAdapter;
    ArrayList<String> myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find id's
        btn = findViewById(R.id.btn);
        recyclerView = findViewById(R.id.recyclerView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImagesActivity.class));
            }
        });

        myList = (ArrayList<String>) getIntent().getSerializableExtra("imageList");

        if (myList != null) {
            setSelectedImageList();
        }
    }

    public void setSelectedImageList() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        showImageAdapter = new ShowImageAdapter(this, myList);
        recyclerView.setAdapter(showImageAdapter);
    }
}