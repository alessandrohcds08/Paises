package br.usjt.desmob.paises;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Alessandro Henrique on 15/4/2018.
 * RA 816117880
 */

public class PaisDb {
    PaisDbHelper dbHelper;

    public PaisDb(Context contexto){
        dbHelper = new PaisDbHelper(contexto);
    }

    public void inserePaises(Pais[] paises){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(PaisContract.PaisEntry.TABLE_NAME, null, null);

        for(Pais pais:paises){
            ContentValues values = new ContentValues();
            values.put(PaisContract.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            values.put(PaisContract.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());

            db.insert(PaisContract.PaisEntry.TABLE_NAME, null, values);
        }
    }

    public Pais[] selecionaPaises(){
        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = { PaisContract.PaisEntry.COLUMN_NAME_NOME,
                PaisContract.PaisEntry.COLUMN_NAME_REGIAO,
                PaisContract.PaisEntry.COLUMN_NAME_CAPITAL,
                PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA,
                PaisContract.PaisEntry.COLUMN_NAME_CODIGO3,
                String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_LONGITUDE ),
                String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_LATITUDE ),
                String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_GINI ),
                PaisContract.PaisEntry.COLUMN_NAME_SUBREGIAO,
                String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_POPULACAO ),
                PaisContract.PaisEntry.COLUMN_NAME_DEMONIMO,
                String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_AREA )};
        String ordem = PaisContract.PaisEntry.COLUMN_NAME_NOME;

        Cursor c = db.query(PaisContract.PaisEntry.TABLE_NAME, colunas, null, null,
                ordem, null, null);
        while(c.moveToNext()) {
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_REGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_CODIGO3)));
            pais.setLongitude(c.getDouble(c.getColumnIndex(String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_LONGITUDE ) )));
            pais.setLatitude(c.getDouble(c.getColumnIndex( String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_LATITUDE ) )));
            pais.setGini(c.getDouble(c.getColumnIndex( String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_GINI ) )));
            pais.setSubRegiao(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_SUBREGIAO)));
            pais.setPopulacao(c.getInt(c.getColumnIndex( String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_POPULACAO ) )));
            pais.setDemonimo(c.getString(c.getColumnIndex(PaisContract.PaisEntry.COLUMN_NAME_DEMONIMO)));
            pais.setArea(c.getInt(c.getColumnIndex( String.valueOf( PaisContract.PaisEntry.COLUMN_NAME_AREA ) )));

            paises.add(pais);
        }
        c.close();
        if(paises.size()> 0) {
            return paises.toArray(new Pais[0]);
        } else {
            return new Pais[0];
        }
    }
}

