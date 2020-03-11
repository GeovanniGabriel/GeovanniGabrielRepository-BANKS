package com.geovanni.banks.bussiness.presenters

import android.content.Context
import com.geovanni.banks.bussiness.interfaces.IServiceListener
import com.geovanni.banks.bussiness.interfaces.IServicesContractView
import com.geovanni.banks.bussiness.request.ServicesImpl
import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse

class RootPresenter(private val view: IServicesContractView, context: Context) : IServiceListener {

    private val servicesImpl: ServicesImpl = ServicesImpl(this, context)

    fun requestBanks() {
        servicesImpl.askForSaveInfo()
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