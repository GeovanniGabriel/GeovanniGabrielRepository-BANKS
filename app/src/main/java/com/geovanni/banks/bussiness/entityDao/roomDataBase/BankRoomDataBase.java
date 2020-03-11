package com.geovanni.banks.bussiness.entityDao.roomDataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.geovanni.banks.bussiness.entityDao.interfaces.IServiceBanksDao;
import com.geovanni.banks.bussiness.models.ServiceBanksResponse;

@Database(entities = {ServiceBanksResponse.class}, version = 1)
public abstract class BankRoomDataBase extends RoomDatabase {

    private static BankRoomDataBase INSTANCE;

    public abstract IServiceBanksDao banksDao();

    public static synchronized BankRoomDataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BankRoomDataBase.class, "bank_database").build();
        }
        return INSTANCE;
    }


    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
