package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateCardActivity extends AppCompatActivity {
    private String table;
    private boolean espaToJapa;
    private boolean kanjiKana;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_card);
        table = (String) getIntent().getExtras().get("unit_table");
        table = table.replace(' ', '_');
        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");

        SQLiteOpenHelper databaseHelper = new DatabaseHelper(this);
        db = databaseHelper.getReadableDatabase();

        updateCounter(db);
    }

    public void addCard(View view){
        EditText f = findViewById(R.id.f_card);
        EditText k = findViewById(R.id.k_card);
        EditText e = findViewById(R.id.e_card);

        if (add()){
            f.setText("");
            k.setText("");
            e.setText("");
        }
    }

    public void addCardNExit(View view){
        if (add()){
            Intent intent = new Intent(this, SubMenuActivity.class);
            intent.putExtra("E2J", espaToJapa);
            intent.putExtra("KK", kanjiKana);
            intent.putExtra("unit_table", table);
            intent.putExtra("NF", true);
            startActivity(intent);
        }
    }

    private boolean add(){
        EditText f = findViewById(R.id.f_card);
        EditText k = findViewById(R.id.k_card);
        EditText e = findViewById(R.id.e_card);

        if(!f.getText().toString().equals("") && !k.getText().toString().equals("") && !e.getText().toString().equals("")){
            Context context = this;
            DatabaseHelper dbh = new DatabaseHelper(context);
            dbh.insertCard(db, f.getText().toString(), k.getText().toString(), e.getText().toString(), table);
            updateCounter(db);
            return true;
        }else{
            Toast toast = Toast.makeText(this, "Llena todos campos", Toast.LENGTH_SHORT);
            toast.show();
        }
        return false;
    }

    private void updateCounter(SQLiteDatabase db){
        String text = "Carta no. " + (int) (DatabaseUtils.queryNumEntries(db, table) + 1);
        TextView counter = findViewById(R.id.create_card_counter);
        counter.setText(text);
    }
}