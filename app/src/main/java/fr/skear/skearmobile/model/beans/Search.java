package fr.skear.skearmobile.model.beans;

import java.util.List;

/**
 * Created by Distructors on 06/02/2018.
 */

public class Search {

    private String _type;
    private String template;
    private String variableRepresentation;
    private List<Mapping> mapping = null;

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