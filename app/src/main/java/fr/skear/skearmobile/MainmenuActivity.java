package fr.skear.skearmobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainmenuActivity extends AppCompatActivity implements View.OnClickListener {

    // Composant graphique
    private CardView cv_menunote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        // Récupère les éléments graphique
        cv_menunote = findViewById(R.id.cv_menunote);

        // Contexte du click (Redirige le clic sur le bouton sur la méthode OnClick)
        cv_menunote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cv_menunote: {
                // Change Screen
                Toast.makeText(this, "Accès Post it", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, TasklistActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
