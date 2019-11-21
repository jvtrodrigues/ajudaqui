package br.edu.ifrs.ajudaqui.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.domain.Acao;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.domain.Status;
import br.edu.ifrs.ajudaqui.util.BDUtil;

public class AcaoRepository {
   /* private BDUtil bdUtil;
    private OngRepository ongRepo;

    public AcaoRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert(String descricao, Status status, Ong ong){
        ContentValues valores = new ContentValues();
        valores.put("DESCRICAO", descricao);
        valores.put("STATUS", status.getDesc());
        valores.put("ID_ONG", ongRepo.findId(ong));
        long resultado = bdUtil.getConexao().insert("ACAO", null, valores);
        if (resultado ==-1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }
    public Integer delete(int codigo){
        Integer linhasAfetadas = bdUtil.getConexao().delete("ACAO","_ID = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Acao> getAll(){
        List<Acao> acaos = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, COMETARIO, STATUS, ID_ONG ");
        stringBuilderQuery.append("FROM  ACAO ");
        stringBuilderQuery.append("ORDER BY DESCRICAO");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Acao acao = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo acao
            acao =  new Acao();
            //adiciona os dados no objeto
            acao.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            acao.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
            acao.setStatus(Status.toEnum(cursor.getString(cursor.getColumnIndex("STATUS"))));
            //adiciona o objeto na lista
            acaos.add(acao);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return acaos;
    }
    public Acao getAcao(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM ACAO WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Acao t = new Acao();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setDescricao(cursor.getString(cursor.getColumnIndex("DESCRICAO")));
        t.setStatus(Status.toEnum(cursor.getString(cursor.getColumnIndex("STATUS"))));
        bdUtil.close();
        return t;
    }

    public int update(Acao acao){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("DESCRICAO",       acao.getDescricao());
        contentValues.put("STATUS",   acao.getStatus().getDesc());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("ACAO", contentValues, "_id = ?", new String[]{Integer.toString(acao.get_id())});
        bdUtil.close();
        return retorno;
    }*/
}
