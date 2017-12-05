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

import br.com.novaroma.helpet.Entitys.Resgated;
import br.com.novaroma.helpet.R;

public class ResgatedAnimal extends AppCompatActivity {
    private DatabaseReference ref;

    private ListView lv;

    private ArrayList<Resgated> arrayList;
    private ArrayAdapter<Resgated> adapter;
    private Resgated resgated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgated_animal);

        ref = FirebaseDatabase.getInstance().getReference().child("Resgateds");

        arrayList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1,
                arrayList);

        lv = findViewById(R.id.lv_resgatedAnimals);
        lv.setAdapter(adapter);

        fireBase();
    }

    private void fireBase() {
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                resgated = dataSnapshot.getValue(Resgated.class);
                arrayList.add(resgated);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
