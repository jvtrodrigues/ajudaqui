package br.edu.ifrs.ajudaqui.naoutilizando;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifrs.ajudaqui.R;

public class MainLogActivity  {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);
        ListView listaOpcoes = this.findViewById(R.id.listaOpc);
        listaOpcoes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(position ==0) {//cadastrar
            Intent intencao = new Intent(MainLogActivity.this, LogOngActivity.class);
            startActivity(intencao);
        }
        else {
            Intent intencao = new Intent(MainLogActivity.this, LogSolidarioActivity.class);
            startActivity(intencao);
        }
    }*/
}
