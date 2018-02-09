package fr.skear.skearmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.skear.skearmobile.model.beans.Member;
import fr.skear.skearmobile.view.MembersAdapter;

public class TasklistActivity extends AppCompatActivity implements MembersAdapter.OnMembersListener, View.OnClickListener {

    // Composant graphique
    private TextView tv_info;
    private RecyclerView rv;
    private Button bt_mylist;

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

        // Redirige le clic sur le bouton sur la méthode onclick
        bt_mylist.setOnClickListener(this);

        // création d'une collection
        members = new ArrayList<>();

        // création de l'adapter qui utilisera notre liste
        membersAdapter = new MembersAdapter(members, this);

        // On demande au RecyclerView d'utiliser notre adapter
        rv.setAdapter(membersAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }

    // click sur la cardview
    @Override
    public void onClick(Member members) {
        Toast.makeText(this, "vous avez cliqué sur" + members.getTitle() + " " + members.getContent(), Toast.LENGTH_SHORT).show();
    }

    // (view v) indique l'élément graphique cliqué : boutton
    @Override
    public void onClick(View v) {
        Member member = new Member();
        member.setContent("TEstD");
        member.setTitle("title");

        this.members.add(member);

        // Rafraichisement de l'écran graphique (mise à jour graphique)
        membersAdapter.notifyDataSetChanged();
    }
}
