package com.mahasiswa.fragment;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.mahasiswa.R;
import com.mahasiswa.adapter.MahasiswaButterAdapter;
import com.mahasiswa.dao.MahasiswaDAO;
import com.mahasiswa.model.Mahasiswa;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MahasiswaButterFragment extends Fragment{

    private Unbinder unbinder;

    MahasiswaButterAdapter adapter;

    @BindView(R.id.list_mahasiswa)
    ListView listView;

    MahasiswaDAO dao;
    ArrayList<Mahasiswa> list;

    ProgressDialog progress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mahasiswa, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        dao = new MahasiswaDAO(getActivity());
        list = new ArrayList<>();

        adapter = new MahasiswaButterAdapter(list);
        listView.setAdapter(adapter);

        new MahasiswaAction().execute();

        return rootView;
    }

    private class MahasiswaAction extends AsyncTask<String, Void, ArrayList<Mahasiswa>> {

        protected void onPreExecute() {
            progress = new ProgressDialog(getContext());
            progress.setTitle("Loading");
            progress.setMessage("Wait while loading...");
            progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
            progress.show();
        }

        @Override
        protected ArrayList<Mahasiswa> doInBackground(String... params) {

            for (int i = 0;i<100;i++){
                Mahasiswa mhs = new Mahasiswa();
                mhs.setIdMahasiswa(String.valueOf(i));
                mhs.setNamaMahasiswa("Budiman");
                mhs.setTempatLahir("Bandung");
                mhs.setTanggalLahir("07-02-1990");
                dao.insertMahasiswa(mhs);
            }

            return dao.getListMahasiswa();
        }

        protected void onPostExecute(ArrayList<Mahasiswa> resultList) {
            list.clear();
            list.addAll(resultList);
            adapter.notifyDataSetChanged();
            progress.dismiss();
        }
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
