package com.geovanni.banks.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geovanni.banks.R
import com.geovanni.banks.bussiness.entityDao.roomDataBase.BankRoomDataBase
import com.geovanni.banks.bussiness.entityDao.roomDataBase.ManagerDbAsync
import com.geovanni.banks.bussiness.interfaces.IServicesContractView
import com.geovanni.banks.bussiness.models.ServiceBanksResponse
import com.geovanni.banks.bussiness.presenters.RootPresenter
import com.geovanni.banks.bussiness.utils.ServicesError
import com.geovanni.banks.bussiness.utils.ServicesResponse
import java.util.concurrent.ExecutionException

class SplashScreenActivity : AppCompatActivity(), IServicesContractView {

    private val rootPresenter: RootPresenter = RootPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var banks: List<ServiceBanksResponse>

        try {
            banks =
                ManagerDbAsync.GetAllDataFromDbAsync(BankRoomDataBase.getDatabase(this)).execute()
                    .get();

            if (banks.isEmpty()) {
                rootPresenter.requestBanks()
            }

        } catch (e: InterruptedException) {
            e.printStackTrace();
        } catch (e: ExecutionException) {
            e.printStackTrace();
        }

    }

    override fun showResponse(response: ServicesResponse<*>?) {
        var banks: List<ServiceBanksResponse> = response as List<ServiceBanksResponse>
        try {
            ManagerDbAsync.InsertDataToDbAsync(BankRoomDataBase.getDatabase(this), banks).execute()
        } catch (e: Exception) {

        }

    }

    override fun showError(servicesError: ServicesError?) {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {

    }
}