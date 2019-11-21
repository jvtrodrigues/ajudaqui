package br.edu.ifrs.ajudaqui.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper {
    private static final String BASE_DE_DADOS = "AJUDAQUI";
    private static final int VERSAO = 2;

    public BDUtil(Context context){
        super(context,BASE_DE_DADOS,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder criarTabela = new StringBuilder();

        criarTabela.append(" CREATE TABLE ONG (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME  TEXT   NOT NULL,");
        criarTabela.append(" IDENTIFICADOR   TEXT    NOT NULL,");
        criarTabela.append(" SENHA   TEXT    NOT NULL,");
        criarTabela.append(" EMAIL   TEXT    NOT NULL,");
        criarTabela.append(" ENDERECO_WEB   TEXT    NOT NULL,");
        criarTabela.append(" AREA  TEXT    NOT NULL,");
        criarTabela.append(" CEP  TEXT   NOT NULL,");
        criarTabela.append(" RUA   TEXT    NOT NULL,");
        criarTabela.append(" NUMERO  TEXT   NOT NULL);");
        db.execSQL(criarTabela.toString());
        criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE SOLIDARIO ( ");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" NOME  TEXT   NOT NULL,");
        criarTabela.append(" IDENTIFICADOR   TEXT    NOT NULL,");
        criarTabela.append(" SENHA   TEXT    NOT NULL,");
        criarTabela.append(" EMAIL   TEXT    NOT NULL,");
        criarTabela.append(" CPF   TEXT    NOT NULL,");
        criarTabela.append(" DATA_NASC  TEXT   NOT NULL);");
        db.execSQL(criarTabela.toString());
        criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE ACAO (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" DESCRICAO TEXT  NOT NULL,");
        criarTabela.append(" STATUS   TEXT    NOT NULL,");
        criarTabela.append(" ID_ONG   INTEGER    NOT NULL,");
        criarTabela.append(" FOREIGN KEY(ID_ONG) REFERENCES ONG(_ID));");
        db.execSQL(criarTabela.toString());
        criarTabela = new StringBuilder();
        criarTabela.append(" CREATE TABLE AVALIACAO (");
        criarTabela.append(" _ID   INTEGER PRIMARY KEY AUTOINCREMENT, ");
        criarTabela.append(" COMENTARIO TEXT  NOT NULL,");
        criarTabela.append(" CLASSIFICACAO   TEXT    NOT NULL,");
        criarTabela.append(" ID_ONG   INTEGER    NOT NULL,");
        criarTabela.append(" FOREIGN KEY(ID_ONG) REFERENCES ONG(_ID));");
        db.execSQL(criarTabela.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS AVALIACAO");
        db.execSQL("DROP TABLE IF EXISTS ACAO");
        db.execSQL("DROP TABLE IF EXISTS ONG");
        db.execSQL("DROP TABLE IF EXISTS SOLIDARIO");
        onCreate(db);

    }

    public SQLiteDatabase getConexao(){
        return this.getWritableDatabase();
    }
}
