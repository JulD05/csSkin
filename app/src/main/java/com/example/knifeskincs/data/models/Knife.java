package com.example.knifeskincs.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "knifes")
public class Knife {
    @ColumnInfo(name= "id")
    @PrimaryKey(autoGenerate = true)
        public int id;

    @ColumnInfo(name = "name")
    private String mName;

    @ColumnInfo(name = "skin")
    private String mSkin;

    @ColumnInfo(name = "etat")
    private String mEtat;

    public Knife(final String name, final String skin, final String etat) {
        mName = name;
        mSkin = skin;
        mEtat = etat;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getSkin() {
        return mSkin;
    }

    public void setSkin(String mSkin) {
        this.mSkin = mSkin;
    }

    public String getEtat() {
        return mEtat;
    }

    public void setEtat(String mEtat) {
        this.mEtat = mEtat;
    }
}
