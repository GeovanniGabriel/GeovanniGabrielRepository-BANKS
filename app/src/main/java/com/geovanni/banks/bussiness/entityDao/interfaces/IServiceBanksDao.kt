package com.geovanni.banks.bussiness.entityDao.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geovanni.banks.bussiness.models.ServiceBanksResponse

@Dao
interface IServiceBanksDao {
    @get:Query("SELECT * FROM ServiceBanksResponse")
    val all: List<ServiceBanksResponse?>?

    @Insert
    fun insert(bank: ServiceBanksResponse?)
}