package com.geovanni.banks.bussiness.entityDao.roomDataBase

import android.os.AsyncTask
import com.geovanni.banks.bussiness.entityDao.interfaces.IServiceBanksDao
import com.geovanni.banks.bussiness.models.ServiceBanksResponse

class ManagerDbAsync {
    class InsertDataToDbAsync(db: BankRoomDataBase, serviceBanksResponses: List<ServiceBanksResponse>) : AsyncTask<Void?, Void?, Void?>() {

        private val banksDao: IServiceBanksDao = db.banksDao()
        private val serviceBanksResponses: List<ServiceBanksResponse> = serviceBanksResponses

        override fun doInBackground(vararg params: Void?): Void? {
            for (bank in serviceBanksResponses) {
                banksDao.insert(bank)
            }
            return null
        }

    }

    class GetAllDataFromDbAsync(db: BankRoomDataBase) : AsyncTask<Void?, Void?, List<ServiceBanksResponse?>?>() {

        private val banksDao: IServiceBanksDao = db.banksDao()

        override fun doInBackground(vararg params: Void?): List<ServiceBanksResponse?>? {
            return banksDao.all
        }

    }
}