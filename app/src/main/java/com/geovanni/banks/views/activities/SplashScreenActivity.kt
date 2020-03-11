package com.geovanni.banks.views.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.geovanni.banks.R
import com.geovanni.banks.bussiness.interfaces.IServicesContractView
import com.geovanni.banks.bussiness.models.BanksSerializable
import com.geovanni.banks.bussiness.models.ServiceBanksResponse
import com.geovanni.banks.bussiness.presenters.RootPresenter
import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse

class SplashScreenActivity : AppCompatActivity(), IServicesContractView {

    private val rootPresenter: RootPresenter = RootPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        rootPresenter.requestBanks()
    }

    override fun showResponse(response: ServicesResponse<*>?) {
        var banks: List<ServiceBanksResponse> = response?.getResponse() as List<ServiceBanksResponse>
        navigateToHome(banks)
    }

    override fun showError(servicesError: ServicesError?) {
        Toast.makeText(this, servicesError?.message, Toast.LENGTH_LONG).show()
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    private fun navigateToHome(banks: List<ServiceBanksResponse>) {

        val banksSerializable = BanksSerializable()
        banksSerializable.bankslist = banks

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("listBanks", banksSerializable)
        startActivity(intent)
        finish()

    }
}