package com.example.android.localizator.main;

import android.app.Activity;
import android.content.Intent;

import java.util.ArrayList;

/**
 * Created by pedro on 08/11/2017.
 */

public class MainActivityPresenter {
    private final int RC_ADD_ADDRESS = 123;

    private MainActiviyView view;

    public MainActivityPresenter(MainActiviyView _view) {
        view = _view;
    }

    // Abre a lista de endereços se houver endereço
    public void abrirAddresses(int size) {
        if (size <= 0) {
            view.novoToast("Não há endereços cadastrados");
        } else {
            //abre a ShowAddressActivity enviando a lista de endereços
            view.abrirShowAdresses();
        }
    }

    // Checa o ActivityResult e adiciona o endereço na lista se necessário
    public void NovoEndereco(int requestCode, int resultCode, ArrayList<String> lstAddresses, Intent data) {
        if (requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("address"));
        }
    }
}
