package com.geovanni.banks.bussiness.interfaces

import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse

interface IServicesContractView {
    fun showResponse(response: ServicesResponse<*>?)
    fun showError(servicesError: ServicesError?)
    fun showProgress()
    fun hideProgress()
}