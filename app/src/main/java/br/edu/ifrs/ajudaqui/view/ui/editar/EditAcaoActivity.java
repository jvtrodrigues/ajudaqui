package br.edu.ifrs.ajudaqui.view.ui.editar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.Acao;
import br.edu.ifrs.ajudaqui.domain.Status;
import br.edu.ifrs.ajudaqui.view.OngMainActivity;

public class EditAcaoActivity extends AppCompatActivity  implements Button.OnClickListener{
    Button button;
    String chave;
    TextInputEditText descricao;
    Spinner spnStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_acao);
        Intent intent = getIntent();
        descricao = findViewById(R.id.txtDesc);
        descricao.setText(intent.getStringExtra("descricao"));
        spnStatus = findViewById(R.id.spnStatusEdit);
        spnStatus.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Status.listDesc()));
        int pos = Integer.parseInt(intent.getStringExtra("status"));
        spnStatus.setSelection(pos);
        chave = intent.getStringExtra("chave");
        button = findViewById(R.id.btnEditAcao);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("acoes").child(chave);
        Acao a = new Acao(descricao.getText().toString(), Status.toEnum(spnStatus.getSelectedItem().toString()));
        reference.setValue(a);
        Intent intent = new Intent(this, OngMainActivity.class);
        startActivity(intent);
    }

}
