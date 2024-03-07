package com.example.knifeskincs.utils;

import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.example.knifeskincs.data.database.AppDatabase;
import com.example.knifeskincs.data.models.Knife;

public class DatabaseInitializer {
    private static void populateWithKnifes(@NonNull AppDatabase database) {
        database.getKnifeDao().insertKnife(
                new Knife("M9 Bayonet", "Doppler", "Neuf"),
                new Knife("Karambit", "Tiger Tooth", "Neuf"),
                new Knife("Butterfly", "Fade", "Neuf")
        );
    }

    private static void populateDatabaseSync(@NonNull AppDatabase database) {
        populateWithKnifes(database);
    }
    public static void populateDatabaseAsync(@NonNull AppDatabase database) {
        PopulateDatabaseAsyncTask task = new PopulateDatabaseAsyncTask(database);
        task.execute();
    }
    private static class PopulateDatabaseAsyncTask extends AsyncTask<Void, Void, Void> {
        private AppDatabase mDatabase;
        public PopulateDatabaseAsyncTask(AppDatabase database) {
            mDatabase = database;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            populateDatabaseSync(mDatabase);
            return null;
        }
    }

}
