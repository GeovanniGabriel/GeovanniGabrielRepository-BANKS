package com.geovanni.banks.bussiness.request

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

class ServicesImpl(private val iServiceListener: IServiceListener) {

    private val retrofit: Retrofit = ServicesRetrofitManager.instance!!.retrofitAPI

    private val iServicesRetrofitMethods: IServicesRetrofitMethods =
        retrofit.create(IServicesRetrofitMethods::class.java)

    fun getBanks() {
        val serviceError = ServicesError()
        iServicesRetrofitMethods.banks?.enqueue(object : Callback<List<ServiceBanksResponse?>?> {
            override fun onResponse(
                call: Call<List<ServiceBanksResponse?>?>,
                response: Response<List<ServiceBanksResponse?>?>
            ) {
                val servicesResponse = ServicesResponse<List<ServiceBanksResponse>>()
                servicesResponse.setResponse(response.body() as List<ServiceBanksResponse>)
                iServiceListener.onResponse(servicesResponse)
            }

            override fun onFailure(call: Call<List<ServiceBanksResponse?>?>, t: Throwable) {
                serviceError.message = ""
                serviceError.type = 1
                iServiceListener.onError(serviceError)
            }
        })
    }

}