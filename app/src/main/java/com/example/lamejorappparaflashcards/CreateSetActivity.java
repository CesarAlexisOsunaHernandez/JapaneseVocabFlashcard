package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_set);
    }

    public void createSet(View view){
        Context context = this;
        SQLiteDatabase db;
        DatabaseHelper dbh = new DatabaseHelper(context);
        EditText editText = findViewById(R.id.table_name);

        String tableName = editText.getText().toString();
        tableName = tableName.replace(' ', '$');
        System.out.println(tableName);

        if(!tableName.equals("")){
            db = dbh.getReadableDatabase();
            db.execSQL("CREATE TABLE " + tableName + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}