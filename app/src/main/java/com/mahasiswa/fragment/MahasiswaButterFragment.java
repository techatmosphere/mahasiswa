package com.mahasiswa.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahasiswa.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MahasiswaButterFragment extends Fragment{

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

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mahasiswa, container, false);
        unbinder = ButterKnife.bind(this, rootView);

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

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
