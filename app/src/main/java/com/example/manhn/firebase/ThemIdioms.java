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
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ThemIdioms extends AppCompatActivity {
    private String TAG = "";
    List<Word> words;
    EditText editTextidioms;
    EditText editTextType;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_idioms);
        editTextidioms = findViewById(R.id.editText2);
        editTextType = findViewById(R.id.editText4);
        buttonAddArtist = findViewById(R.id.button7);
        spinnerGenre= findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter;
        List<String> list;

        list = new ArrayList<String>();
        list.add("Love idioms");
        list.add("Animal idioms");
        list.add("Life idioms");
        list.add("Money idioms");
        list.add("Time idioms");
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, list);
        spinnerGenre.setAdapter(adapter);
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addIdiom();
            }
        });
    }
    public void addIdiom(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");
        String id = myRef.push().getKey();
        String idiom = editTextidioms.getText().toString();
        String detail = editTextType.getText().toString();
        String type = spinnerGenre.getSelectedItem().toString();
        Idiom idiom1 = new Idiom(id, idiom, type, detail);
        //Word word = new Word(id,name, type, 0);

        myRef.child("Sample1").child("User1").child("idioms").child(id).setValue(idiom1);
        myRef.child("Sample").child("idioms").child(id).setValue(idiom1);
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
