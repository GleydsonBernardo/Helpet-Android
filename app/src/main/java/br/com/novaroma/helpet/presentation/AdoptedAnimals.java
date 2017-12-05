package br.com.novaroma.helpet.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import br.com.novaroma.helpet.Entitys.Adopted;
import br.com.novaroma.helpet.R;

public class AdoptedAnimals extends AppCompatActivity {

    private ListView lv;

    private ArrayList<Adopted> arrayList;
    private ArrayAdapter<Adopted> adapter;

    private DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopted_animals);

        ref = FirebaseDatabase.getInstance().getReference().child("Adopteds");

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<Adopted>(this, android.R.layout.simple_list_item_1,
                arrayList);

        lv = findViewById(R.id.lv_adopted_animals);
        lv.setAdapter(adapter);

        fireBaser();
    }

    private void fireBaser() {
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                arrayList.add(dataSnapshot.getValue(Adopted.class));
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
