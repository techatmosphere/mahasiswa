package com.mahasiswa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.mahasiswa.model.Mahasiswa;

import java.util.ArrayList;

public class MahasiswaDAO extends SQLiteOpenHelper{

    public MahasiswaDAO(Context context) {
        super(context, "mahasiswa.db", null, 1);
    }

    public boolean insertMahasiswa(Mahasiswa mahasiswa) {
        long result = -1;

        try {

            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("id_mahasiswa", mahasiswa.getIdMahasiswa());
            contentValues.put("nama_mahasiswa", mahasiswa.getNamaMahasiswa());
            contentValues.put("tempat", mahasiswa.getTempatLahir());
            contentValues.put("tanggal_lahir", mahasiswa.getTanggalLahir());

            result = db.insert("mahasiswa", null, contentValues);

            db.close();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }

        return result != -1;
    }

    public Mahasiswa getMahasiswaByID(Mahasiswa param) {
        Mahasiswa mahasiswa = new Mahasiswa();

        try{

            Cursor res = getReadableDatabase()
                .rawQuery("select id_mahasiswa, nama_mahasiswa from mahasiswa where id_mahasiswa = ?"
                    , new String[]{param.getIdMahasiswa()});

            while (res.moveToNext()) {
                String id = res.getString(res.getColumnIndex("id_mahasiswa"));
                String nama = res.getString(res.getColumnIndex("nama_mahasiswa"));

                mahasiswa.setIdMahasiswa(id);
                mahasiswa.setNamaMahasiswa(nama);
            }

            res.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }

        return mahasiswa;
    }

    public ArrayList<Mahasiswa> getListMahasiswa() {
        ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();

        try{

            Cursor res = getReadableDatabase()
                    .rawQuery("select id_mahasiswa, nama_mahasiswa, tempat, tanggal_lahir from mahasiswa", null);

            while (res.moveToNext()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                String id = res.getString(res.getColumnIndex("id_mahasiswa"));
                String name = res.getString(res.getColumnIndex("nama_mahasiswa"));
                String tempat = res.getString(res.getColumnIndex("tempat"));
                String tanggalLahir = res.getString(res.getColumnIndex("tanggal_lahir"));

                mahasiswa.setIdMahasiswa(id);
                mahasiswa.setNamaMahasiswa(name);
                mahasiswa.setTempatLahir(tempat);
                mahasiswa.setTanggalLahir(tanggalLahir);
                listMahasiswa.add(mahasiswa);
            }

            res.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            this.close();
        }

        return listMahasiswa;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table IF NOT EXISTS mahasiswa(\n" +
                "    id_mahasiswa TEXT primary key,\n" +
                "    nama_mahasiswa TEXT,\n" +
                "    tempat TEXT,\n" +
                "    tanggal_lahir TEXT\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}