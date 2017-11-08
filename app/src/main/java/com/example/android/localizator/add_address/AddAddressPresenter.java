package com.example.android.localizator.add_address;

/**
 * Created by pedro on 08/11/2017.
 */

public class AddAddressPresenter {
    AddAddressView view;

    public AddAddressPresenter(AddAddressView addAddressView) {
        view = addAddressView;
    }

    public void AddEndereco(String endereco) {

        if (endereco.isEmpty()) {
            view.novoToast("Digite um endereço");
        } else {
            //retorna o endereço para a MainActivity
            view.retorna();
        }
    }
}
