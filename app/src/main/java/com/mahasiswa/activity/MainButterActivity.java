package com.mahasiswa.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mahasiswa.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainButterActivity extends AppCompatActivity {

    @BindView(R.id.nama) TextView nama;
    @BindView(R.id.tempat_lahir) TextView tempatLahir;
    @BindView(R.id.tanggal_lahir) TextView tanggalLahir;
    @BindView(R.id.jenis_kelamin) TextView jenisKelamin;
    @BindView(R.id.golongan_darah) TextView golonganDarah;
    @BindView(R.id.alamat) TextView alamat;
    @BindView(R.id.agama) TextView agama;
    @BindView(R.id.status) TextView status;
    @BindView(R.id.pekerjaan) TextView pekerjaan;
    @BindView(R.id.kewarganegaraan) TextView kewarganegaraan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

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

    }

    @OnClick(R.id.save)
    public void onClickSave(){

    }
}
