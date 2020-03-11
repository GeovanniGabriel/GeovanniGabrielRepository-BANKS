package com.geovanni.banks.bussiness.entityDao.roomDataBase;

import android.os.AsyncTask;

import com.geovanni.banks.bussiness.entityDao.interfaces.IServiceBanksDao;
import com.geovanni.banks.bussiness.models.ServiceBanksResponse;

import java.util.List;

public class ManagerDbAsync {

    public static class InsertDataToDbAsync extends AsyncTask<Void, Void, Void> {

        private final IServiceBanksDao banksDao;
        private final List<ServiceBanksResponse> serviceBanksResponses;

        public InsertDataToDbAsync(BankRoomDataBase db, List<ServiceBanksResponse> serviceBanksResponses) {
            this.banksDao = db.banksDao();
            this.serviceBanksResponses = serviceBanksResponses;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for (ServiceBanksResponse bank : serviceBanksResponses) {
                banksDao.insert(bank);
            }
            return null;
        }
    }

    public static class GetAllDataFromDbAsync extends AsyncTask<Void, Void, List<ServiceBanksResponse>> {
        private final IServiceBanksDao banksDao;

        public GetAllDataFromDbAsync(BankRoomDataBase db) {
            banksDao = db.banksDao();
        }

        @Override
        protected List<ServiceBanksResponse> doInBackground(Void... voids) {
            return banksDao.getAll();
        }
    }
}
