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

public class MahasiswaAdapter extends BaseAdapter {

    List<Mahasiswa> listMahasiswa;
    LayoutInflater inflater = null;

    public MahasiswaAdapter(List listMahasiswa){
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
            viewHolder = new ViewHolder();

            viewHolder.nama = (TextView) view
                    .findViewById(R.id.nama);
            viewHolder.tempatLahir = (TextView) view
                    .findViewById(R.id.tempat_lahir);
            viewHolder.tanggalLahir = (TextView) view.findViewById(R.id.tanggal_lahir);
            viewHolder.jenisKelamin = (TextView) view.findViewById(R.id.jenis_kelamin);
            viewHolder.golonganDarah = (TextView) view.findViewById(R.id.golongan_darah);
            viewHolder.alamat = (TextView) view.findViewById(R.id.alamat);
            viewHolder.agama = (TextView) view.findViewById(R.id.agama);
            viewHolder.status = (TextView) view.findViewById(R.id.status);
            viewHolder.pekerjaan = (TextView) view.findViewById(R.id.pekerjaan);
            viewHolder.kewarganegaraan = (TextView) view.findViewById(R.id.kewarganegaraan);

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
    }
}
