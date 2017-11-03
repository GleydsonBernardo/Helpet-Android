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

public class Register extends Activity {
    private Button btnNext;
    private EditText edtName, edtEmail, edtPassword, edtConfirmPassword;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnNext = (Button) findViewById(R.id.btnNext);

        edtName = (EditText) findViewById(R.id.edtName);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmePassword);

        btnNext.setOnClickListener(onClickUser());
    }

    private View.OnClickListener onClickUser() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString();
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();
                user = new User(name, email, password);

                Intent intent = new Intent(Register.this, RegisterAddress.class);

                intent.putExtra("USER", user);
                startActivity(intent);
            }
        };
    }
}