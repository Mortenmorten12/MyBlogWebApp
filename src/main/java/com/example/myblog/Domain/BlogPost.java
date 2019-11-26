package com.example.myblog.Domain;

public class BlogPost {

    private int id;
    private String content;

    public BlogPost(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public BlogPost() {


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


