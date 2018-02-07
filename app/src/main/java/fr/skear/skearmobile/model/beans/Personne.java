package fr.skear.skearmobile.model.beans;

/**
 * Created by BearWarrior on 05/02/2018.
 */

public class Personne
{
    public String member;
    public String surname;

    public Personne()
    {
        member = "";
        surname = "";
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