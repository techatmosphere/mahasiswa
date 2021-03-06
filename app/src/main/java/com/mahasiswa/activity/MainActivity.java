package com.mahasiswa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mahasiswa.R;

public class MainActivity extends AppCompatActivity {

    TextView nama;
    TextView tempatLahir;
    TextView tanggalLahir;
    TextView jenisKelamin;
    TextView golonganDarah;
    TextView alamat;
    TextView agama;
    TextView status;
    TextView pekerjaan;
    TextView kewarganegaraan;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (TextView) findViewById(R.id.nama);
        tempatLahir = (TextView) findViewById(R.id.tempat_lahir);
        tanggalLahir = (TextView) findViewById(R.id.tanggal_lahir);
        jenisKelamin = (TextView) findViewById(R.id.jenis_kelamin);
        golonganDarah = (TextView) findViewById(R.id.golongan_darah);
        alamat = (TextView) findViewById(R.id.alamat);
        agama = (TextView) findViewById(R.id.agama);
        status = (TextView) findViewById(R.id.status);
        pekerjaan = (TextView) findViewById(R.id.pekerjaan);
        kewarganegaraan = (TextView) findViewById(R.id.kewarganegaraan);

        save = (Button) findViewById(R.id.save);

        nama.setText("Budiman");
        tempatLahir.setText("Bandung");
        tanggalLahir.setText("07-02-1990");
        jenisKelamin.setText("Laki-laki");
        golonganDarah.setText("O");
        alamat.setText("Jl. Kahuripan no 11");
        agama.setText("Islam");
        status.setText("Belum Menikah");
        pekerjaan.setText("Mahasiswa");
        kewarganegaraan.setText("WNI");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
