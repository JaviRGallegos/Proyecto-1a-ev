package com.example.proyecto_1a_evaluacion_javier_rodriguez_gallegos.Connections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBConnection extends SQLiteOpenHelper {

    private static final String DB_NAME = "Users";

    private static final String DB_TABLE_NAME = "db_users";

    private static final int DB_VERSION = 3;

    private static final String USER_COLUMN = "user";
    private static final String PASSWORD_COLUMN = "password";

    private Context myContext;


    public DBConnection(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        myContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_USER_TABLE = "CREATE TABLE " +DB_TABLE_NAME+ "("
                +USER_COLUMN+ " TEXT," +
                PASSWORD_COLUMN + "TEXT);";
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);

        Log("Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {
        Log("Upgrade");
        Log("Old version -> " + oldversion);

        switch(oldversion){
            case 1:
                sqLiteDatabase.execSQL("ALTER TABLE " + DB_TABLE_NAME + " ADD COLUMN " + USER_COLUMN + " TEXT");
                Log.i("DB", "DB updated to version 2");
            case 2:
                sqLiteDatabase.execSQL("ALTER TABLE " + DB_TABLE_NAME + " ADD COLUMN " + PASSWORD_COLUMN + " TEXT");
                Log.i("DB", "DB updated to version 3");
        }
    }

    public ArrayList<String[]> getAllUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String[]> resultUsers = new ArrayList<>();

        String[] cols = new String[] {USER_COLUMN, PASSWORD_COLUMN};

        Cursor cursor = db.query(DB_TABLE_NAME, cols, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                String user = cursor.getString(0);
                String password = cursor.getString(1);
                cols[0] = user;
                cols[1] = password;

                resultUsers.add(cols);
            } while (cursor.moveToNext());
        }

        return  resultUsers;
    }

    public void getDBVersion(){
        Log(Integer.toString(this.getReadableDatabase().getVersion()));
    }

    public long insert(String user, String password){
        SQLiteDatabase db =this.getWritableDatabase();
        long result = -1;

        ContentValues insValues = new ContentValues();

        insValues.put(USER_COLUMN, user);
        insValues.put(PASSWORD_COLUMN, password);

        result = db.insert(DB_TABLE_NAME, null, insValues);
        db.close();

        return result;
    }

    public void check_user_pass(String user, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        long result = -1;
        // TODO: comprobar usuario
    }
    private void Log(String msg) {
        Log.d("DB", msg);
    }
}
