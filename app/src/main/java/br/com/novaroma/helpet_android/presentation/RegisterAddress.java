package br.com.novaroma.helpet_android.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.novaroma.helpet_android.Entity.Address;
import br.com.novaroma.helpet_android.Entity.User;
import br.com.novaroma.helpet_android.R;

/**
 * Created by eduar on 03/11/2017.
 */

public class RegisterAddress extends Activity {

    private Button btnRegister;
    private EditText edtStreet, edtNeighborhood, edtCity, edtState;
    private Intent intent;
    private User user;
    private Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_address);

        intent = getIntent();

        btnRegister = (Button) findViewById(R.id.btnRegister);
        edtStreet = (EditText) findViewById(R.id.edtRua);
        edtNeighborhood = (EditText) findViewById(R.id.edtBairro);
        edtCity = (EditText) findViewById(R.id.edtCidade);
        edtState = (EditText) findViewById(R.id.edtEstado);

        btnRegister.setOnClickListener(onClickAddress());
    }

    private View.OnClickListener onClickAddress() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String street = edtStreet.getText().toString();
                String neighborhood = edtNeighborhood.getText().toString();
                String city = edtCity.getText().toString();
                String state = edtState.getText().toString();

                address = new Address(street, neighborhood, city, state);

                user = (User) intent.getSerializableExtra("USER");
                user.setAddress(address);
                Toast.makeText(RegisterAddress.this, user.toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterAddress.this, Home.class));

            }
        };
    }
}