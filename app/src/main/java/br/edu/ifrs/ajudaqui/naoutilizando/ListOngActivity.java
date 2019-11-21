package br.edu.ifrs.ajudaqui.naoutilizando;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.adapter.LinhaConsultaAdapterOng;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.repository.OngRepository;

public class ListOngActivity extends AppCompatActivity {
    private ListView listOngs;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ong);
        listOngs = this.findViewById(R.id.listViewOngs);
        this.getAll();
    }
    protected  void getAll(){
        OngRepository ongRepository = new OngRepository(ListOngActivity.this);
        List<Ong> ongs = ongRepository.getAll();
        listOngs.setAdapter(new LinhaConsultaAdapterOng(ListOngActivity.this, ongs));

    }*/
}
