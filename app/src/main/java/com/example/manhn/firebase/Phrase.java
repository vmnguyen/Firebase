package com.example.manhn.firebase;

/**
 * Created by manhn on 12/3/2017.
 */

public class Phrase {
    private String phrase_id;
    private String phrase_content;
    private String phrase_audio_path;

    public Phrase() {

    }

    public Phrase(String phrase_id, String phrase_content, String phrase_audio_path) {
        this.phrase_id = phrase_id;
        this.phrase_content = phrase_content;

        this.phrase_audio_path = phrase_audio_path;
    }

    public String getPhrase_content() {
        return phrase_content;
    }

    public void setPhrase_content(String phrase_content) {
        this.phrase_content = phrase_content;
    }

    public String getPhrase_id() {
        return phrase_id;
    }

    public void setPhrase_id(String phrase_id) {
        this.phrase_id = phrase_id;
    }

    public String getPhrase_audio_path() {
        return phrase_audio_path;
    }

    public void setPhrase_audio_path(String phrase_audio_path) {
        this.phrase_audio_path = phrase_audio_path;
    }
}
