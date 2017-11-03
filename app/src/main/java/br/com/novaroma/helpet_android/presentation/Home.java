package br.com.novaroma.helpet_android.presentation;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.novaroma.helpet_android.R;

public class Home extends Activity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView) findViewById(R.id.lv_home);
        list = new ArrayList();

        popularArray();
        setListView();
    }

    private void setListView() {
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list));
    }

    private void popularArray() {
        list.add("Teste 1");
        list.add("Teste 2");
        list.add("Teste 3");
        list.add("Teste 4");
        list.add("Teste 5");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_adopted) {
            // Handle the camera action
            Toast.makeText(this, "adotados", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_adoptin) {
            Toast.makeText(this, "adoçoes", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_complaint) {
            Toast.makeText(this, "denuncia", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_ransomed) {
            Toast.makeText(this, "resgatados", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            Toast.makeText(this, "configurações", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
