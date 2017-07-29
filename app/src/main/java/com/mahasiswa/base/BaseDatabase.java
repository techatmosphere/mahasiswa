package com.mahasiswa.base;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = BaseDatabase.NAME, version = BaseDatabase.VERSION)
public class BaseDatabase {
    public static final String NAME = "kampus";
    public static final int VERSION = 1;
}
