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

        viewHolder.nama.setText(mhs.getNamaMahasiswa());
        viewHolder.tempatLahir.setText(mhs.getTempatLahir());
        viewHolder.tanggalLahir.setText(mhs.getTanggalLahir());

        return view;
    }

    static class ViewHolder {
        @BindView(R.id.nama) TextView nama;
        @BindView(R.id.tempat_lahir) TextView tempatLahir;
        @BindView(R.id.tanggal_lahir) TextView tanggalLahir;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
