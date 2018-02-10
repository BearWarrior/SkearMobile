package fr.skear.skearmobile.model.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Distructors on 06/02/2018.
 */

public class User {

    @SerializedName("@id")
    private String _id;
    @SerializedName("@type")
    private String _type;
    private String email;
    private String fullname;
    private String username;

    public User() {
        _id = "";
        _type = "";
        email = "";
        fullname = "";
        username = "";
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

}

