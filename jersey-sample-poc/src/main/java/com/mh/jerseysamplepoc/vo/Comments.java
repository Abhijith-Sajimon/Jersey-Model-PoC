package com.mh.jerseysamplepoc.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comments {

    private int id;
    private int post_id;
    private String name;
    private String email;
    private String body;

    public Comments() {
    }

    public Comments(int id, int postId, String name, String email, String body) {
        this.id = id;
        this.post_id = postId;
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

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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
