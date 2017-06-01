package com.mahasiswa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mahasiswa.R;
import com.mahasiswa.model.Mahasiswa;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MahasiswaButterAdapter extends BaseAdapter {

    List<Mahasiswa> listMahasiswa;
    LayoutInflater inflater = null;

    public MahasiswaButterAdapter(List listMahasiswa){
        this.listMahasiswa = listMahasiswa;
    }

    @Override
    public int getCount() {
        return listMahasiswa.size();
    }

    @Override
    public Object getItem(int i) {
        return listMahasiswa.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHolder viewHolder;

        if (inflater == null)
            inflater = (LayoutInflater) viewGroup.getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (null == view) {
            view = inflater.inflate(R.layout.item_mahasiswa, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // getting movie data for the row
        final Mahasiswa mhs = listMahasiswa.get(i);

        viewHolder.nama.setText("Budiman");
        viewHolder.tempatLahir.setText("Bandung");
        viewHolder.tanggalLahir.setText("07-02-1990");
        viewHolder.jenisKelamin.setText("Laki-laki");
        viewHolder.golonganDarah.setText("O");
        viewHolder.alamat.setText("Jl. Kahuripan no 11");
        viewHolder.agama.setText("Islam");
        viewHolder.status.setText("Belum Menikah");
        viewHolder.pekerjaan.setText("Mahasiswa");
        viewHolder.kewarganegaraan.setText("WNI");

        return view;
    }

    static class ViewHolder {
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

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
