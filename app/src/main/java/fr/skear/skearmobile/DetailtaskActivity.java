package fr.skear.skearmobile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import fr.skear.skearmobile.model.beans.Task;

public class DetailtaskActivity extends AppCompatActivity {

    public final static String DETAIL_TASK_MEMBERS_KEY = "DETAIL_TASK_MEMBERS_KEY";
    private static final int ID_ITEM1 = 1;

    private TextView tv_title, tv_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailtask);

        tv_title = findViewById(R.id.tv_detailtasktitle);
        tv_detail = findViewById(R.id.tv_detailtaskcontent);

        // getIntent() : objet qui permet de lancer cette écran , getExtras() : paramètres transmis, serializable : mettre format json ou xml
        Task members = (Task) getIntent().getExtras().getSerializable(DETAIL_TASK_MEMBERS_KEY);

        tv_title.setText(members.getTitle());
        tv_detail.setText(members.getContent());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, ID_ITEM1, 0, "Supprimer le Post it").setIcon(R.drawable.ic_delete_white_24dp).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == ID_ITEM1) {
            Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
