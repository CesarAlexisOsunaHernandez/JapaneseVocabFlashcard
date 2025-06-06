package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SubMenuActivity extends AppCompatActivity {
    private String Table;
    private boolean espaToJapa;
    private boolean kanjiKana;
    private boolean normalFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_menu);

        Table = (String) getIntent().getExtras().get("unit_table");
        Table = Table.replace(' ', '_');
        espaToJapa = (boolean) getIntent().getExtras().get("E2J");
        kanjiKana = (boolean) getIntent().getExtras().get("KK");
        normalFont = (boolean) getIntent().getExtras().get("NF");

        if (Table.equals("HIRAGANA") || Table.equals("KATAKANA") || Table.equals("UNIT_ONE") || Table.equals("UNIT_TWO") || Table.equals("UNIT_THREE") || Table.equals("UNIT_FOUR") || Table.equals("UNIT_FIVE") || Table.equals("UNIT_SIX") || Table.equals("UNIT_SEVEN") || Table.equals("UNIT_EIGHT")){
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
        intent.putExtra("NF", normalFont);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    public void addCard(View view){
        Intent intent = new Intent(this, CreateCardActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        intent.putExtra("NF", normalFont);
        intent.putExtra("unit_table", Table);
        startActivity(intent);
    }

    public void delCard(View view){
        Intent intent = new Intent(this, DeleteCardActivity.class);
        intent.putExtra("E2J", espaToJapa);
        intent.putExtra("KK", kanjiKana);
        intent.putExtra("NF", normalFont);
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
        intent.putExtra("NF", normalFont);
        intent.putExtra("all", true);
        intent.putExtra("download", false);
        startActivity(intent);
    }
}