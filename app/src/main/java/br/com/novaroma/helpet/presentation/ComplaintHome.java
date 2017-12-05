package br.com.novaroma.helpet.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.novaroma.helpet.Entitys.Address;
import br.com.novaroma.helpet.Entitys.Animal;
import br.com.novaroma.helpet.Entitys.Complaint;
import br.com.novaroma.helpet.R;

public class ComplaintHome extends AppCompatActivity {

    private DatabaseReference ref;

    private ListView lv;
    private FloatingActionButton fab;
    private Intent intent;

    private ArrayList<Complaint> arrayList;
    private ArrayAdapter<Complaint> adapter;
    private HashMap<Complaint, String > map;

    private Complaint complaint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        ref = FirebaseDatabase.getInstance().getReference().child("Complaints");

        intent = new Intent(ComplaintHome.this, ComplaintDetails.class);

        map = new HashMap<>();
        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                arrayList);

        lv = findViewById(R.id.lv_complaint);
        lv.setAdapter(adapter);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ComplaintHome.this, ComplaintRegister.class));
            }
        });

        fireBase();
        onClickListView();

    }

    private void onClickListView() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                complaint = (Complaint) lv.getItemAtPosition(i);
                intent.putExtra("VALUE", complaint);
                intent.putExtra("KEY", map.get(complaint));

                startActivity(intent);
            }
        });
    }

    private void fireBase() {

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                complaint = dataSnapshot.getValue(Complaint.class);
                arrayList.add(complaint);
                map.put(complaint, dataSnapshot.getKey());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }


}
