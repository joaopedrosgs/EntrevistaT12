/*
NOMES                                                   RA
-------------------------------------------------------------------
João Pedro São Gregorio Silva                           726549
Marcelo Henrique Huffenbaecher Marques de Oliveira      725813
-------------------------------------------------------------------
 */

package com.example.android.localizator.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.localizator.R;
import com.example.android.localizator.add_address.AddAddressActivity;
import com.example.android.localizator.show_addresses.ShowAddressesActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainActiviyView {
    MainActivityPresenter presenter;
    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses;

    // Colocado por causa do requisito 2
    @BindView(R.id.btn_add_address)
    Button btnAddAddress;
    @BindView(R.id.btn_show_addresses)
    Button btnShowAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MainActivityPresenter(this);
        setContentView(R.layout.activity_main);

        // Colocado por causa do requisito 2
        ButterKnife.bind(this);
        lstAddresses = new ArrayList<>();
    }

    //abre a activity para adicionar endereços
    @OnClick(R.id.btn_add_address)
    public void AbrirAddAdress() {
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    //abre a activity para exibir os endereços cadastrados
    @OnClick(R.id.btn_show_addresses)
    public void AbrirShowAddresses() {
        presenter.abrirAddresses(lstAddresses.size());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Chama um metodo do presenter que adiciona o endereço na lista
        presenter.NovoEndereco(requestCode, resultCode, lstAddresses, data);

    }

    //Metodo que vai ser chamado pelo presenter para iniciar a actvity que mostra os endereços
    //Não tem logica e o presenter não sabe da existencia do contexto
    @Override
    public void abrirShowAdresses() {
        Intent abrirEnderecos = new Intent(this, ShowAddressesActivity.class);
        abrirEnderecos.putStringArrayListExtra("addresses_list", lstAddresses);
        startActivity(abrirEnderecos);

    }

    // Um metodo para mostrar toasts com mensagens, vai ser chamado pelo presenter
    // Necessário pois o presenter nao tem o contexto
    @Override
    public void novoToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

    }
}
