package fr.skear.skearmobile.model.beans.connection;

/**
 * Created by Distructors on 11/02/2018.
 */

public class Identifiant {

    private String username;
    private String password;

    public Identifiant() {
        username = "";
        password = "";
    }

    public Identifiant(String _username, String _password) {
        username = _username;
        password = _password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
