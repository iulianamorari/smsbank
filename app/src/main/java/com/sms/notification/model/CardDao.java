package com.sms.notification.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by ruslan on 11/7/17.
 */
@Dao
public interface CardDao {
    @Query("SELECT * FROM cards")
    LiveData<List<Card>> getAll();


    @Query("SELECT * FROM cards WHERE  code = :code")
    Card find(String code);

    @Insert
    void insert(Card... cards);

    @Delete
    void delete(Card card);

    @Update
    void update(Card card);

}
