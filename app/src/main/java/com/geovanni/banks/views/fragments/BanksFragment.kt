package com.geovanni.banks.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.geovanni.banks.R
import com.geovanni.banks.views.activities.MainActivity
import com.geovanni.banks.views.adapters.BanksAdapter

class BanksFragment : Fragment() {

    private var banksAdapter: BanksAdapter? = null
    var rvListBanks: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        banksAdapter = BanksAdapter(context!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_banks, container, false)
        rvListBanks = rootView.findViewById<View>(R.id.rvListBanks) as RecyclerView
        setInfoToAdapter()
        return rootView
    }

    private fun setInfoToAdapter() {
        val mainActivity = activity as MainActivity?
        banksAdapter!!.replaceData(mainActivity!!.banksData!!.bankslist)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        rvListBanks!!.layoutManager = LinearLayoutManager(context)
        rvListBanks!!.adapter = banksAdapter
    }

}