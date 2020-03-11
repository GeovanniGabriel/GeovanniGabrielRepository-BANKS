package com.geovanni.banks.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geovanni.banks.R
import com.geovanni.banks.bussiness.models.ServiceBanksResponse
import com.squareup.picasso.Picasso

class BanksAdapter(private val context: Context) : RecyclerView.Adapter<BanksAdapter.ViewHolder>() {

    private var listBanks: List<ServiceBanksResponse>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bank = listBanks!![position]
        holder.txvName.text = bank.bankName
        holder.txvDescription.text = bank.description
        holder.txvAge.text = bank.age
        Picasso.get()
            .load(bank.url)
            .error(R.drawable.ic_banks_splash)
            .placeholder(R.drawable.ic_banks_splash)
            .fit().centerCrop()
            .into(holder.imvBank)
    }

    override fun getItemCount(): Int {
        return listBanks!!.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imvBank: ImageView = itemView.findViewById<View>(R.id.imvBank) as ImageView
        val txvName: TextView = itemView.findViewById<View>(R.id.txvName) as TextView
        val txvDescription: TextView = itemView.findViewById<View>(R.id.txvDescription) as TextView
        val txvAge: TextView = itemView.findViewById<View>(R.id.txvAge) as TextView
    }

    fun replaceData(listBanks: List<ServiceBanksResponse>?) {
        if (listBanks != null) {
            this.listBanks = listBanks
        }
        notifyDataSetChanged()
    }

}