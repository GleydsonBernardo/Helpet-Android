package br.com.novaroma.helpet.presentation;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.novaroma.helpet.Entitys.Address;
import br.com.novaroma.helpet.Entitys.Adoption;
import br.com.novaroma.helpet.Entitys.Animal;
import br.com.novaroma.helpet.R;

public class AdoptionRegister extends Activity {

    private EditText edtSpecies, edtGait, edtColor, edtDescription;
    private Button btnRegister;
    private DatabaseReference ref;

    private Animal animal;
    private Adoption adoption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_register);

        ref = FirebaseDatabase.getInstance().getReference().child("Adoptions");

        edtSpecies = findViewById(R.id.edtSpecies);
        edtGait = findViewById(R.id.edtGait);
        edtColor = findViewById(R.id.edtColor);
        edtDescription = findViewById(R.id.edtDescription);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animal = new Animal(edtSpecies.getText().toString(), edtGait.getText().toString(),
                        edtColor.getText().toString());
                adoption = new Adoption(animal, edtDescription.getText().toString());
                ref.push().setValue(adoption);
//                Toast.makeText(getBaseContext(), animal.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
