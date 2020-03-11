package com.geovanni.banks.views.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.geovanni.banks.R;
import com.geovanni.banks.bussiness.models.BanksSerializable;
import com.geovanni.banks.views.fragments.BanksFragment;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    BanksSerializable banksSerializable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            banksSerializable = (BanksSerializable) getIntent().getSerializableExtra("listBanks");
        }
        setContentView(R.layout.activity_main);
    }

    public BanksSerializable getBanksData() {
        return banksSerializable;
    }
}
