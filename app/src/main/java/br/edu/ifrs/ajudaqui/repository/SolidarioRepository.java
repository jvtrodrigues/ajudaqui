package br.edu.ifrs.ajudaqui.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.ajudaqui.domain.Solidario;
import br.edu.ifrs.ajudaqui.util.BDUtil;

public class SolidarioRepository {
    /*private BDUtil bdUtil;

    public SolidarioRepository(Context context) {
        bdUtil = new BDUtil(context);
    }

    public String insert(String nome, String identificador, String senha, String email, String cpf, String dataDeNascimento) {
        ContentValues valores = new ContentValues();
        valores.put("NOME", nome);
        valores.put("IDENTIFICADOR", identificador);
        valores.put("SENHA", senha);
        valores.put("EMAIL", email);
        valores.put("CPF", cpf);
        valores.put("DATA_NASC", dataDeNascimento);
        long resultado = bdUtil.getConexao().insert("SOLIDARIO", null, valores);
        if (resultado == -1) {
            bdUtil.close();
            return "Erro ao inserir registro";
        }
        return "Registro Inserido com sucesso";
    }

    public Integer delete(int codigo) {
        Integer linhasAfetadas = bdUtil.getConexao().delete("SOLIDARIO", "_id = ?", new String[]{Integer.toString(codigo)});
        bdUtil.close();
        return linhasAfetadas;
    }

    public List<Solidario> getAll() {
        List<Solidario> solidarios = new ArrayList<>();

        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT _ID, NOME, IDENTIFICADOR, SENHA, EMAIL, CPF, ");
        stringBuilderQuery.append(" DATA_NASC ");
        stringBuilderQuery.append("FROM  SOLIDARIO ");
        stringBuilderQuery.append("ORDER BY NOME");

        Cursor cursor = bdUtil.getConexao().rawQuery(stringBuilderQuery.toString(), null);
        cursor.moveToFirst();
        Solidario solidario = null;
        while (!cursor.isAfterLast()) {
            // Cria objetos do tipo solidario
            solidario = new Solidario();
            //adiciona os dados no objeto
            solidario.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
            solidario.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
            solidario.setIdentificador(cursor.getString(cursor.getColumnIndex("IDENTIFICADOR")));
            solidario.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));
            solidario.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
            solidario.setCpf(cursor.getString(cursor.getColumnIndex("CPF")));
            solidario.setDataDeNascimento(cursor.getString(cursor.getColumnIndex("DATA_NASC")));
            //adiciona o objeto na lista
            solidarios.add(solidario);
            //aponta para o próximo registro
            cursor.moveToNext();
        }
        bdUtil.close();
        //retorna a lista de objetos
        return solidarios;
    }

    public Solidario getSolidario(int codigo) {
        Cursor cursor = bdUtil.getConexao().rawQuery("SELECT * FROM SOLIDARIO WHERE _ID = " + codigo, null);
        cursor.moveToFirst();
        Solidario t = new Solidario();
        t.set_id(cursor.getInt(cursor.getColumnIndex("_ID")));
        t.setNome(cursor.getString(cursor.getColumnIndex("NOME")));
        t.setIdentificador(cursor.getString(cursor.getColumnIndex("IDENTIFICADOR")));
        t.setSenha(cursor.getString(cursor.getColumnIndex("SENHA")));
        t.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
        t.setCpf(cursor.getString(cursor.getColumnIndex("CPF")));
        t.setDataDeNascimento(cursor.getString(cursor.getColumnIndex("DATA_NASC")));
        bdUtil.close();
        return t;
    }

    public int update(Solidario solidario) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOME", solidario.getNome());
        contentValues.put("IDENTIFICADOR", solidario.getIdentificador());
        contentValues.put("SENHA", solidario.getSenha());
        contentValues.put("EMAIL", solidario.getEmail());
        contentValues.put("CPF", solidario.getCpf());
        contentValues.put("DATA_NASC", solidario.getDataDeNascimento());
        //atualiza o objeto usando a chave
        int retorno = bdUtil.getConexao().update("SOLIDARIO", contentValues, "_id = ?", new String[]{Integer.toString(solidario.get_id())});
        bdUtil.close();
        return retorno;
    }*/
}
