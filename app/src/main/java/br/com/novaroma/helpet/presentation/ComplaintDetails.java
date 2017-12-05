package br.com.novaroma.helpet.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.novaroma.helpet.Entitys.Complaint;
import br.com.novaroma.helpet.R;

public class ComplaintDetails extends AppCompatActivity {
    private DatabaseReference refResgated;
    private DatabaseReference refComplaint;


    private Button btnRegate;
    private TextView txtSpecie, txtGait, txtColor;

    private Complaint complaint;
    private String keyToFB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_details);

        refResgated = FirebaseDatabase.getInstance().getReference().child("Resgateds");
        refComplaint = FirebaseDatabase.getInstance().getReference().child("Complaints");


        complaint = (Complaint) getIntent().getSerializableExtra("VALUE");
        keyToFB = (String) getIntent().getSerializableExtra("KEY");

        txtSpecie = findViewById(R.id.txtSpecie);
        txtGait = findViewById(R.id.txtGait);
        txtColor = findViewById(R.id.txtColor);
        btnRegate = findViewById(R.id.btnRegate);

        setText();

        btnRegate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                refResgated.push().setValue(complaint);
                refComplaint.child(keyToFB).removeValue();


                Toast.makeText(getBaseContext(), complaint.getAnimal().getSpecies() + ", regatado",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setText() {
        txtSpecie.setText(complaint.getAnimal().getSpecies());
        txtColor.setText(complaint.getAnimal().getColor());
        txtGait.setText(complaint.getAnimal().getGait());
    }
}

