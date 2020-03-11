package com.geovanni.banks.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geovanni.banks.R;
import com.geovanni.banks.bussiness.models.ServiceBanksResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BanksAdapter extends RecyclerView.Adapter<BanksAdapter.ViewHolder> {

    private List<ServiceBanksResponse> listBanks;
    private Context context;

    public BanksAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ServiceBanksResponse bank = listBanks.get(position);
        holder.txvName.setText(bank.getBankName());
        holder.txvDescription.setText(bank.getDescription());
        holder.txvAge.setText(bank.getAge());

        Picasso.get()
                .load(bank.getUrl())
                .error(R.drawable.ic_banks_splash)
                .placeholder(R.drawable.ic_banks_splash)
                .fit().centerCrop()
                .into(holder.imvBank);

    }

    @Override
    public int getItemCount() {
        return listBanks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imvBank;
        private TextView txvName, txvDescription, txvAge;

        public ViewHolder(View itemView) {
            super(itemView);

            imvBank = (ImageView) itemView.findViewById(R.id.imvBank);
            txvName = (TextView) itemView.findViewById(R.id.txvName);
            txvDescription = (TextView) itemView.findViewById(R.id.txvDescription);
            txvAge = (TextView) itemView.findViewById(R.id.txvAge);

        }
    }

    public void replaceData(List<ServiceBanksResponse> listBanks) {
        if (listBanks != null) {
            this.listBanks = listBanks;
        }
        notifyDataSetChanged();
    }
}
