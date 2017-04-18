package fatecmm.edu.br.contasmensaisapolo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Apolo on 04-07-2016.
 */
public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

    public static final String NAME_DB="contas.db";
    public static final String TABLE_NAME="Conta";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_DESCRICAO="Descricao";
    public static final String COLUMN_VALOR="Valor";
    public static final int VERSION_DB=1;


    public String CREATE_TABLE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement,"
            + COLUMN_DESCRICAO + " varchar(50),"
            + COLUMN_VALOR + " double);";

    public CustomSQLiteOpenHelper(Context context){
        super(context,NAME_DB,null,VERSION_DB);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
