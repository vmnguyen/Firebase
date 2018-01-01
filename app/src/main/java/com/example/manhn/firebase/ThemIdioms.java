package com.example.manhn.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ThemIdioms extends AppCompatActivity {
    private String TAG = "";
    List<Word> words;
    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_idioms);
    }
    public void addIdiom(){
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
