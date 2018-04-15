package br.usjt.desmob.paises;

import android.provider.BaseColumns;

/**
 * Created by Alessandro Henrique on 15/4/2018.
 * RA 816117880
 */

public class PaisContract {
    public static abstract class PaisEntry implements BaseColumns {
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_REGIAO = "regiao";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_BANDEIRA = "bandeira";
        public static final String COLUMN_NAME_CODIGO3 = "codigo3";
        public static final String COLUMN_NAME_SUBREGIAO = "subregiao";
        public static final String COLUMN_NAME_DEMONIMO = "demonimo";
        public static final int COLUMN_NAME_POPULACAO = Integer.parseInt( "populacao" );
        public static final int COLUMN_NAME_AREA = Integer.parseInt( "area" );
        public static final double COLUMN_NAME_GINI = Double.parseDouble( "gini" );
        public static final double COLUMN_NAME_LONGITUDE = Double.parseDouble("longitude");
        public static final double COLUMN_NAME_LATITUDE = Double.parseDouble("latitude");


    }
}
