package com.geovanni.banks.bussiness.presenters

import android.content.Context
import com.geovanni.banks.bussiness.interfaces.IServiceListener
import com.geovanni.banks.bussiness.interfaces.IServicesContractView
import com.geovanni.banks.bussiness.request.ServicesImpl
import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse

class RootPresenter(private val view: IServicesContractView) : IServiceListener {

    private val servicesImpl: ServicesImpl = ServicesImpl(this)

    fun requestBanks() {
        servicesImpl.getBanks()
    }

    override fun onResponse(response: ServicesResponse<*>) {
        view.hideProgress()
        view.showResponse(response)
    }

    override fun onError(servicesError: ServicesError?) {
        view.hideProgress()
        view.showError(servicesError)
    }
}