package com.geovanni.banks.bussiness.request

import android.content.Context
import com.geovanni.banks.bussiness.entityDao.roomDataBase.BankRoomDataBase
import com.geovanni.banks.bussiness.entityDao.roomDataBase.ManagerDbAsync
import com.geovanni.banks.bussiness.interfaces.IServiceListener
import com.geovanni.banks.bussiness.interfaces.IServicesRetrofitMethods
import com.geovanni.banks.bussiness.models.ServiceBanksResponse
import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse
import com.geovanni.banks.bussiness.utils.ServicesRetrofitManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.concurrent.ExecutionException

class ServicesImpl(private val iServiceListener: IServiceListener, context: Context) {

    private val retrofit: Retrofit = ServicesRetrofitManager.instance!!.retrofitAPI
    private val context: Context = context

    private val iServicesRetrofitMethods: IServicesRetrofitMethods = retrofit.create(IServicesRetrofitMethods::class.java)

    fun askForSaveInfo() {
        val serviceError = ServicesError()
        try {

            var banks: List<ServiceBanksResponse> = ManagerDbAsync.GetAllDataFromDbAsync(BankRoomDataBase.getDatabase(context)).execute().get() as List<ServiceBanksResponse>;

            if (banks.isEmpty()) {
                getInfoFromService()
            } else {
                returnInfoFromDB(banks)
            }

        } catch (e: InterruptedException) {
            serviceError.message = ""
            serviceError.type = 1
            iServiceListener.onError(serviceError)
        } catch (e: ExecutionException) {
            serviceError.message = ""
            serviceError.type = 1
            iServiceListener.onError(serviceError)
        }
    }

    private fun returnInfoFromDB(banks: List<ServiceBanksResponse>) {
        val servicesResponse = ServicesResponse<List<ServiceBanksResponse>>()
        servicesResponse.setResponse(banks)
        iServiceListener.onResponse(servicesResponse)
    }

    private fun getInfoFromService() {
        val serviceError = ServicesError()
        iServicesRetrofitMethods.banks?.enqueue(object : Callback<List<ServiceBanksResponse?>?> {
            override fun onResponse(call: Call<List<ServiceBanksResponse?>?>, response: Response<List<ServiceBanksResponse?>?>) {
                val servicesResponse = ServicesResponse<List<ServiceBanksResponse>>()
                servicesResponse.setResponse(response.body() as List<ServiceBanksResponse>)
                saveInfoIntoDB(response.body() as List<ServiceBanksResponse>)
                iServiceListener.onResponse(servicesResponse)
            }

            override fun onFailure(call: Call<List<ServiceBanksResponse?>?>, t: Throwable) {
                serviceError.message = ""
                serviceError.type = 1
                iServiceListener.onError(serviceError)
            }
        })
    }

    fun saveInfoIntoDB(banks: List<ServiceBanksResponse>) {
        try {
            ManagerDbAsync.InsertDataToDbAsync(BankRoomDataBase.getDatabase(context), banks).execute()
        } catch (e: Exception) {
        }
    }


}