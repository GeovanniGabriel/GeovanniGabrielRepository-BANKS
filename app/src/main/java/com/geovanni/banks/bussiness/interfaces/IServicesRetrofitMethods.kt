package com.geovanni.banks.bussiness.interfaces

import com.geovanni.banks.bussiness.models.ServiceBanksResponse
import com.geovanni.banks.bussiness.utils.ServicesConstants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface IServicesRetrofitMethods {
    //***************************************   getBanks *******************************
    @get:GET(ServicesConstants.URL_BANKS)
    @get:Headers("Content-Type: application/json")
    val banks: Call<List<ServiceBanksResponse?>?>?
}