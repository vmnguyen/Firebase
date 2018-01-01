package com.example.manhn.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ThemWord extends AppCompatActivity {
    private String TAG = "";
    List <Word> words;
    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_word);
        editTextName = (EditText) findViewById(R.id.editText);
        spinnerGenre = (Spinner) findViewById(R.id.spinner);

        buttonAddArtist = (Button) findViewById(R.id.button2);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();
        list.add("Ending sounds");
        list.add("The p t k sounds");
        list.add("The s and sh sounds");
        list.add("The L and R sounds");
        list.add("The short i and long i sounds");
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list);
        spinnerGenre.setAdapter(adapter);
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWord();
                queryDB();
            }
        });
    }
    public void queryDB(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Words");
        Query query = myRef.orderByChild("status").equalTo(0);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the "issue" node with all children with id 0
                    for (DataSnapshot issue : dataSnapshot.getChildren()) {
                        // do something with the individual "issues"
                        Log.v("Word: ",issue.getValue(Word.class).getWord());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void addWord(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        String id = myRef.push().getKey();
        String name = editTextName.getText().toString();
        String type = spinnerGenre.getSelectedItem().toString();
        if (name.equals("Word"))
            return;
        Word word = new Word(id,name, type, 0);

        myRef.child("Sample").child("words").child(id).setValue(word);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot tmp: dataSnapshot.getChildren()){
                    Word value = tmp.getValue(Word.class);
                    assert value != null;
                    Log.d(TAG, "Value is: " + value.getWord());
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
