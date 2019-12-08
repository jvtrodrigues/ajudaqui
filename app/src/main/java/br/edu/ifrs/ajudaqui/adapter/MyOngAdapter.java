package br.edu.ifrs.ajudaqui.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.repository.ConfiguraFirebase;
import br.edu.ifrs.ajudaqui.view.Origem;
import br.edu.ifrs.ajudaqui.view.ui.buscar.ListOngFragment;



public class MyOngAdapter extends RecyclerView.Adapter<MyOngAdapter.MyViewHolder> {
    private Context context;
    List<Ong> listaOngs = new ArrayList<>();
    ListOngFragment.FragmentListener listener;

    public MyOngAdapter(List<Ong> listaOngs, Context context) {
        this.listaOngs = listaOngs;
        this.context = context;
    }

    @NonNull
    @Override
    public MyOngAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_ong_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyOngAdapter.MyViewHolder myViewHolder, final int i) {
        //exibe os itens no Recycler
        Ong o = listaOngs.get(i);
        myViewHolder.nome.setText(o.getNome());
        myViewHolder.email.setText(o.getEmail());
        myViewHolder.identificador.setText(o.getIdentificador());
        myViewHolder.endWeb.setText(o.getEnderecoWeb());
        /*myViewHolder.cep.setText(o.getCep());
        myViewHolder.rua.setText(o.getRua());
        myViewHolder.numero.setText(o.getNumero());*/

        myViewHolder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               listener.itemClicked(Origem.EDIT_ONG, i);
            }
        });
        myViewHolder.btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(i);
            }
        });
    }

    public void removerItem(final int position) {
        new AlertDialog.Builder(context)
                .setTitle("Deletando Ong")
                .setMessage("Tem certeza que deseja deletar essa Ong?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DatabaseReference reference = ConfiguraFirebase.getNo("ongs");
                        reference.child(listaOngs.get(position).getId()).removeValue();
                        listaOngs.remove(position);
                        notifyItemRemoved(position);

                    }}).setNegativeButton("Não", null).show();
    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaOngs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //dados da pessoa que serão exibidos no recycler
        TextView nome;
        TextView email;
        TextView identificador;
        TextView endWeb;
        TextView cep;
        TextView rua;
        TextView numero;

        ImageButton btnEditar;
        ImageButton btnExcluir;
        Context context;

        public MyViewHolder(View itemView){
            super(itemView);
            context = itemView.getContext();
            //passa uma referência para os componentes que estão na interface
            nome = itemView.findViewById(R.id.textViewNome);
            email = itemView.findViewById(R.id.textViewEmail);
            identificador = itemView.findViewById(R.id.textviewIdentificador);
            endWeb = itemView.findViewById(R.id.textViewEndWeb);
            /*cep = itemView.findViewById(R.id.textViewCep);
            rua = itemView.findViewById(R.id.textViewRua);
            numero = itemView.findViewById(R.id.textViewNumero);*/

            btnEditar = itemView.findViewById(R.id.btnEditar);
            btnExcluir = itemView.findViewById(R.id.btnExcluir);

        }
    }
}
