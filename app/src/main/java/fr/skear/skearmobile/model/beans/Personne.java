package fr.skear.skearmobile.model.beans;

import java.util.List;

import java.util.ArrayList;

/**
 * Created by BearWarrior on 05/02/2018.
 */

public class Personne
{
    public String member;
    public String surname;
    public Adresse adress;
    public List<Car> cars;

    public Personne()
    {
        member = "";
        surname = "";
        adress = new Adresse();
        cars = new ArrayList<Car>();
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}