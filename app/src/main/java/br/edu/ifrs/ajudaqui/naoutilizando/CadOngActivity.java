package br.edu.ifrs.ajudaqui.naoutilizando;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.Area;
import br.edu.ifrs.ajudaqui.repository.OngRepository;

public class CadOngActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_ong);
        Button botao = findViewById(R.id.btnCad);
        // Get the widget reference from XML layout
        Spinner mSpinner = findViewById(R.id.spinnerAreaOng);
        // Bind Spinner to states enum
        mSpinner.setAdapter(new ArrayAdapter<Area>(CadOngActivity.this, android.R.layout.simple_list_item_1, Area.values()));

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OngRepository ongRepository = new OngRepository(getBaseContext());


                EditText nome = findViewById(R.id.nomeOng);
                EditText email =  findViewById((R.id.emailOng));
                EditText numEnd =  findViewById((R.id.numEndOng));
                EditText ruaEnd =  findViewById((R.id.ruaEndOng));
                EditText endWebOng =  findViewById((R.id.ruaEndOng));
                EditText cepEndOng =  findViewById((R.id.cepEndOng));
                EditText senhaOng =  findViewById((R.id.senhaOng));
                EditText identiOng = findViewById(R.id.identiOng);

                Spinner mSpinner = findViewById(R.id.spinnerAreaOng);

                String resultado = ongRepository.insert(nome.getText().toString(), identiOng.getText().toString(), senhaOng.getText().toString(), email.getText().toString(), endWebOng.getText().toString(), (Area)mSpinner.getSelectedItem(), cepEndOng.getText().toString(), ruaEnd.getText().toString(), numEnd.getText().toString());
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                limparCampos();
                Intent intencao = new Intent(CadOngActivity.this, LogOngActivity.class);
                startActivity(intencao);
            }
        });
    }
    private void limparCampos(){
        EditText nome = findViewById(R.id.nomeOng);
        EditText email =  findViewById((R.id.emailOng));
        EditText numEnd =  findViewById((R.id.numEndOng));
        EditText ruaEnd =  findViewById((R.id.ruaEndOng));
        EditText endWebOng =  findViewById((R.id.ruaEndOng));
        EditText cepEndOng =  findViewById((R.id.cepEndOng));
        EditText senhaOng =  findViewById((R.id.senhaOng));
        EditText identiOng = findViewById(R.id.identiOng);
        nome.setText("");
        email.setText("");
        numEnd.setText("");
        ruaEnd.setText("");
        endWebOng.setText("");
        cepEndOng.setText("");
        senhaOng.setText("");
        identiOng.setText("");
    }*/
}
