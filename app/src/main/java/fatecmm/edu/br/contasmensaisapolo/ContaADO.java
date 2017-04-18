package fatecmm.edu.br.contasmensaisapolo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.renderscript.Script;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apolo on 04-07-2016.
 */
public class ContaADO  {

    private SQLiteDatabase database;
    private CustomSQLiteOpenHelper customSQLiteOpenHelper;

    public String[] COLUMNS = {CustomSQLiteOpenHelper.COLUMN_ID,CustomSQLiteOpenHelper.COLUMN_DESCRICAO,CustomSQLiteOpenHelper.COLUMN_VALOR};


    public ContaADO(Context context){
        customSQLiteOpenHelper = new CustomSQLiteOpenHelper(context);
    }

    public void open(){
        database = customSQLiteOpenHelper.getWritableDatabase();
    }

    public void close(){
        database.close();
    }

    public List<Conta> getAll(){
        List<Conta> contaList = new ArrayList<Conta>();

        Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_NAME, COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Conta conta = new Conta();
            conta.setId(cursor.getInt(0));
            conta.setDescricao(cursor.getString(1));
            conta.setValor(cursor.getDouble(2));
            contaList.add(conta);
            Log.i("Teste de valor:",conta.getDescricao());
            cursor.moveToNext();
        }

        return contaList;
    }

    public void insertConta(String descricao,Double valor){
        ContentValues contentValues = new ContentValues();

        contentValues.put(CustomSQLiteOpenHelper.COLUMN_DESCRICAO, descricao);
        contentValues.put(CustomSQLiteOpenHelper.COLUMN_VALOR, valor);

        long insertId = database.insert(CustomSQLiteOpenHelper.TABLE_NAME,null,contentValues);
    }



}
