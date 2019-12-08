package br.edu.ifrs.ajudaqui.view.ui.buscar;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.adapter.MyAcaoAdapter;
import br.edu.ifrs.ajudaqui.adapter.MyOngAdapter;
import br.edu.ifrs.ajudaqui.domain.Acao;
import br.edu.ifrs.ajudaqui.repository.ConfiguraFirebase;
import br.edu.ifrs.ajudaqui.view.Origem;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListAcaoFragment extends Fragment implements View.OnClickListener{
    RecyclerView recyclerView;
    private List<Acao> listaAcoes;
    MyAcaoAdapter myAcaoAdapter;
    Context context;

    public static ListAcaoFragment newInstance() {
        return new ListAcaoFragment();
    }

    public ListAcaoFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_list_acao, container, false);
        recyclerView = root.findViewById(R.id.recyclerAcaoView);
        //configurar o adapter - que formata que o layout de cada item do recycler
        context = root.getContext();
        carregaAcoes();


        //configurar o gerenciador de layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        GridLayoutManager layoutManager3 = new GridLayoutManager(getContext(), 2);
        StaggeredGridLayoutManager layoutManager2 =
                new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

        //adiciona um separador entre os elementos da lista
        //recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayout.VERTICAL));


        //definindo o layout do recycler
        recyclerView.setLayoutManager(layoutManager2);


        return root;
    }

    private void carregaAcoes() {
        final DatabaseReference reference = ConfiguraFirebase.getNoRaiz().child("acoes");
        listaAcoes = new ArrayList<>();
        //associar os eventos ao nó produtos para poder buscar os dados
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            //é chamado sempre que consegue recuperar algum dado
            //DataSnapshot é o retorno do Firebase => resultado da consulta
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //para buscar todos os nós filhos de produtos
                    Acao acao = ds.getValue(Acao.class);
                    System.out.println(acao.toString());
                    acao.setId(ds.getKey());
                    listaAcoes.add(acao);
                    Log.d("acao",acao.toString());
                }
                myAcaoAdapter = new MyAcaoAdapter(listaAcoes, context);
                recyclerView.setAdapter(myAcaoAdapter);
                recyclerView.setHasFixedSize(true);
                reference.removeEventListener(this);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick (View v){

    }

    @Override
    public void onAttach (Context context){
        super.onAttach(context);
        this.listener = (FragmentListener) context;
    }
    public static interface FragmentListener {
        void itemClicked(Origem origem, int posicao);
    }

    private FragmentListener listener;

}
