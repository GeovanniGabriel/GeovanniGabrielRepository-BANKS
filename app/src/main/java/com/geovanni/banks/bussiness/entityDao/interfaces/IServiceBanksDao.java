package com.geovanni.banks.bussiness.entityDao.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.geovanni.banks.bussiness.models.ServiceBanksResponse;

import java.util.List;

@Dao
public interface IServiceBanksDao {
    @Query("SELECT * FROM ServiceBanksResponse")
    List<ServiceBanksResponse> getAll();

    @Insert
    void insert(ServiceBanksResponse bank);
}
