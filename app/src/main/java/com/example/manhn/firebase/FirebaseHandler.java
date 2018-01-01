package com.example.manhn.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Created by manhn on 12/1/2017.
 */

public class FirebaseHandler {
    List<Word> result = new ArrayList<Word>();

    static public void updateStatusWord(String uuid, String currentUser, final String word_id) {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = firebaseDatabase.getReference("Users").child("RealTime")
                .child(uuid)
                .child(currentUser)
                .child("words");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                 @Override
                                                 public void onDataChange(DataSnapshot dataSnapshot) {

                                                     // Result will be holded Here
                                                     for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                                                         Word tmpWord = dsp.getValue(Word.class);
                                                         //Log.v("LOGGED: ", tmpWord.get_id() );
                                                         if (Objects.equals(dsp.getValue(Word.class).get_id(), word_id)){
                                                             tmpWord.setStatus(1);
                                                             myRef.setValue(tmpWord);
                                                         }

                                                     }
                                                 }

                                                 @Override
                                                 public void onCancelled(DatabaseError databaseError) {

                                                 }
                                             });
        //DatabaseReference word = myRef.child(word_id).child(TAG_STATUS);
        //word.setValue(1);
    }

    static public int getAverageProgress(HashMap<String, Integer> input) {
        Integer result = 0;
        for (String key : input.keySet()) {
            result = result + input.get(key);
        }
        return result / input.size();
    }
}
