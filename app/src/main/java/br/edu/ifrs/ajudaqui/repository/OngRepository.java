package br.edu.ifrs.ajudaqui.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.domain.Area;
import br.edu.ifrs.ajudaqui.domain.Ong;
import br.edu.ifrs.ajudaqui.util.BDUtil;

public class OngRepository {
   /* private BDUtil bdUtil;

    public OngRepository(Context context) {
        bdUtil = new BDUtil(context);
    }

    public String insert(String nome, String identificador, String senha, String email, String enderecoWeb, Area area, String cep, String rua, String numero) {
        ContentValues valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("IDENTIFICADOR", identificador);
        valores.put("SENHA", senha);
        valores.put("EMAIL", email);
        valores.put("ENDERECO_WEB", enderecoWeb);
        valores.put("AREA", area.getDesc());
        valores.put("CEP", cep);
        valores.put("RUA", rua);
        valores.put("NUMERO", numero);
        long resultado = bdUtil.getConexao().insert("ONG", null, valores);
        if (resultado == -1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }

    public Integer delete(int codigo) {
        Integer linhasAfetadas = bdUtil.getConexao().delete("ONG", "_id = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Ong> getAll() {
        List<Ong> ongs = new ArrayList<>();
        // monta a consulta
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, NOME, IDENTIFICADOR, SENHA, EMAIL, ");
        stringBuilderQuery.append("ENDERECO_WEB, AREA, CEP, RUA, NUMERO ");
        stringBuilderQuery.append("FROM  ONG ");
        stringBuilderQuery.append("ORDER BY NOME");
        //consulta os registros que estão no BD
        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        //aponta cursos para o primeiro registro
        cursor.moveToFirst();
        Ong ong = null;
        //Percorre os registros até atingir o fim da lista de registros
        while (!cursor.isAfterLast()) {
            // Cria objetos do tipo ong
            ong = new Ong();
            //adiciona os dados no objeto
            ong.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            ong.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            ong.setIdentificador(cursor.getString(cursor.getColumnIndex("IDENTIFICADOR")));
            ong.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));
            ong.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
            ong.setEnderecoWeb(cursor.getString(cursor.getColumnIndex("ENDERECO_WEB")));
            ong.setArea(Area.toEnum(cursor.getString(cursor.getColumnIndex("AREA"))));
            ong.setCep(cursor.getString(cursor.getColumnIndex("CEP")));
            ong.setRua(cursor.getString(cursor.getColumnIndex("RUA")));
            ong.setNumero(cursor.getString(cursor.getColumnIndex("NUMERO")));
            //adiciona o objeto na lista
            ongs.add(ong);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return ongs;
    }

    public Ong getOng(int codigo) {
        Cursor cursor = bdUtil.getConexao().rawQuery("SELECT * FROM ONG WHERE _ID = " + codigo, null);
        cursor.moveToFirst();
        Ong ong = new Ong();
        ong.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        ong.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
        ong.setIdentificador(cursor.getString(cursor.getColumnIndex("IDENTIFICADOR")));
        ong.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));
        ong.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
        ong.setEnderecoWeb(cursor.getString(cursor.getColumnIndex("ENDERECO_WEB")));
        ong.setArea(Area.toEnum(cursor.getString(cursor.getColumnIndex("AREA"))));
        ong.setCep(cursor.getString(cursor.getColumnIndex("CEP")));
        ong.setRua(cursor.getString(cursor.getColumnIndex("RUA")));
        ong.setNumero(cursor.getString(cursor.getColumnIndex("NUMERO")));
        bdUtil.close();
        return ong;
    }

    public int update(Ong ong) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", ong.getNome());
        contentValues.put("IDENTIFICADOR", ong.getIdentificador());
        contentValues.put("SENHA", ong.getSenha());
        contentValues.put("EMAIL", ong.getEmail());
        contentValues.put("ENDERECO_WEB", ong.getEnderecoWeb());
        contentValues.put("CEP", ong.getCep());
        contentValues.put("RUA", ong.getRua());
        contentValues.put("NUMERO", ong.getNumero());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("ONG", contentValues, "_id = ?", new String[]{Integer.toString(ong.get_id())});
        bdUtil.close();
        return retorno;
    }

    public int findId(Ong ong) {
        int retorno = 0;
        Cursor cursor = bdUtil.getConexao().rawQuery("SELECT * FROM ONG WHERE NOME = " + ong.getNome(), null);
        cursor.moveToFirst();
        retorno = cursor.getInt(cursor.getColumnIndex("_ID"));
        bdUtil.close();
        return retorno;
    }*/
}
