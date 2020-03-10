package com.geovanni.banks.bussiness.interfaces

import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse

interface IServiceListener {
    fun onResponse(response: ServicesResponse<*>)
    fun onError(servicesError: ServicesError?)
}