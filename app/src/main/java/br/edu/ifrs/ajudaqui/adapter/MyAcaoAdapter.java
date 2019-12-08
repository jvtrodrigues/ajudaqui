package br.edu.ifrs.ajudaqui.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.R;
import br.edu.ifrs.ajudaqui.domain.Acao;
import br.edu.ifrs.ajudaqui.repository.ConfiguraFirebase;
import br.edu.ifrs.ajudaqui.view.Origem;
import br.edu.ifrs.ajudaqui.view.ui.buscar.ListAcaoFragment;
import br.edu.ifrs.ajudaqui.view.ui.editar.EditAcaoActivity;

public class MyAcaoAdapter extends RecyclerView.Adapter<MyAcaoAdapter.MyViewHolder> {
    private Context context;
    List<Acao> listaAcoes = new ArrayList<>();
    ListAcaoFragment.FragmentListener listener;

    public MyAcaoAdapter(List<Acao> listaAcoes, Context context) {
        this.listaAcoes = listaAcoes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAcaoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //chamado para criar as visualizações - somente as primeiras que aparecem para o usuário
        //convertendo o XML em uma visualização
        //cria um objeto do tipo view
        View itemList = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.adapter_acao_card, viewGroup, false);
        //retorna o itemList que é passado para o construtor da MyViewHolder
        return new MyViewHolder(itemList);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyAcaoAdapter.MyViewHolder myViewHolder, final int i) {
        //exibe os itens no Recycler
        final Acao a = listaAcoes.get(i);
        myViewHolder.descricao.setText(a.getDescricao());
        myViewHolder.status.setText(a.getStatus().getDesc());

        myViewHolder.btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditAcaoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("chave", a.getId());
                intent.putExtra("descricao", a.getDescricao());
                intent.putExtra("status", Integer.toString(a.getStatus().ordinal()));
                Log.d("STATUS", "valor: " + a.getStatus().ordinal());
                context.getApplicationContext().startActivity(intent);
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
                .setTitle("Deletando Acao")
                .setMessage("Tem certeza que deseja deletar essa Acao?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final DatabaseReference reference = ConfiguraFirebase.getNo("acoes");
                        reference.child(listaAcoes.get(position).getId()).removeValue();
                        listaAcoes.remove(position);
                        notifyItemRemoved(position);

                    }
                }).setNegativeButton("Não", null).show();
    }

    @Override
    public int getItemCount() {
        //retorna a quantidade de itens que será exibida
        return listaAcoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //dados da pessoa que serão exibidos no recycler
        TextView descricao;
        TextView status;

        ImageButton btnEditar;
        ImageButton btnExcluir;
        Context context;

        public MyViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            //passa uma referência para os componentes que estão na interface
            descricao = itemView.findViewById(R.id.textViewDescricao);
            status = itemView.findViewById(R.id.textViewStatus);

            btnEditar = itemView.findViewById(R.id.btnEditarAct);
            btnExcluir = itemView.findViewById(R.id.btnExcluirAct);

        }
    }
}
