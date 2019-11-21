package br.edu.ifrs.ajudaqui.naoutilizando;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.repository.SolidarioRepository;

public class CadSolidarioActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_solidario);
        Button botao = findViewById(R.id.btnCadSol);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SolidarioRepository solidarioRepository = new SolidarioRepository(getBaseContext());


                EditText nome = findViewById(R.id.nomeSol);
                EditText email =  findViewById((R.id.emailSol));
                EditText dataNasc =  findViewById((R.id.dataNasc));
                EditText cpf =  findViewById((R.id.cpf));
                EditText senha =  findViewById((R.id.senhaSol));
                EditText identi = findViewById(R.id.identSol);

                String resultado = solidarioRepository.insert(nome.getText().toString(), identi.getText().toString(), senha.getText().toString(), email.getText().toString(), cpf.getText().toString(), dataNasc.getText().toString());
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                limparCampos();
                Intent intencao = new Intent(CadSolidarioActivity.this, LogSolidarioActivity.class);
                startActivity(intencao);
            }
        });
    }
    private void limparCampos(){
        EditText nome = findViewById(R.id.nomeSol);
        EditText email =  findViewById((R.id.emailSol));
        EditText dataNasc =  findViewById((R.id.dataNasc));
        EditText cpf =  findViewById((R.id.cpf));
        EditText senha =  findViewById((R.id.senhaSol));
        EditText identi = findViewById(R.id.identSol);
        nome.setText("");
        email.setText("");
        identi.setText("");
        cpf.setText("");
        dataNasc.setText("");
        senha.setText("");
    }*/
}
