package com.mahasiswa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahasiswa.R;

public class MahasiswaFragment extends Fragment{

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mahasiswa, container, false);

        nama = (TextView) rootView.findViewById(R.id.nama);
        tempatLahir = (TextView) rootView.findViewById(R.id.tempat_lahir);
        tanggalLahir = (TextView) rootView.findViewById(R.id.tanggal_lahir);

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

        return rootView;
    }
}
