package com.example.retrofittest;

import com.google.gson.annotations.SerializedName;

public class Comment {
    private int id;
    private int postId;

    @SerializedName("body")
    private String text;

    private String email;

    private String name;

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public String getText() {
        return text;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
