package fr.skear.skearmobile.model.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Distructors on 05/02/2018.
 */

public class Task implements Serializable {

    public static final String WS_URL = "http://www.skear.fr/server/web/api/tasks";

    @SerializedName("@id")
    private String _id;
    @SerializedName("@type")
    private String _type;
    private Integer id;
    private String title;
    private String content;
    private Integer priority;
    private User user;
    private String createdAt;

    public Task() {
        _id = "";
        _type = "";
        id = 0;
        title = "";
        content = "";
        priority = 0;
        user = new User();
        createdAt = "";
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}