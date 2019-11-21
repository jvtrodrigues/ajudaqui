package br.edu.ifrs.ajudaqui.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.domain.Avaliacao;
import br.edu.ifrs.ajudaqui.domain.Classificacao;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.util.BDUtil;

public class AvaliacaoRepository {
   /* private BDUtil bdUtil;
    private OngRepository ongRepo;

    public AvaliacaoRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert(String comentario, Classificacao classificacao, Ong ong){
        ContentValues valores = new ContentValues();
        valores.put("COMENTARIO", comentario);
        valores.put("CLASSIFICACAO", classificacao.getDesc());
        valores.put("ID_ONG", ongRepo.findId(ong));
        long resultado = bdUtil.getConexao().insert("AVALIACAO", null, valores);
        if (resultado ==-1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }
    public Integer delete(int codigo){
        Integer linhasAfetadas = bdUtil.getConexao().delete("AVALIACAO","_ID = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Avaliacao> getAll(){
        List<Avaliacao> avaliacaos = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, COMETARIO, CLASSIFICACAO, ID_ONG ");
        stringBuilderQuery.append("FROM  AVALIACAO ");
        stringBuilderQuery.append("ORDER BY COMENTARIO");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Avaliacao avaliacao = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo avaliacao
            avaliacao =  new Avaliacao();
            //adiciona os dados no objeto
            avaliacao.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            avaliacao.setComentario(cursor.getString(cursor.getColumnIndex("COMENTARIO")));
            avaliacao.setClassificacao(Classificacao.toEnum(cursor.getString(cursor.getColumnIndex("CLASSIFICACAO"))));
            //adiciona o objeto na lista
            avaliacaos.add(avaliacao);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return avaliacaos;
    }
    public Avaliacao getAvaliacao(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM AVALIACAO WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Avaliacao t = new Avaliacao();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setComentario(cursor.getString(cursor.getColumnIndex("COMENTARIO")));
        t.setClassificacao(Classificacao.toEnum(cursor.getString(cursor.getColumnIndex("CLASSIFICACAO"))));
        bdUtil.close();
        return t;
    }

    public int update(Avaliacao avaliacao){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("COMENTARIO",       avaliacao.getComentario());
        contentValues.put("CLASSIFICACAO",   avaliacao.getClassificacao().getDesc());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("AVALIACAO", contentValues, "_id = ?", new String[]{Integer.toString(avaliacao.get_id())});
        bdUtil.close();
        return retorno;
    }*/
}
