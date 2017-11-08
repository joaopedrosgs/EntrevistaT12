package com.example.android.localizator.show_addresses;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.localizator.R;

import java.util.ArrayList;

import butterknife.OnClick;

public class ShowAddressesActivity extends AppCompatActivity {

    RecyclerView rvAddresses;
    View.OnClickListener clickListener;
    ArrayList<String> lstAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);

        rvAddresses = findViewById(R.id.rv_addresses);

        //captura a lista enviada pela MainActivity
        lstAddresses = getIntent().getStringArrayListExtra("addresses_list");

        // OnClick que vai ser usado no recycler view
        clickListener =  new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posicao = rvAddresses.getChildLayoutPosition(view);
                String endereco = lstAddresses.get(posicao);
                Intent abrirMapa = new Intent(Intent.ACTION_VIEW);
                abrirMapa.setData(Uri.parse("geo:0,0?q="+endereco));
                startActivity(abrirMapa);
            }
        };
        //instancia um AddressesAdapter passando a lista de endereços

        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses, clickListener);

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }
}
