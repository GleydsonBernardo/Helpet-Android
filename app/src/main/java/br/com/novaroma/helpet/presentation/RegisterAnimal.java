package br.com.novaroma.helpet.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.novaroma.helpet.R;
import br.com.novaroma.helpet.Entitys.Animal;



public class RegisterAnimal extends AppCompatActivity {

    private Animal animal;
    private EditText edtSpecies, edtGait, edtColor;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_animal);

        edtSpecies = findViewById(R.id.edtSpecies);
        edtGait = findViewById(R.id.edtGait);
        edtColor = findViewById(R.id.edtColor);

        btnRegister = findViewById(R.id.btnRegister);

        animal = new Animal(edtSpecies.getText().toString(), edtGait.getText().toString(),
                edtColor.getText().toString());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), animal.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
