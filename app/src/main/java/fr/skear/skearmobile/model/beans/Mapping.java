package fr.skear.skearmobile.model.beans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Distructors on 06/02/2018.
 */

public class Mapping implements Serializable {

    @SerializedName("@type")
    private String _type;
    private String variable;
    private String property;
    private Boolean required;

    public Mapping() {
        _type = "";
        variable = "";
        property = "";
        required = false;
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

}