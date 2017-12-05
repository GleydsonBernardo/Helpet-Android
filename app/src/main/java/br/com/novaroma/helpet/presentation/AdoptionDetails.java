package br.com.novaroma.helpet.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.novaroma.helpet.Entitys.Adoption;
import br.com.novaroma.helpet.R;

public class AdoptionDetails extends AppCompatActivity {
    private DatabaseReference refAdopted;
    private DatabaseReference refAdoptions;


    private Button btnAdoption;
    private TextView txtSpecie, txtGait, txtColor;

    private Adoption adoption;
    private String keyToFB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_details);

        refAdopted = FirebaseDatabase.getInstance().getReference().child("Adopteds");
        refAdoptions = FirebaseDatabase.getInstance().getReference().child("Adoptions");


        adoption = (Adoption) getIntent().getSerializableExtra("VALUE");
        keyToFB = (String) getIntent().getSerializableExtra("KEY");

        txtSpecie = findViewById(R.id.txtSpecie);
        txtGait = findViewById(R.id.txtGait);
        txtColor = findViewById(R.id.txtColor);
        btnAdoption = findViewById(R.id.btnToAopt);

        setText();

        btnAdoption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refAdopted.push().setValue(adoption);
                refAdoptions.child(keyToFB).removeValue();


                Toast.makeText(getBaseContext(), adoption.getAnimal().getSpecies() + ", adotado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setText() {
        txtSpecie.setText(adoption.getAnimal().getSpecies());
        txtColor.setText(adoption.getAnimal().getColor());
        txtGait.setText(adoption.getAnimal().getGait());
    }
}
