package com.example.retrofittest;

import com.google.gson.annotations.SerializedName;

public class Post {

    private Integer id;

    private int userId;

    @SerializedName("body")
    private String text;

    private String title;

    public Post( int userId, String text, String title) {
        this.userId = userId;
        this.text = text;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
}
