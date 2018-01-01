package com.example.manhn.firebase;

import java.util.List;

/**
 * Created by manhn on 12/3/2017.
 */

public class Topic {
    private String topic_id;
    private String topic_name;
    private List<Conversation> conversations;


    public Topic(String topic_id, String topic_name, List<Conversation> conversations) {
        this.topic_id = topic_id;
        this.topic_name = topic_name;
        this.conversations = conversations;
    }

    public Topic() {

    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    public List<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(List<Conversation> conversations) {
        this.conversations = conversations;
    }
}
