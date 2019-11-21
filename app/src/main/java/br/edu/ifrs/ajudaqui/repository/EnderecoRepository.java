package br.edu.ifrs.ajudaqui.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.domain.Endereco;
import br.edu.ifrs.ajudaqui.util.BDUtil;

public class EnderecoRepository {
    /*private BDUtil bdUtil;

    public EnderecoRepository(Context context){
        bdUtil =  new BDUtil(context);
    }

    public String insert(String cep, String rua, String numero){
        ContentValues valores = new ContentValues();
        valores.put("CEP", cep);
        valores.put("RUA", rua);
        valores.put("NUMERO", numero);
        long resultado = bdUtil.getConexao().insert("ENDERECO", null, valores);
        if (resultado == -1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }
    public Integer delete(int codigo){
        Integer linhasAfetadas = bdUtil.getConexao().delete("ENDERECO","_id = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Endereco> getAll(){
        List<Endereco> enderecos = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, CEP, RUA, NUMERO ");
        stringBuilderQuery.append("FROM  ENDERECO ");
        stringBuilderQuery.append("ORDER BY CEP");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Endereco endereco = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()){
            // Cria objetos do tipo endereco
            endereco =  new Endereco();
            //adiciona os dados no objeto
            endereco.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            endereco.setCep(cursor.getString(cursor.getColumnIndex("CEP")));
            endereco.setRua(cursor.getString(cursor.getColumnIndex("RUA")));
            endereco.setNumero(cursor.getString(cursor.getColumnIndex("NUMERO")));
            //adiciona o objeto na lista
            enderecos.add(endereco);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return enderecos;
    }
    public Endereco getEndereco(int codigo){
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM ENDERECO WHERE _ID = "+ codigo,null);
        cursor.moveToFirst();
        Endereco t = new Endereco();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setCep(cursor.getString(cursor.getColumnIndex("CEP")));
        t.setRua(cursor.getString(cursor.getColumnIndex("RUA")));
        t.setNumero(cursor.getString(cursor.getColumnIndex("NUMERO")));
        bdUtil.close();
        return t;
    }

    public int update(Endereco endereco){
        ContentValues contentValues =  new ContentValues();
        contentValues.put("CEP",       endereco.getCep());
        contentValues.put("RUA",   endereco.getRua());
        contentValues.put("NUMERO",       endereco.getNumero());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("ENDERECO", contentValues, "_id = ?", new String[]{Integer.toString(endereco.get_id())});
        bdUtil.close();
        return retorno;
    }

    public int findId (Endereco endereco){
        int retorno = 0;
        Cursor cursor =  bdUtil.getConexao().rawQuery("SELECT * FROM ENDERECO WHERE CEP = "+ endereco.getCep(),null);
        cursor.moveToFirst();
        retorno = cursor.getInt(cursor.getColumnIndex("_ID"));
        bdUtil.close();
        return retorno;
    }*/
}
