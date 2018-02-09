package fr.skear.skearmobile.model.webservice;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

import fr.skear.skearmobile.model.beans.Member;
import fr.skear.skearmobile.model.beans.Personne;

/**
 * Created by Distructors on 05/02/2018.
 */

public class OpenDataWS {

    private static final String WS_URL = "http://www.skear.fr/server/web/api/tasks";
    private static final String TOKEN = "Bearer eyJhbGciOiJSUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwidXNlcm5hbWUiOiJCZWx6IiwiZXhwIjoxNTE5NjcxNTYyLCJpYXQiOjE1MTc4NTcxNjJ9.JhDI1LuxzG9k-_EhCUYCrOsC1QffMjt1zQde_e8P_nxlGWGEscZge7SQU_ASpP1GcQGPUeIbvCnaIdcxIm5beoluyrPB4rifPYwV-gMlX1-1nCDyDcE43w3GdCqKEnyq4zywIR_A_ol_mOJxV6oTrA6oOAIOmA4NlNKbpePCRIHBvY5n6b7ku2u5hrjPnVL_w-HGtJ25ap1NFbEEH8awRZyD6B2I4OzdzZNAtdhfWVX_CWG2RgyjxgeALXEm4l7R0IwKOVquAJQ-QaOV0OckXwYST5llihkFmpNqj-fNa26EMP174TSqfjjHZuq0FfQho3Avc8o3lV9HoGbk4a3LTTfdEwbH6qfpk6vQkxKpMHASo0eykniARXDrcnvxpBVbffpxKQkmznQzZYaPO53SAnw-J0GqGj9hb1olSAaqapMk-TOww-yFTtYB5qDr3SftueE8BRgfXFhM3HR59iMuXWJ7BEeepEsyDx6oF1EkR93G5rRU-nTqD7S13oVAz7EUryxrj91PjlBglz6zkr3QHOnqPaE5pWf55F4HI4_TfPypAPtQhiVOlNCtBKA27schVcXoCjAzMakWdFe3Pb7dOuPfnvQwbqZNJAmRBjl8YsyUu_79q8GcMcMJMpIe-RA0V4H_HfUwZL6NGQxXI0CcDmcDbQGYiN-98FyCZbUntUw";
    private static final String JSON_RESPONSE = "{\"@member\":\"bob\",\"surname\":\"morane\", \"adress\": {\"street\":\"pouet\",\"number\":\"12\"},\"cars\":[ {\"model\":\"2CV\", \"speed\":\"21\"},{\"model\":\"Ferrari\", \"speed\":\"37.1\"},{\"model\":\"cheval\", \"speed\":\"1\"}  ]}";

    public static ArrayList<Member> getFieldsServeur() throws Exception {
        //Lancer la requête
        String reponseJson = OkHttpUtils.sendGetOkHttpRequest(WS_URL, TOKEN);
        Log.v("TAG content", reponseJson);
        Gson gson = new Gson();

        Personne personne = gson.fromJson(JSON_RESPONSE, Personne.class);

//        Resultat resultat = gson.fromJson(reponseJson, Resultat.class);

        //ArrayList<Member> members = new ArrayList<>();

        /*if (resultat == null) {
            throw new Exception("Variable resultat à null");
        } else if (personne.getMember() != null) {
            members = new ArrayList<>();
        }

        return members;*/

        return new ArrayList<Member>();
    }
}
