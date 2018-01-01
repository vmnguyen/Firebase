package com.example.manhn.firebase;

import java.util.HashMap;


/**
 * Created by Manh on 11/20/2017.
 */

public class Word {
    private String _id;
    private String word;
    private String type;
    private int status;

    public Word(String _id, String _word, String _type, int _status) {
        this._id = _id;
        this.word = _word;
        this.type = _type;
        this.status = _status;
    }

    public Word(String _word, String _type, int _status) {
        this.word = _word;
        this.type = _type;
        this.status = _status;
    }

    public Word() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
