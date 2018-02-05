package fr.skear.skearmobile.model.beans;

/**
 * Created by Distructors on 05/02/2018.
 */

public class Hydra_member {

    private String _id;
    private String _type;
    private Integer id;
    private String title;
    private String content;
    private String pathcoverimage;
    private Boolean published;
    private String createdAt;

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

    public String getPathcoverimage() {
        return pathcoverimage;
    }

    public void setPathcoverimage(String pathcoverimage) {
        this.pathcoverimage = pathcoverimage;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
