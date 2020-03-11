package com.geovanni.banks.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geovanni.banks.R
import com.geovanni.banks.bussiness.models.BanksSerializable

class MainActivity : AppCompatActivity() {
    var banksData: BanksSerializable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        if (extras != null) {
            banksData = intent.getSerializableExtra("listBanks") as BanksSerializable
        }
        setContentView(R.layout.activity_main)
    }

}