package br.com.novaroma.helpet.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.novaroma.helpet.Entitys.User;
import br.com.novaroma.helpet.R;

public class Register extends Activity {

    private Intent intent;
    private EditText edtName, edtEmail, edtPassword, edtConfirmPassword;
    private Button btnNext;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        intent = new Intent(this, RegisterAddress.class);

        btnNext = findViewById(R.id.btnNext);


        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmePassword);

        user = new User(edtName.toString(), edtEmail.toString(), edtPassword.toString());
        intent.putExtra("USER", user);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }

}
