package fr.skear.skearmobile;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.skear.skearmobile.model.beans.Member;
import fr.skear.skearmobile.model.webservice.OpenDataWS;
import fr.skear.skearmobile.view.MembersAdapter;

public class TasklistActivity extends AppCompatActivity implements MembersAdapter.OnMembersListener, View.OnClickListener {

    // Composant graphique
    private TextView tv_info;
    private RecyclerView rv;
    private Button bt_mylist, bt_skearlist;

    private static final int ID_ITEM1 = 1;

    // Données
    private ArrayList<Member> members;

    // Outils
    private MembersAdapter membersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // fichier XML interface graphique à chagrger
        setContentView(R.layout.activity_tasklist);

        // Récupère les éléments graphique
        rv = (RecyclerView) findViewById(R.id.rv_listtask);
        tv_info = (TextView) findViewById(R.id.tv_infolisttask);
        bt_mylist = (Button) findViewById(R.id.bt_chargermylisttask);
        bt_skearlist = findViewById(R.id.bt_chargeskearlisttask);

        // Redirige le clic sur le bouton sur la méthode onclick
        bt_mylist.setOnClickListener(this);
        bt_skearlist.setOnClickListener(this);

        // création d'une collection
        members = new ArrayList<>();

        // création de l'adapter qui utilisera notre liste
        membersAdapter = new MembersAdapter(members, this);

        // On demande au RecyclerView d'utiliser notre adapter
        rv.setAdapter(membersAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, ID_ITEM1, 0, "Créer un Post it").setIcon(R.drawable.ic_create_white_24dp).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == ID_ITEM1) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    // click sur la cardview
    @Override
    public void onClick(Member members) {
        Intent intent = new Intent(this, DetailtaskActivity.class);
        // putExtra : envoie des données sur la page avec une clé
        intent.putExtra(DetailtaskActivity.DETAIL_TASK_MEMBERS_KEY, members);

        startActivity(intent);
    }

    // (view v) indique l'élément graphique cliqué : boutton
    @Override
    public void onClick(View v) {

        if (v == bt_mylist) {
            // Alerte message
            Toast.makeText(this, "Récupération de mes notes à partir du serveur en cours", Toast.LENGTH_SHORT).show();

            // Try AsyncTask we assigned
            try {
                AT_GET at_get = new AT_GET();
                at_get.execute();
            } catch (Exception e) {
                e.printStackTrace();
                tv_info.setText(e.getMessage());
            }
        } else if (v == bt_skearlist) {
            Toast.makeText(this, "Récupération des notes skear à partir du serveur en cours", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * this is the second Thread (il est interdit de lancer des thread différent de la gestion de l'interface graphique dans le thread principal)
     */
    public class AT_GET extends AsyncTask {

        private ArrayList<Member> resultat = null;
        private Exception exception = null;

        /**
         * Thread execute in background
         */
        @Override
        protected Object doInBackground(Object[] objects) {

            try {
                resultat = OpenDataWS.getInstance().getFieldsServeur();
            } catch (Exception e) {
                exception = e;
            }

            return null;
        }

        /**
         * Thread détectant que doInBackground à terminé la requète. Il est désormais possible de manier le Thread Principal
         */
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            if (exception != null) {
                exception.printStackTrace();
                tv_info.setText("Une erreur s'est produite : " + exception.getMessage());
                tv_info.setTextColor(Color.RED);
            } else {
                members.clear();
                members.addAll(resultat);
                membersAdapter.notifyDataSetChanged();
                tv_info.setText("Chargement réussi");
                tv_info.setTextColor(Color.GREEN);
            }
        }
    }
}
