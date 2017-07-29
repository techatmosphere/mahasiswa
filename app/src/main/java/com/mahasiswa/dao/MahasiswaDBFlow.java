package com.mahasiswa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mahasiswa.base.BaseDatabase;
import com.mahasiswa.model.Mahasiswa;
import com.mahasiswa.model.Mahasiswa_Table;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaDBFlow {

    public boolean insertMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswa.save();
    }

    public Mahasiswa getMahasiswaByID(String id) {
        return SQLite.select().from(Mahasiswa.class)
                .where(Mahasiswa_Table.id.eq(id))
                .querySingle();
    }

    public List<Mahasiswa> getListMahasiswa() {
        return SQLite.select().from(Mahasiswa.class).queryList();
    }

    public boolean updateMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswa.save();
    }

    public boolean deleteMahasiswa(Mahasiswa mahasiswa) {
        return mahasiswa.delete();
    }
}