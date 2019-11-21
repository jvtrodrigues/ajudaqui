package br.edu.ifrs.ajudaqui.view.ui.criar.conta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.edu.ifrs.ajudaqui.R;

public class CriarContaActivity extends AppCompatActivity {
    Button btnOng;
    Button btnSol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setarTipo();
    }

    public void setarTipo(){
        setContentView(R.layout.activity_criar_conta_pergunta_tipo);
        btnOng = findViewById(R.id.btn_opc_ong);
        btnOng.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_cadastrar_ong);
            }
        });
        btnSol = findViewById(R.id.btn_opc_solidario);
        btnSol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_cadastrar_solidario);
            }
        });
    }
}
