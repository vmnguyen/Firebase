package com.example.manhn.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ThemTopic extends AppCompatActivity {
    private EditText editTextTopicName;
    private EditText editTextConversationName;
    private EditText editTextPhrase;
    private EditText editTextAudio;
    private Button addTopic;
    private Button addConversation;
    private Button addPhrase;
    private HashMap<String, Conversation> conversationHashMap = new HashMap<>();
    private List< Phrase> phraseHashMap = new ArrayList<>();
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_topic);
        //buttonTopicName = findViewById(R.id.editText3);
        addTopic = findViewById(R.id.button10);
        addConversation = findViewById(R.id.button9);
        addPhrase = findViewById(R.id.button8);
        editTextPhrase = findViewById(R.id.editText6);
        editTextTopicName = findViewById(R.id.editText3);
        editTextConversationName = findViewById(R.id.editText5);
        editTextAudio = findViewById(R.id.editText7);
        addPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAddPhrase(view);
            }
        });
        addConversation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAddConversation(view);
            }
        });
        addTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doAddTopic(view);
            }
        });
    }

    private void doAddTopic(View view) {
        String topicName  = editTextTopicName.getText().toString();
        String idTopic = myRef.push().getKey();
        Topic tmp = new Topic(idTopic, topicName, this.conversationHashMap);
        myRef.child("Sample1").child("topics").child(idTopic).setValue(tmp);
        //this.conversationHashMap.clear();
        Toast.makeText(view.getContext(), "Thêm topic thành công", Toast.LENGTH_LONG).show();
        editTextAudio.setText("");
        editTextPhrase.setText("");
        editTextConversationName.setText("");
        editTextTopicName.setText("");
    }

    private void doAddConversation(View view) {
        String textConversation = editTextConversationName.getText().toString();
        String idConversation = myRef.push().getKey();
        Conversation tmp = new Conversation(idConversation, textConversation, this.phraseHashMap);
        conversationHashMap.put(idConversation, tmp);
        this.phraseHashMap.clear();
        Toast.makeText(view.getContext(), "Thêm hội thoại thành công", Toast.LENGTH_LONG).show();
        editTextAudio.setText("");
        editTextPhrase.setText("");
        editTextConversationName.setText("");
    }

    private void doAddPhrase(View view) {
        String textPhrase = editTextPhrase.getText().toString();
        String idPhrase = myRef.push().getKey();
        String audioPath = editTextAudio.getText().toString();
        Phrase tmp = new Phrase(idPhrase, textPhrase, audioPath);
        phraseHashMap.add(tmp);
        Toast.makeText(view.getContext(), "Thêm câu thành công", Toast.LENGTH_LONG).show();
        editTextAudio.setText("");
        editTextPhrase.setText("");
    }
}
