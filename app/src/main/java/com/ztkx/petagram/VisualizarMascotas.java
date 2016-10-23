package com.ztkx.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ztkx.petagram.adaptador.MascotaAdaptador;
import com.ztkx.petagram.adaptador.PageAdapter;
import com.ztkx.petagram.fragments.MascotasFragment;
import com.ztkx.petagram.fragments.PerfilMascotaFragment;
import com.ztkx.petagram.pojo.Mascota;

import java.util.ArrayList;

public class VisualizarMascotas extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_mascotas);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.visualizarMascotas);

        tabLayout   = (TabLayout) findViewById(R.id.tabLayout);
        viewPager   = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mFavs:
                Intent goToFavs = new Intent(this,MascotasFavoritas.class);
                startActivity(goToFavs);
                return true;
            case R.id.mContacto:
                Intent goToContacto = new Intent(this,Contacto.class);
                startActivity(goToContacto);
                return true;

            case R.id.mAcerca:
                Intent goToAcerca = new Intent(this,AcercaDe.class);
                startActivity(goToAcerca);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotaFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.doghouse48);
        tabLayout.getTabAt(1).setIcon(R.drawable.gallery48);

    }


}
