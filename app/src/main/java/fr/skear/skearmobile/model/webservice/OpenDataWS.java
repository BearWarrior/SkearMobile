package fr.skear.skearmobile.model.webservice;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.skear.skearmobile.model.beans.Resultat;
import fr.skear.skearmobile.model.beans.connection.Identifiant;
import fr.skear.skearmobile.model.beans.connection.Token;
import okhttp3.Response;

/**
 * Created by Distructors on 05/02/2018.
 */

public class OpenDataWS {

    private static final String URL_SIGN_IN = "http://www.skear.fr/server/web/login_check";
    private static final String WS_URL = "http://www.skear.fr/server/web/api/tasks";
    //    private static final String TOKEN = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwidXNlcm5hbWUiOiJCZWx6IiwiZXhwIjoxNTE5NjcxNTYyLCJpYXQiOjE1MTc4NTcxNjJ9.JhDI1LuxzG9k-_EhCUYCrOsC1QffMjt1zQde_e8P_nxlGWGEscZge7SQU_ASpP1GcQGPUeIbvCnaIdcxIm5beoluyrPB4rifPYwV-gMlX1-1nCDyDcE43w3GdCqKEnyq4zywIR_A_ol_mOJxV6oTrA6oOAIOmA4NlNKbpePCRIHBvY5n6b7ku2u5hrjPnVL_w-HGtJ25ap1NFbEEH8awRZyD6B2I4OzdzZNAtdhfWVX_CWG2RgyjxgeALXEm4l7R0IwKOVquAJQ-QaOV0OckXwYST5llihkFmpNqj-fNa26EMP174TSqfjjHZuq0FfQho3Avc8o3lV9HoGbk4a3LTTfdEwbH6qfpk6vQkxKpMHASo0eykniARXDrcnvxpBVbffpxKQkmznQzZYaPO53SAnw-J0GqGj9hb1olSAaqapMk-TOww-yFTtYB5qDr3SftueE8BRgfXFhM3HR59iMuXWJ7BEeepEsyDx6oF1EkR93G5rRU-nTqD7S13oVAz7EUryxrj91PjlBglz6zkr3QHOnqPaE5pWf55F4HI4_TfPypAPtQhiVOlNCtBKA27schVcXoCjAzMakWdFe3Pb7dOuPfnvQwbqZNJAmRBjl8YsyUu_79q8GcMcMJMpIe-RA0V4H_HfUwZL6NGQxXI0CcDmcDbQGYiN-98FyCZbUntUw";
    private String token;
    /**
     * Instance unique pré-initialisée
     */
    private static OpenDataWS INSTANCE = null;

    private OpenDataWS() {

    }

    /**
     * Point d'accès pour l'instance unique du singleton
     */
    public static OpenDataWS getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OpenDataWS();
        }
        return INSTANCE;
    }

    public <T> ArrayList<T> getFieldsServeur(String url) throws Exception {
        //Lancer la requête
        String reponseJson = OkHttpUtils.sendGetOkHttpRequest(url, token);

        Gson gson = new Gson();
        Resultat resultat = gson.fromJson(reponseJson, Resultat.class);

        ArrayList<T> members = new ArrayList<T>();

        if (resultat == null) {
            throw new Exception("Variable resultat à null");
        } else if (!resultat.getMember().isEmpty()) {
            List<T> list = resultat.getMember();
            for (T member : list) {
                members.add(member);
            }
        }

        return members;
    }

    public Boolean signInServer(Identifiant identifiant) throws Exception {

        Gson gson = new Gson();
        String content = gson.toJson(identifiant);

        Response reponseJson = OkHttpUtils.sendPostOkHttpRequest(URL_SIGN_IN, content, "");

        if (reponseJson == null) {
            throw new Exception("Variable reponseJson à null");
        } else if (reponseJson.code() == HttpURLConnection.HTTP_UNAUTHORIZED) {
            return false;
        } else if (reponseJson.code() == HttpURLConnection.HTTP_OK) {
            Token responseToken = gson.fromJson(reponseJson.body().string(), Token.class);
            token = "Bearer " + responseToken.getToken();
            return true;
        } else {
            throw new Exception("serveur réponse : " + reponseJson.code());
        }
    }
}
