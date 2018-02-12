package fr.skear.skearmobile.model.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Distructors on 05/02/2018.
 */

public class Resultat<T> implements Serializable {

    @SerializedName("@context")
    private String _context;
    @SerializedName("@id")
    private String _id;
    @SerializedName("@type")
    private String _type;
    @SerializedName("member")
    private List<T> tasks = null;
    private Integer totalItems;
    private Search search;

    public Resultat() {
        _context = "";
        _id = "";
        _type = "";
        tasks = new ArrayList<T>();
        totalItems = 0;
        search = new Search();
    }

    public String get_context() {
        return _context;
    }

    public void set_context(String _context) {
        this._context = _context;
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

    public List<T> getMember() {
        return tasks;
    }

    public void setMember(List<T> member) {
        this.tasks = member;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

}
