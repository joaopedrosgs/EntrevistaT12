package com.example.android.localizator.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.example.android.localizator.R;

import butterknife.ButterKnife;

public class AddAddressActivity extends AppCompatActivity implements AddAddressView {
    // Colocado por causa do requisito 2
    @BindView(R.id.edt_address)
    TextView edtAddress;
    @BindView(R.id.btn_add)
    Button btnAdd;
    AddAddressPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        // Colocado por causa do requisito 2
        ButterKnife.bind(this);
        presenter = new AddAddressPresenter(this);

    }

    //chama o metodo que adiciona o endereço do presenter
    @OnClick(R.id.btn_add)
    public void AddEnd() {
        presenter.AddEndereco(edtAddress.getText().toString());
    }

    // metodo que vai ser chamado pelo presenter para retornar o endereço (caso o campo não esteja vazio)
    // Necessário porque o presenter não pode iniciar intents
    public void retorna() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("address", edtAddress.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
    // Chamado pelo presenter
    // Necessario porque o presenter não sabe do contexto
    public void novoToast(String s) {
        Toast.makeText(AddAddressActivity.this, s, Toast.LENGTH_SHORT).show();

    }

}
