package br.edu.ifrs.ajudaqui.view;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.view.ui.buscar.BuscarOngFragment;
import br.edu.ifrs.ajudaqui.view.ui.buscar.ListAcaoFragment;
import br.edu.ifrs.ajudaqui.view.ui.buscar.ListOngFragment;
import br.edu.ifrs.ajudaqui.view.ui.criar.acao.CriarAcaoFragment;
import br.edu.ifrs.ajudaqui.view.ui.encontrar.EncontrarOngsFragment;
import br.edu.ifrs.ajudaqui.view.ui.home.HomeFragment;
import br.edu.ifrs.ajudaqui.view.ui.sobre.SobreFragment;

public class OngMainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, BuscarOngFragment.FragmentListener,
        ListOngFragment.FragmentListener, CriarAcaoFragment.FragmentListener, ListAcaoFragment.FragmentListener,
        SobreFragment.FragmentListener {

    public static String TIPO_DE_LOGIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ong_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
// menu should be considered as top level destinations.
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ong_main, menu);
        return true;
    }

    @Override
    public void itemClicked(Origem origem, int posicao) {
        if(origem==Origem.FIND_ACT){
            EncontrarOngsFragment fragment = new EncontrarOngsFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(origem==Origem.LIST_ONG) {
            ListOngFragment fragment = new ListOngFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(origem==Origem.CREATE_ACT) {
            CriarAcaoFragment fragment = new CriarAcaoFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(origem==Origem.LIST_ACT) {
            ListAcaoFragment fragment = new ListAcaoFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(origem==Origem.ABOUT) {
            SobreFragment fragment = new SobreFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else if(origem==Origem.SHARE) {
            String to = "ajudaqui@gmail.com";
            String subject = "Teste";
            String message = "Mensagem de contato";
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "E-mail"));
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.nav_encontrar){
            EncontrarOngsFragment fragment = new EncontrarOngsFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }  else if(id == R.id.nav_listar_ongs){
            ListOngFragment fragment = new ListOngFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        } else if(id == R.id.nav_criar_acao){
            CriarAcaoFragment fragment = new CriarAcaoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(id == R.id.nav_listar_acoes){
            ListAcaoFragment fragment = new ListAcaoFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(id == R.id.nav_sobre){
            SobreFragment fragment = new SobreFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }else if(id == R.id.nav_share){
            String to = "ajudaqui@gmail.com";
            String subject = "Teste";
            String message = "Mensagem de contato";
            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email, "E-mail"));
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
