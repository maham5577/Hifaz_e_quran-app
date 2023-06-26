package com.sem.hafiz_e_quranapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_5 extends AppCompatActivity
{

    private ListView listView;
    private EditText searchEditText;
    private ArrayAdapter<Student> arrayAdapter;
    Student student;
    private List<Student> studentList;
    private DbHelper dbHelper;

    //  private Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain_5);

        ListView listView = findViewById(R.id.list2);
        EditText searchEditText = findViewById(R.id.searchEditText);
        dbHelper = new DbHelper(this);
        studentList = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentList);
        listView.setAdapter(arrayAdapter);


        searchEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not needed for this implementation
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Perform the search whenever the text changes
                searchStudents(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                // Not needed for this implementation
            }
        });
    }

    private void searchStudents(String searchQuery) {
        studentList.clear();
        studentList.addAll(dbHelper.searchStudents(searchQuery));
        arrayAdapter.notifyDataSetChanged();
      /*button8=findViewById(R.id.addStudent);

        DbHelper db = DbHelper.getReadableDatabase(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
           db = new DbHelper(this);
        button8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_5.this, MainActivity_4.class);
                // intent.putExtra("db", (Serializable) db);
                startActivity(intent);
                 }
        });*/


    }
}