package com.example.lamejorappparaflashcards;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

    public void createManual(View view) {
        EditText editText = findViewById(R.id.table_name);
        Button addSetBtn = findViewById(R.id.add_set);
        Button manuallyBtn = findViewById(R.id.manually);
        Button CSVBtn = findViewById(R.id.csv);

        editText.setVisibility(View.VISIBLE);
        addSetBtn.setVisibility(View.VISIBLE);
        manuallyBtn.setVisibility(View.GONE);
        CSVBtn.setVisibility(View.GONE);
    }

    public void createFromCSV(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(Intent.createChooser(intent, "Select a file"), 100);
        }catch (Exception e){
            System.out.println("Error");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable @org.jetbrains.annotations.Nullable Intent data) {

        System.out.println("1");
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("2");
        TextView text = findViewById(R.id.file_name);
        text.setVisibility(View.VISIBLE);
        System.out.println("3");
        if (requestCode == 100 && resultCode == RESULT_OK && data != null){
            System.out.println("4");
            Uri uri = data.getData();
            //assert uri != null;
            String path = uri.getPath();
            //assert path != null;
            String pathTrue = path.substring(path.indexOf(':') + 1);
            System.out.println(path);
            System.out.println(pathTrue);
            File file = new File(path);

//            System.out.println("2");
//            byte buffer[] = new byte[2];
//            try {
//                file.read(buffer,0,1);
//            } catch (IOException e) {
//                System.out.println("Oops2");
//            }
//            System.out.println(buffer);
            //text.setText(file.toString());

//            try {
//
//            } catch (FileNotFoundException e) {
//                throw new RuntimeException(e);
//            }

            text.setText("Path: " + path + "\n\n" + "File name: " + file.canRead() );
        }
    }
}