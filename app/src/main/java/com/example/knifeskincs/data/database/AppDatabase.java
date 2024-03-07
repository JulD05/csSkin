package com.example.knifeskincs.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.knifeskincs.data.models.Knife;
import com.example.knifeskincs.data.dao.KnifeDao;

@Database(entities = {Knife.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase sInstance = null;
    private static final String DATABASE_NAME = "KnifesCs.db";

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return sInstance;
    }

    public abstract KnifeDao getKnifeDao();

}
