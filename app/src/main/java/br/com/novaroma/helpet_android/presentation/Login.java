package br.com.novaroma.helpet_android.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.novaroma.helpet_android.R;

public class Login extends Activity {

    private EditText edtLogin, edtPassword;
    private Button btnLogin;
    private TextView txtCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setValue();
        setOnClick();
    }

    private void setValue(){
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtCadastro = (TextView) findViewById(R.id.txtCadastro);
    }

    private void setOnClick(){
        btnLogin.setOnClickListener(onClick(Home.class));
        txtCadastro.setOnClickListener(onClick(Register.class));
        edtLogin.setOnClickListener(onClickFocus(edtPassword));
//        edtPassword.setOnClickListener(onClick(Register.class));
    }

    private View.OnClickListener onClickFocus(final EditText edtPassword) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPassword.requestFocus();
            }
        };
    }

    private View.OnClickListener onClick(final Class currentClass) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, currentClass));
            }
        };
    }
}
