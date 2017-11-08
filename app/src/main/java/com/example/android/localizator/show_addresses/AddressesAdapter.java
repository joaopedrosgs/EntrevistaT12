package com.example.android.localizator.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.localizator.R;

import java.util.List;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.ViewHolder> {

    private List<String> addressesList;
    private View.OnClickListener MeuClickListener;

    //Construtor para receber a lista
    AddressesAdapter(List<String> addressesList, View.OnClickListener clickListener) {
        this.addressesList = addressesList;
        MeuClickListener = clickListener;
    }

    //Infla o layout XML
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.address_list_item, parent, false);
        return new ViewHolder(v);
    }

    //Seta os dados na lista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAddress.setText(addressesList.get(position));
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return addressesList == null ? 0 : addressesList.size();
    }

    //Mapeamento dos componentes da View
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            // Necessário para setar os clicks em cada elemento do recycler view
            itemView.setOnClickListener(MeuClickListener);
            tvAddress = itemView.findViewById(R.id.tv_address);
        }
    }
}
