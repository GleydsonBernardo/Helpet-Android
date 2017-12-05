package br.com.novaroma.helpet.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.novaroma.helpet.Entitys.Address;
import br.com.novaroma.helpet.Entitys.Animal;
import br.com.novaroma.helpet.Entitys.Complaint;
import br.com.novaroma.helpet.R;

public class ComplaintRegister extends AppCompatActivity {

    private EditText edtSpecies, edtGait, edtColor, edtDescription;
    private EditText edtSteet, edtNeighborhood, edtCity, edtState;

    private Button btnNext, btnRegister;

    private Animal animal;
    private Complaint complaint;
    private Address address;
    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complatit_register);
        complaint = new Complaint();
        ref = FirebaseDatabase.getInstance().getReference().child("Complaints");

        firstLayout();

    }

    private void secondLayout() {
        edtSteet = findViewById(R.id.edtStreet);
        edtNeighborhood = findViewById(R.id.edtNeighborhood);
        edtCity = findViewById(R.id.edtCity);
        edtState = findViewById(R.id.edtState);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = new Address(edtSteet.getText().toString(),
                        edtNeighborhood.getText().toString(), edtCity.getText().toString(),
                        edtState.getText().toString());

                complaint.setAddress(address);

                ref.push().setValue(complaint);

                Toast.makeText(getBaseContext(), "Denuncia cadastrada", Toast.LENGTH_LONG).show();


            }
        });

    }

    private void firstLayout() {
        edtSpecies = findViewById(R.id.edtSpecies);
        edtGait = findViewById(R.id.edtGait);
        edtColor = findViewById(R.id.edtColor);
        edtDescription = findViewById(R.id.edtDescription);

        btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animal = new Animal(edtSpecies.getText().toString(), edtGait.getText().toString(),
                        edtColor.getText().toString());

                complaint.setAnimal(animal);
                complaint.setDescription(edtDescription.getText().toString());

                setContentView(R.layout.layut_complaint_register_address);

                secondLayout();
            }
        });
    }


}
