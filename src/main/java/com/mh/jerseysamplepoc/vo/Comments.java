package com.mh.jerseysamplepoc.vo;

import com.fasterxml.jackson.annotation.JsonAlias;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comments {

    private int id;
    @JsonAlias(value = "post_id")
    private int postId;
    private String name;
    private String email;
    private String body;

    public Comments() {
    }

    public Comments(int id, int postId, String name, String email, String body) {
        this.id = id;
        this.postId = postId;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
