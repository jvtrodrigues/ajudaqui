package br.edu.ifrs.ajudaqui.view.ui.criar.acao;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.Acao;
import br.edu.ifrs.ajudaqui.domain.Status;
import br.edu.ifrs.ajudaqui.repository.ConfiguraFirebase;
import br.edu.ifrs.ajudaqui.view.OngMainActivity;
import br.edu.ifrs.ajudaqui.view.Origem;
import br.edu.ifrs.ajudaqui.view.ui.buscar.ListOngFragment;

public class CriarAcaoFragment extends Fragment {

    Button button;
    TextInputEditText descricao;
    Spinner spnStatus;

    View root;

    public CriarAcaoFragment() {
        // Required empty public constructor
    }



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_criar_acao, container, false);
        button = root.findViewById(R.id.btnCadAcao);
        spnStatus = root.findViewById(R.id.spnStatus);
        // Bind Spinner to states enum
        spnStatus.setAdapter(new ArrayAdapter<String>(root.getContext(), android.R.layout.simple_list_item_1, Status.listDesc()));
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                descricao = root.findViewById(R.id.txtDescricao);
                Acao acao = new Acao(descricao.getText().toString(), Status.toEnum(spnStatus.getSelectedItem().toString()));
                cadastrar(acao);
                listener.itemClicked(Origem.LIST_ACT, -1);
            }
        });
        return root;
    }


    private void cadastrar(Acao acao) {
        DatabaseReference reference = ConfiguraFirebase.getNoRaiz();
        DatabaseReference acoes = reference.child("acoes");
        //gera um identificador único para cada produto
        //salva o produto na base de dados
        acoes.push().setValue(acao).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("cad", "deu certo");
                Toast.makeText(getContext(), "Sucesso ao cadastrar acao!", Toast.LENGTH_SHORT).show();
                limparCampos();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("cad", "deu errado");
                        Toast.makeText(getContext(), "Erro ao cadastrar acao!", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    private void limparCampos(){
        ((TextInputEditText)root.findViewById(R.id.txtDescricao)).setText("");
        ((Spinner) root.findViewById(R.id.spnStatus)).setSelection(0);
    }

    @Override
    public void onAttach (Context context){
        super.onAttach(context);
        this.listener = (CriarAcaoFragment.FragmentListener) context;
    }
    public static interface FragmentListener {
        void itemClicked(Origem origem, int posicao);
    }

    private CriarAcaoFragment.FragmentListener listener;

}
