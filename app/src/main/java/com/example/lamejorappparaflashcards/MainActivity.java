package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private boolean espaToJapa;
    private boolean kanjiKana;
    private SQLiteOpenHelper databaseHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = new MainMenuFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.commit();

        espaToJapa = false;
        kanjiKana  = true;

        databaseHelper = new DatabaseHelper(this);

        try {
            db = databaseHelper.getReadableDatabase();
        }catch (Exception e){
            System.out.println("Error en la base de datos");
        }

        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,  toolbar, R.string.test,R.string.test);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        Intent intent;

        if (id == R.id.cards){
            intent = new Intent(this, TablesListActivity.class);
            intent.putExtra("E2J", espaToJapa);
            intent.putExtra("KK", kanjiKana);
            startActivity(intent);
        }

        if (id == R.id.addset){
            intent = new Intent(this, CreateSetActivity.class);
            startActivity(intent);
        }

        if (id == R.id.delset){
            intent = new Intent(this, DeleteSetActivity.class);
            startActivity(intent);
        }

        if (id == R.id.card_mode){
            Toast toast;

            if (espaToJapa){
                toast = Toast.makeText(this, "J -> E", Toast.LENGTH_SHORT);
                item.setTitle("J->E");

            }else{
                toast = Toast.makeText(this, "E -> J", Toast.LENGTH_SHORT);
                item.setTitle("E->J");
            }
            toast.show();
            espaToJapa = !espaToJapa;
        }

        if (id == R.id.review_mode) {
            Toast toast;

            if (kanjiKana){
                toast = Toast.makeText(this, R.string.review_mode2, Toast.LENGTH_SHORT);
                item.setTitle(R.string.review_mode2);

            }else{
                toast = Toast.makeText(this, R.string.review_mode1, Toast.LENGTH_SHORT);
                item.setTitle(R.string.review_mode1);
            }
            toast.show();
            kanjiKana = !kanjiKana;
        }

        if (id == R.id.message_dev){
            intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            String uri = "whatsapp://send?phone=526643637206&text=";
            intent.setData(Uri.parse(uri));
            startActivity(intent);
        }

        if (id == R.id.credits){
            intent = new Intent(this, CreditsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}