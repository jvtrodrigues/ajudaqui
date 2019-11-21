package br.edu.ifrs.ajudaqui.naoutilizando;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.adapter.LinhaConsultaAdapterSolidario;
import br.edu.ifrs.ajudaqui.domain.Solidario;
import br.edu.ifrs.ajudaqui.repository.SolidarioRepository;

public class ListSolidarioActivity extends AppCompatActivity {
    private ListView listSoli;
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_solidario);
        listSoli = this.findViewById(R.id.listViewSolidarios);
        this.getAll();
    }
    protected  void getAll(){
        SolidarioRepository solidarioRepository = new SolidarioRepository(ListSolidarioActivity.this);
        List<Solidario> solidarios = solidarioRepository.getAll();
        listSoli.setAdapter(new LinhaConsultaAdapterSolidario(ListSolidarioActivity.this, solidarios));

    }*/
}
