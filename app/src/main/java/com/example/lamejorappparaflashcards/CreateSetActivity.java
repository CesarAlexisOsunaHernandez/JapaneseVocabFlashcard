package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void createFromCSV(View view){
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/*");

        // Optionally, specify a URI for the file that should appear in the
        // system file picker when it loads.

        startActivityForResult(intent, 5);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,
                                 Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        List<String> csv;
        Context context = this;
        SQLiteDatabase db;
        DatabaseHelper dbh = new DatabaseHelper(context);
        db = dbh.getReadableDatabase();

        if (requestCode == 5 && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                try {
                    csv = readTextFromUri(uri);
                } catch (IOException e) {
                    Toast toast = Toast.makeText(this,"Error al leer archivo", Toast.LENGTH_SHORT);
                    toast.show();
                    throw new RuntimeException(e);
                }
                for(int i = 0; i < csv.size(); i+=3){
                    if (i == 0){
                        db.execSQL("CREATE TABLE " + csv.get(i).replace(' ','$') + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
                    }else {
                        dbh.insertCard(db, csv.get(i-2), csv.get(i-1), csv.get(i), csv.get(0).replace(' ','$'));
                    }
                }
                Toast toast = Toast.makeText(this,"Set creado con exito", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private List<String> readTextFromUri(Uri uri) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> content = new ArrayList<>();
        try (InputStream inputStream =
                     getContentResolver().openInputStream(uri);
             BufferedReader reader = new BufferedReader(
                     new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");

                if(row.length > 1){
                    content.add(row[0]);
                    content.add(row[1]);
                    content.add(row[2]);
                }else{
                    content.add(row[0]);
                }

                stringBuilder.append(line);
            }
        }
        return content;
    }

}