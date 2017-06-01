package com.mahasiswa.dao;

import android.support.compat.BuildConfig;

import com.mahasiswa.model.Mahasiswa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MahasiswaDAOTest {
    private MahasiswaDAO mahasiswaDAO;
    private Mahasiswa mahasiswaTestData;

    @Before
    public void setUp() throws Exception {
        mahasiswaDAO = new MahasiswaDAO(RuntimeEnvironment.application);
    }

    @After
    public void tearDown() throws Exception {

    }

    public void setupMahasiswa(){
        mahasiswaTestData = new Mahasiswa();
        mahasiswaTestData.setIdMahasiswa("M00311708");
        mahasiswaTestData.setNamaMahasiswa("BUDIMAN");
    }

    @Test
    public void insertMahasiswa() throws Exception {
        setupMahasiswa();

        boolean inserted = mahasiswaDAO.insertMahasiswa(mahasiswaTestData);
        assertEquals(inserted, true);
    }

    @Test
    public void getMahasiswaByID() throws Exception {
        setupMahasiswa();

        boolean inserted = mahasiswaDAO.insertMahasiswa(mahasiswaTestData);

        Mahasiswa insertedMahasiswa = mahasiswaDAO.getMahasiswaByID(mahasiswaTestData);
        assertEquals(inserted, true);
        assertNotNull(insertedMahasiswa);
        assertEquals(insertedMahasiswa.getIdMahasiswa(), mahasiswaTestData.getIdMahasiswa());
        assertEquals(insertedMahasiswa.getNamaMahasiswa(), mahasiswaTestData.getNamaMahasiswa());
    }

    @Test
    public void getListMahasiswa() throws Exception {

        ArrayList<Mahasiswa> values = new ArrayList<>();
        for(int i = 0;i< 5;i++){
            Mahasiswa temp = new Mahasiswa();
            temp.setIdMahasiswa("M0031170"+i);
            temp.setNamaMahasiswa("MAHMUD"+i);

            values.add(temp);
            mahasiswaDAO.insertMahasiswa(temp);
        }

        ArrayList<Mahasiswa> listMahasiswa = mahasiswaDAO.getListMahasiswa();
        assertNotNull(listMahasiswa);
        assertEquals(listMahasiswa.size(), values.size());
        assertEquals(listMahasiswa.get(0).getIdMahasiswa(), listMahasiswa.get(0).getIdMahasiswa());
        assertEquals(listMahasiswa.get(0).getNamaMahasiswa(), listMahasiswa.get(0).getNamaMahasiswa());
    }

}