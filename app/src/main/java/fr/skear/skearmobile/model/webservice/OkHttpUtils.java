package fr.skear.skearmobile.model.webservice;

import com.google.gson.Gson;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import fr.skear.skearmobile.model.beans.connection.Identifiant;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Distructors on 05/02/2018.
 */

public class OkHttpUtils {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final MediaType FORM_ENCODED = MediaType.parse("multipart/form-data");

    /**
     * Réalise une requête GET avec l'URL transmise en paramètre et retourne le résultat
     */
    public static String sendGetOkHttpRequest(String url, String token) throws Exception {
        return sendGetOkHttpRequestParams(url, token, new ArrayList<String[]>());
    }

    public static String sendGetOkHttpRequestParams(String url, String token, List<String[]> params) throws Exception {
        OkHttpClient client = new OkHttpClient();

        if (params.size() > 0) {
            url = url + "?";
            for (int i = 0; i < params.size() - 1; i++) {
                url = url + params.get(i)[0] + "=" + params.get(i)[1] + "&";
            }
            url = url + params.get(params.size() - 1)[0] + "=" + params.get(params.size() - 1)[1];
        }

        //Création de la requête
        Request request = new Request.Builder()
                .header("Authorization", token)
                .url(url)
                .build();

        //Exécution de la requête
        Response response = client.newCall(request).execute();

        //Analyse du code retour
        if (response.code() != HttpURLConnection.HTTP_OK) {
            throw new Exception("Réponse du serveur incorrecte : " + response.code());
        } else {
            //Résultat de la requête
            return response.body().string();
        }
    }

    public static Response sendPostOkHttpRequest(String url, String content, String token) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        //Création de la requête
        Request request;
        if (token.isEmpty()) {
            // Login
            Identifiant identifiant = gson.fromJson(content, Identifiant.class);
            RequestBody formBody = new FormBody.Builder().add("_username", identifiant.getUsername()).add("_password", identifiant.getPassword()).build();
            RequestBody body = RequestBody.create(FORM_ENCODED, content);
            request = new Request.Builder()
                    .url(url)
                    .post(formBody)
                    .build();
        } else {
            // Normal request
            RequestBody body = RequestBody.create(JSON, content);
            request = new Request.Builder()
                    .header("Authorization", token)
                    .url(url)
                    .post(body)
                    .build();
        }

        //Exécution de la requête
        Response response = client.newCall(request).execute();

        return response;
    }
}
