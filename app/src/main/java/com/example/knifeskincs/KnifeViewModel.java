package com.example.knifeskincs;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.knifeskincs.data.dao.KnifeDao;
import com.example.knifeskincs.data.models.Knife;

import java.util.List;

public class KnifeViewModel {
    private KnifeDao mDao;
    public void setDao(KnifeDao dao) {
        mDao = dao;
    }
    public KnifeViewModel(@NonNull Application application) {
        super(application);
    }
    public void createKnife(String name, String skin, String etat) {
        Knife newKnife = new Knife(name, skin, etat);
        InsertKnifeAsyncTask task = new InsertKnifeAsyncTask(mDao, newKnife);
    }
    public LiveData<List<Knife>> getAllKnifes() {
        return mDao.getAllKnifes();
    }
    private static class InsertKnifeAsyncTask extends AsyncTask<Void, Void, Void> {
        private KnifeDao mDao;
        private Knife mKnife;
        public InsertKnifeAsyncTask(KnifeDao dao, Knife knife) {
            mDao = dao;
            mKnife = knife;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            mDao.insertKnife(mKnife);
            return null;
        }
    }
}
