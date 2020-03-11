package com.geovanni.banks.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.geovanni.banks.R;
import com.geovanni.banks.bussiness.models.ServiceBanksResponse;
import com.geovanni.banks.views.activities.MainActivity;
import com.geovanni.banks.views.adapters.BanksAdapter;

import java.util.List;

public class BanksFragment extends Fragment {

    private BanksAdapter banksAdapter;
    RecyclerView rvListBanks;

    public BanksFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        banksAdapter = new BanksAdapter(getContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_banks, container, false);
        rvListBanks = (RecyclerView) rootView.findViewById(R.id.rvListBanks);
        setInfoToAdapter();
        return rootView;
    }

    private void setInfoToAdapter() {
        MainActivity mainActivity = (MainActivity) getActivity();
        List<ServiceBanksResponse> serviceBanksResponses = (List<ServiceBanksResponse>) mainActivity.getBanksData().getBankslist();
        banksAdapter.replaceData(serviceBanksResponses);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        rvListBanks.setLayoutManager(new LinearLayoutManager(getContext()));
        rvListBanks.setAdapter(banksAdapter);
    }
}
