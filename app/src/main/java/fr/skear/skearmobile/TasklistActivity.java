package fr.skear.skearmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        setContentView(R.layout.activity_tasklist);

        rv = (RecyclerView) findViewById(R.id.rv_listtask);
        tv_info = (TextView) findViewById(R.id.tv_infolisttask);
        bt_mylist = (Button) findViewById(R.id.bt_chargermylisttask);

        bt_mylist.setOnClickListener(this);

        members = new ArrayList<>();

        membersAdapter = new MembersAdapter(members, this);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(membersAdapter);
    }

    @Override
    public void onClick(Member members) {

    }

    @Override
    public void onClick(View v) {
        Member member = new Member();
        member.setContent("TEstD");
        member.setTitle("title");

        this.members.add(member);
        membersAdapter.notifyDataSetChanged();
    }
}
