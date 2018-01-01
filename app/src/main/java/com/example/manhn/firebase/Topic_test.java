package com.example.manhn.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Topic_test extends AppCompatActivity {
    EditText editTextName;
    Spinner spinnerGenre;
    Button buttonAddArtist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_test);

        editTextName = findViewById(R.id.editText1);
        spinnerGenre = findViewById(R.id.spinner1);
        buttonAddArtist = findViewById(R.id.button21);
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTopic();
            }
        });
    }
    public void addTopic(){
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Topics");
        String id = myRef.push().getKey();
        String name = editTextName.getText().toString();
        EditText con_id = findViewById(R.id.converationid);
        EditText con_id2 = findViewById(R.id.imagename);
        int con_id_st = Integer.parseInt(con_id.getText().toString());
        String  con_id_st2 = con_id2.getText().toString();

        //String type = spinnerGenre.getSelectedItem().toString();
        if (name.equals("Word"))
            return;
        //Word word = new Word(id,name, type, 0);
        /*
        Topic topic = new Topic(id,name, con_id_st, con_id_st2, 0);
        myRef.child(id).setValue(topic);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot tmp: dataSnapshot.getChildren()){
                    Word value = tmp.getValue(Word.class);
                    assert value != null;
                    //Log.d(TAG, "Value is: " + value.getWord());
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        */
    }
}
