package br.edu.ifrs.ajudaqui.view.ui.criar.conta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.AreaOng;
import br.edu.ifrs.ajudaqui.domain.Endereco;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.domain.Solidario;
import br.edu.ifrs.ajudaqui.repository.ConfiguraFirebase;
import br.edu.ifrs.ajudaqui.view.ui.login.LoginActivity;

public class CriarContaActivity extends AppCompatActivity {
    Button btnOng;
    Button btnSol;
    Button button;
    TextInputEditText nome;
    TextInputEditText identificador;
    TextInputEditText email;
    TextInputEditText senha;
    TextInputEditText enderecoWeb;
    TextInputEditText area;
    TextInputEditText rua;
    TextInputEditText numero;
    TextInputEditText cep;
    Spinner mSpinner;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setarTipo();
        mAuth = FirebaseAuth.getInstance();
    }

    public void setarTipo() {
        setContentView(R.layout.activity_criar_conta_pergunta_tipo);
        btnOng = findViewById(R.id.btn_opc_ong);
        btnOng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_cadastrar_ong);
                button = findViewById(R.id.btnCriarOng);
                mSpinner = findViewById(R.id.spnAreaOng);
                // Bind Spinner to states enum
                mSpinner.setAdapter(new ArrayAdapter<String>(CriarContaActivity.this, android.R.layout.simple_list_item_1, AreaOng.listDesc()));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nome = findViewById(R.id.txtNomeOng);
                        email = findViewById(R.id.txtEmailOng);
                        senha = findViewById(R.id.txtSenhaOng);
                        identificador = findViewById(R.id.txtIdentificadorOng);
                        enderecoWeb = findViewById(R.id.txtEndWebOng);
                        rua = findViewById(R.id.txtRuaOng);
                        cep = findViewById(R.id.txtCepOng);
                        numero = findViewById(R.id.txtNumeroOng);

                        //String nome, String identificador, String senha, String email, String enderecoWeb, String area, Endereco endereco
                        Ong ong = new Ong(nome.getText().toString(), identificador.getText().toString(), senha.getText().toString(), email.getText().toString(), enderecoWeb.getText().toString(), AreaOng.toEnum(mSpinner.getSelectedItem().toString()), Integer.parseInt(cep.getText().toString()), rua.getText().toString(), Integer.parseInt(numero.getText().toString()));
                        cadastrar(ong);
                    }
                });
            }
        });
        btnSol = findViewById(R.id.btn_opc_solidario);
        btnSol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_cadastrar_solidario);
            }
        });
    }

    private void cadastrar(final Ong ong) {
        DatabaseReference reference = ConfiguraFirebase.getNoRaiz();
        DatabaseReference ongs = reference.child("ongs");
        ongs.push().setValue(ong).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("cad", "deu certo");
                permitirNovoUsuario(ong.getEmail(), ong.getSenha());
                Toast.makeText(CriarContaActivity.this, "Sucesso ao cadastrar ong!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("cad", "deu errado");
                        Toast.makeText(CriarContaActivity.this, "Erro ao cadastrar ong!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void cadastrar(Solidario solidario) {

    }

    public void permitirNovoUsuario(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).
                addOnCompleteListener(CriarContaActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(CriarContaActivity.this, LoginActivity.class);
                            startActivity(intent);
                            Toast.makeText(CriarContaActivity.this, "sucesso!", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(CriarContaActivity.this, "Erro ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void limparCampos() {
        ((TextInputEditText) findViewById(R.id.txtNomeOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtIdentificadorOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtSenhaOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtEmailOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtEndWebOng)).setText("");
        ((Spinner) findViewById(R.id.spnAreaOng)).setSelection(0);
        ((TextInputEditText) findViewById(R.id.txtCepOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtRuaOng)).setText("");
        ((TextInputEditText) findViewById(R.id.txtNumeroOng)).setText("");
    }
}
