package com.example.manhn.firebase;

import java.util.HashMap;


/**
 * Created by manhn on 12/9/2017.
 */

public class User {
    private HashMap<String, Topic> topics = new HashMap<>();
    private HashMap<String, Word> words = new HashMap<>();
    private HashMap<String, Idiom> idioms = new HashMap<>();
    private Progress progress = new Progress();

    private String userId;
    private String userEmail;
    private String userName;
    private String expirationDay;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(String expirationDay) {
        this.expirationDay = expirationDay;
    }







    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    public HashMap<String, Word> getWords() {
        return words;
    }

    public void setWords(HashMap<String, Word> words) {
        this.words = words;
    }

    public HashMap<String, Topic> getTopics() {
        return topics;
    }

    public void setTopics(HashMap<String, Topic> topics) {
        this.topics = topics;
    }

    public HashMap<String, Idiom> getIdioms() {
        return idioms;
    }

    public void setIdioms(HashMap<String, Idiom> idioms) {
        this.idioms = idioms;
    }
}
