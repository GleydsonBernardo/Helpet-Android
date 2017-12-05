package br.com.novaroma.helpet.presentation;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.novaroma.helpet.Entitys.Adoption;
import br.com.novaroma.helpet.R;

public class AdoptionHome extends Activity {
    private DatabaseReference ref;

    private FloatingActionButton fab;
    private ListView lv;
    private Intent intent;

    private ArrayList<Adoption> arrayList;
    private ArrayAdapter adapter;
    private HashMap<Adoption, String> map;

    private Adoption adoption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animais_for_adoption);

        ref = FirebaseDatabase.getInstance().getReference().child("Adoptions");

        intent = new Intent(this, AdoptionDetails.class);

        map = new HashMap<>();

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                arrayList);

        lv = findViewById(R.id.lv_animals_for_adoption);
        lv.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdoptionHome.this, AdoptionRegister.class));
            }
        });

        fireBase();
        onClickListView();
    }

    private void onClickListView() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adoption = (Adoption)lv.getItemAtPosition(i);
                intent.putExtra("VALUE", adoption);
                intent.putExtra("KEY", map.get(adoption));
                startActivity(intent);
            }
        });
    }

    private void fireBase() {

        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                adoption = dataSnapshot.getValue(Adoption.class);
                arrayList.add(adoption);
                map.put(adoption, dataSnapshot.getKey());
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                arrayList.remove(dataSnapshot.getValue(Adoption.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
    }


}
