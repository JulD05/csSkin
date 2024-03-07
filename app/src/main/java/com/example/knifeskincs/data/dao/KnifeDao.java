package com.example.knifeskincs.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.knifeskincs.data.models.Knife;

import java.util.List;

@Dao
public interface KnifeDao {
    @Insert
    void insertKnife(Knife... knifes);
    @Update
    void updateKnife(Knife knife);
    @Delete
    void deleteKnife(Knife knife);
    @Query("SELECT * FROM `knifes` WHERE `knifes`.`id` = :id")
    LiveData<Knife> getKnife(int id);
    @Query("SELECT * FROM `knifes` ORDER BY `knifes`.`name`")
    LiveData<List<Knife>> getAllKnifes();

}
