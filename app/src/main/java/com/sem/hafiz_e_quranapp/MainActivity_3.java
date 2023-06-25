package com.sem.hafiz_e_quranapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_3 extends AppCompatActivity {

    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain_3);



        db = new DbHelper(this);

        List<Student> list = db.selectAllStudents();

        //ArrayAdapter<Student> arrayAdapter = new ArrayAdapter<Student>(this , android.R.layout.simple_list_item_1, list);
        //listView.setAdapter(arrayAdapter);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);




        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAdapter(list) ;
        recyclerView.setAdapter(adapter);



    }
}

