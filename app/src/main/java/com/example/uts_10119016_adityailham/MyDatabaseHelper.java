package com.example.uts_10119016_adityailham;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

//NIM     : 10119016
//NAMA    : ADITYA ILHAM SUBAGJA
//KELAS   : IF-1


public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context ctx;
    private static final String  DATABASE_NAME ="db_catatan.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "tbl_catatan";
    private static final String FIELD_ID = "id";
    private static final String FIELD_JUDUL = "judul";
    private static final String FIELD_PENULIS = "kategori";
    private static final String FIELD_ISI = "isi";
    private static final String FIELD_TAHUN = "tahun";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FIELD_JUDUL + " TEXT, " +
                FIELD_PENULIS + " TEXT, "+
                FIELD_ISI + " TEXT, " +
                FIELD_TAHUN + " INTEGER ); " ;

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long tambahBuku(String judul, String isi, String kategori, int tahun) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(FIELD_JUDUL, judul);
        cv.put(FIELD_PENULIS, kategori);
        cv.put(FIELD_ISI, isi);
        cv.put(FIELD_TAHUN, tahun);

        long eksekusi = db.insert(TABLE_NAME, null, cv);

        return eksekusi;

//        if (eksekusi == -1){
//            Toast.makeText(ctx, "Gagal Menambah Data", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(ctx, "Catatan Berhasil Ditambah", Toast.LENGTH_SHORT).show();
//        }
    }

    /*Fungsi untuk mengubah data*/
    public boolean updateData(String id, String judul, String isi, String date, String kategori, String year) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FIELD_ID, id);
        contentValues.put(FIELD_JUDUL, judul);
        contentValues.put(FIELD_PENULIS, kategori);
        contentValues.put(FIELD_ISI, isi);
        contentValues.put(FIELD_TAHUN, year);


        long results = db.update(TABLE_NAME, contentValues, FIELD_ID + " = ? ", new String[]{id});

        return results != -1;
    }

    /*Fungsi untuk mengambil data yang ada*/
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        return  db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
    }

    /*Fungsi untuk menghapus data yang dipilih*/
    public Integer deteleData(String id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, FIELD_ID + " = ? ", new String[]{id});
    }
    public Cursor bacaSemuaData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }

        return cursor;
    }
}
