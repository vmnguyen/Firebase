package com.example.manhn.firebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {
    private  Button button1;
    private Button button2;
    private Button button3;
    private Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ThemWord.class);
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ThemIdioms.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, ThemTopic.class);
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });
    }
    public void test(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("Users").child("Sample3");
        //final DatabaseReference myRef2 = database.getReference("Users");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);
                assert user != null;
                //myRef2.child("Sample3").setValue(user);
                HashMap<String, Word> tmp  = user.getWords();
                HashMap<String, Idiom> tmp2  = user.getIdioms();
                for (String key: tmp.keySet()){
                    Log.v("Key: ", tmp.get(key).getWord());
                }
                for (String key: tmp2.keySet()){
                    Log.v("Key: ", tmp2.get(key).getWord());
                }

                //List<Word> tmpSound = (List<Word>) snapshot.child("words").getValue();
                //user.setWords(tmpSound);
                //refUserSample.setValue(user);
                //Log.v("Logged: ", user.getUserId());
                //refNewUser.child("User1").setValue(user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

    }
}
