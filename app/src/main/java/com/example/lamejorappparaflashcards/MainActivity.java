package com.example.lamejorappparaflashcards;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fragment fragment = new MainMenuFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.commit();

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

        if (id == R.id.unit5){
            intent = new Intent(this, CardActivity.class);
            intent.putExtra("unit_table", "UNIT_FIVE");
            startActivity(intent);
        }

        if (id == R.id.unit7){
            intent = new Intent(this, CardActivity.class);
            intent.putExtra("unit_table", "UNIT_SEVEN");
            startActivity(intent);
        }
//        switch (id){
//            case R.id.monsters:
//                intent = new Intent(this, CardActivity.class);
//                intent.putExtra("position", 0);
//                startActivity(intent);
//                break;
//            case R.id.monsters:
//                //intent = new Intent(this, SubMenu.class);
//                intent.putExtra("position", 1);
//                startActivity(intent);
//                break;
//            case R.id.message_dev:
//                intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                String uri = "whatsapp://send?phone=526643637206&text=";
//                intent.setData(Uri.parse(uri));
//                startActivity(intent);
//                break;
//            case R.id.find_us:
//                Uri gmmIntentUri = Uri.parse("geo:0,0?q=Universidad Automona de Baja California FCQI");
//                intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
//                intent.setPackage("com.google.android.apps.maps");
//                startActivity(intent);
//                break;
//            default:
//                //fragment = new InboxFragment();
//        }

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