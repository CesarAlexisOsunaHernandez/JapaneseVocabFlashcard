package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class SubMenuActivity extends AppCompatActivity {
    private String Table;
    private boolean espaToJapa;
    private boolean kanjiKana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        Table = (String) getIntent().getExtras().get("unit_table");
        Table = Table.replace(' ', '_');
        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");

        if (Table.equals("KATAKANA") || Table.equals("UNIT_FIVE") || Table.equals("UNIT_SIX") || Table.equals("UNIT_SEVEN") || Table.equals("UNIT_EIGHT")){
            Button add = findViewById(R.id.add_card_sub);
            add.setVisibility(View.GONE);

            Button del = findViewById(R.id.del_card_sub);
            del.setVisibility(View.GONE);
        }
    }

    public void studyCards(View view){
        Intent intent = new Intent(this, CardActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    public void addCard(View view){
        Intent intent = new Intent(this, CreateCardActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    public void delCard(View view){
        Intent intent = new Intent(this, DeleteCardActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    public void showContent(View view){
        Intent intent = new Intent(this, SetContentActivity.class);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        //super.onBackPressed();
        Intent intent = new Intent(this, TablesListActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        startActivity(intent);
    }
}