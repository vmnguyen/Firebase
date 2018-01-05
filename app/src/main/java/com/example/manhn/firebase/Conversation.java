package com.example.manhn.firebase;

import java.util.HashMap;
import java.util.List;

/**
 * Created by manhn on 12/3/2017.
 */

public class Conversation {
    private String conversation_id;
    private String conversation_name;
    private int conversation_level;
    private List<Phrase> phrases;
    private int conversation_status;

    public Conversation(String conversation_id, String conversation_name, int conversation_level, List<Phrase> phrases, int conversation_status) {
        this.conversation_id = conversation_id;
        this.conversation_name = conversation_name;
        this.conversation_level = conversation_level;
        this.phrases = phrases;
        this.conversation_status = conversation_status;
    }

    public Conversation(String conversation_id, String conversation_name, List<Phrase> phrases) {
        this.conversation_id = conversation_id;
        this.conversation_name = conversation_name;
        this.conversation_level  = 1;
        this.conversation_status = 0;
        this.phrases = phrases;
    }
    public Conversation(){};

    public String getConversation_id() {
        return conversation_id;
    }

    public void setConversation_id(String conversation_id) {
        this.conversation_id = conversation_id;
    }

    public String getConversation_name() {
        return conversation_name;
    }

    public void setConversation_name(String conversation_name) {
        this.conversation_name = conversation_name;
    }

    public int getConversation_level() {
        return conversation_level;
    }

    public void setConversation_level(int conversation_level) {
        this.conversation_level = conversation_level;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public HashMap<String, String> convertPhraseToIdAndPhrase() {
        HashMap<String, String> temp = new HashMap<>();
        for (Phrase i : this.phrases) {

        }
        return temp;
    }

    public int getConversation_status() {
        return conversation_status;
    }

    public void setConversation_status(int conversation_status) {
        this.conversation_status = conversation_status;
    }



    public String getPhraseAudio() {
        String result = "";
        if (this.getPhrases() == null){
            return result;
        }
        for (Phrase i : this.getPhrases()) {
            result = result + i.getPhrase_audio_path() + ":";
        }
        return result;
    }

    public String getPhraseContent() {
        String result = "";
        if (this.getPhrases() == null){
            return result;
        }
        for (Phrase i : this.getPhrases()) {
            result = result + i.getPhrase_content() + ":";
        }
        return result;
    }
}
