package com.mahasiswa.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import com.mahasiswa.R;
import com.mahasiswa.dao.MahasiswaDAO;
import com.mahasiswa.fragment.MahasiswaButterFragment;
import com.mahasiswa.model.Mahasiswa;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainButterActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{
    Fragment fragment = null;

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    protected DrawerLayout drawerLayout;

    @BindView(R.id.nav_view)
    protected NavigationView navigationView;

    MahasiswaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);

        ButterKnife.bind(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dao = new MahasiswaDAO(this);
        dao.getReadableDatabase();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_mahasiswa) {
            fragment = new MahasiswaButterFragment();
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.body_of_home, fragment).commit();
        }

        setTitle("Mahasiswa");

        return true;
    }
}
