package com.example.manhn.firebase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manhn on 12/9/2017.
 */

public class User {
    private List<Topic> topics = new ArrayList<>();
    private List<Word> words = new ArrayList<>();
    private List<Idiom> idioms = new ArrayList<>();
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

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> _topics) {
        this.topics = _topics;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> _words) {
        this.words = _words;
    }

    public List<Idiom> getIdioms() {
        return idioms;
    }

    public void setIdioms(List<Idiom> idioms) {
        this.idioms = idioms;
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
}
