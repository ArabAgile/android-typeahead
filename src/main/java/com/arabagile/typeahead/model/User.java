package com.arabagile.typeahead.model;

/**
 * Created by agile on 5/26/15.
 */
public class User {

    String fullname;
    String username;
    String photo;

    public User(String fullname, String username, String photo) {
        this.fullname = fullname;
        this.username = username;
        this.photo = photo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
