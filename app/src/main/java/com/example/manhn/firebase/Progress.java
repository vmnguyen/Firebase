package com.example.manhn.firebase;

import java.util.HashMap;

/**
 * Created by Manh on 11/17/2017.
 */

public class Progress {

    private HashMap<String, Integer> progress_idiom = new HashMap<>();
    private HashMap<String, Integer> progress_topic = new HashMap<>();
    private HashMap<String, Integer> progress_word = new HashMap<>();


    public Progress() {

    }


    public HashMap<String, Integer> getProgress_idiom() {
        return progress_idiom;
    }

    public void setProgress_idiom(HashMap<String, Integer> progress_idiom) {
        this.progress_idiom = progress_idiom;
    }

    public HashMap<String, Integer> getProgress_topic() {
        return progress_topic;
    }

    public void setProgress_topic(HashMap<String, Integer> progress_topic) {
        this.progress_topic = progress_topic;
    }

    public HashMap<String, Integer> getProgress_word() {
        return progress_word;
    }

    public void setProgress_word(HashMap<String, Integer> progress_word) {
        this.progress_word = progress_word;
    }
}
