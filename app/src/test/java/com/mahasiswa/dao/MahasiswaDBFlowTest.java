package com.mahasiswa.dao;

import android.support.compat.BuildConfig;
import com.mahasiswa.base.BaseDatabase;
import com.mahasiswa.model.Mahasiswa;
import com.raizlabs.android.dbflow.config.FlowManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MahasiswaDBFlowTest {

    private MahasiswaDBFlow mahasiswaDBFlow;

    @Before
    public void setUp() throws Exception {
        ShadowLog.stream = System.out;
        FlowManager.init(RuntimeEnvironment.application);
        FlowManager.getDatabase(BaseDatabase.class).getWritableDatabase();

        mahasiswaDBFlow = new MahasiswaDBFlow();
    }

    @After
    public void tearDown() throws Exception {
        FlowManager.destroy();
    }

    @Test
    public void getListMahasiswa() throws Exception {
        int mahasiswaSize = 5;

        for(int i = 0;i< mahasiswaSize;i++){
            Mahasiswa temp = new Mahasiswa();
            temp.setIdMahasiswa("M0031170"+i);
            temp.setNamaMahasiswa("MAHMUD"+i);

            mahasiswaDBFlow.insertMahasiswa(temp);
        }

        List<Mahasiswa> listMahasiswa = mahasiswaDBFlow.getListMahasiswa();
        assertNotNull(listMahasiswa);
        assertEquals(listMahasiswa.size(), mahasiswaSize);
        ShadowLog.i("jumlah total mahasiswa", String.valueOf(listMahasiswa.size()));

    }

    @Test
    public void updateMahasiswa() throws Exception {
        Mahasiswa temp = new Mahasiswa();
        temp.setIdMahasiswa("M00311700");
        temp.setNamaMahasiswa("Budi");
        temp.setTempatLahir("Kalimantan");

        SimpleDateFormat format = new SimpleDateFormat( "dd-MM-yyyy" );
        Date myDate = format.parse( "10-02-2017" );

        temp.setTanggalLahir(myDate);
        mahasiswaDBFlow.insertMahasiswa(temp);

        //get data berdasarkan id
        Mahasiswa updateMahasiswa = mahasiswaDBFlow.getMahasiswaByID(temp.getIdMahasiswa());

        //update nama mahasiswa
        updateMahasiswa.setNamaMahasiswa("Budiman");
        mahasiswaDBFlow.updateMahasiswa(updateMahasiswa);

        //get data yang sudah di update
        Mahasiswa updatedMahasiswa = mahasiswaDBFlow.getMahasiswaByID(temp.getIdMahasiswa());
        assertNotNull(updatedMahasiswa);
        assertEquals(updatedMahasiswa.getNamaMahasiswa(), "Budiman");

        ShadowLog.i("nama mahasiswa", updatedMahasiswa.getNamaMahasiswa());
    }

    @Test
    public void deleteMahasiswa() throws Exception {
        int mahasiswaSize = 5;

        for(int i = 0;i< mahasiswaSize;i++){
            Mahasiswa temp = new Mahasiswa();
            temp.setIdMahasiswa("M0031170"+i);
            temp.setNamaMahasiswa("MAHMUD"+i);

            mahasiswaDBFlow.insertMahasiswa(temp);
        }

        Mahasiswa deletedMahasiswa = mahasiswaDBFlow.getMahasiswaByID("M00311701");
        mahasiswaDBFlow.deleteMahasiswa(deletedMahasiswa);

        List<Mahasiswa> listMahasiswa = mahasiswaDBFlow.getListMahasiswa();
        assertNotNull(listMahasiswa);
        assertEquals(listMahasiswa.size(), mahasiswaSize-1);
        ShadowLog.i("jumlah total mahasiswa", String.valueOf(listMahasiswa.size()));

    }
}
