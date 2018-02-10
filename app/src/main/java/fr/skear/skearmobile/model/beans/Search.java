package fr.skear.skearmobile.model.beans;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Distructors on 06/02/2018.
 */

public class Search {

    @SerializedName("@type")
    private String _type;
    private String template;
    private String variableRepresentation;
    private List<Mapping> mapping = null;

    public Search() {
        _type = "";
        template = "";
        variableRepresentation = "";
        mapping = new ArrayList<Mapping>();
    }

    public String get_type() {
        return _type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getVariableRepresentation() {
        return variableRepresentation;
    }

    public void setVariableRepresentation(String variableRepresentation) {
        this.variableRepresentation = variableRepresentation;
    }

    public List<Mapping> getMapping() {
        return mapping;
    }

    public void setMapping(List<Mapping> mapping) {
        this.mapping = mapping;
    }

}