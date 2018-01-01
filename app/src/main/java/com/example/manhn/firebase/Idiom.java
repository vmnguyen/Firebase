package com.example.manhn.firebase;

import java.util.HashMap;


/**
 * Created by manhn on 12/23/2017.
 */

public class Idiom {
    private String _id;
    private String word;
    private String type;
    private String detail;
    private String example;
    private int status;

    public Idiom(String _id, String _word, String _type, String detail) {
        this._id = _id;
        this.word = _word;
        this.type = _type;
        this.detail = detail;
        this.example = "";
        this.status = 0;
    }

    public Idiom(String _word, String _type, int _status) {
        this.word = _word;
        this.type = _type;
        this.status = _status;
    }

    public Idiom() {

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

}
