package br.edu.ifrs.ajudaqui.view.ui.login;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.view.OngMainActivity;
import br.edu.ifrs.ajudaqui.view.ui.criar.conta.CriarContaActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout layoutEmail;
    private TextInputEditText txtEmail;
    private TextInputLayout layoutSenha;
    private TextInputEditText txtSenha;
    private Button btnLogar;
    private Button btnNaoTenhoConta;
    private FirebaseAuth mAuth;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        view = findViewById(android.R.id.content);
        layoutEmail = findViewById(R.id.layoutEmail);
        txtEmail = findViewById(R.id.txtEmail);
        layoutSenha = findViewById(R.id.layoutSenha);
        txtSenha = findViewById(R.id.txtSenha);
        btnLogar = findViewById(R.id.btnLogar);
        btnNaoTenhoConta = findViewById(R.id.btnNaoTenhoConta);
        btnLogar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(usuarioLogado()) openMainWindow();
                else{
                    if(validarCampos()) validateLogin();
                    else {
                        Snackbar snackbar = Snackbar.make(view, "Login incorreto", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            }
        });
        btnNaoTenhoConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CriarContaActivity.class);
                startActivity(intent);
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }
    private void openMainWindow() {
        Intent intent = new Intent(this, OngMainActivity.class);
        startActivity(intent);
        /*Snackbar snackbar = Snackbar.make(view, "Você está logado!", Snackbar.LENGTH_LONG);
        snackbar.show();*/
    }

    private Boolean usuarioLogado(){

        //Se o usuário já está logado não precisa fazer login novamente
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null) return false;
        return true;
    }

    private void validateLogin(){
        mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    openMainWindow();
                }
                else {
                    Snackbar snackbar = Snackbar.make(view, "Login incorreto, tente novamente!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }});
    }

    private boolean validarCampos(){
        if(txtEmail.getText().toString().isEmpty()){
            layoutEmail.setErrorEnabled(true);
            layoutEmail.setError("Informe o seu e-mail");
            return false;
        }else{
            layoutEmail.setErrorEnabled(false);
        }

        if(txtSenha.getText().toString().isEmpty()){
            layoutSenha.setErrorEnabled(true);
            layoutSenha.setError("Informe a sua senha");
            return false;
        }else{
            layoutSenha.setErrorEnabled(false);
        }
        return true;
    }

}
