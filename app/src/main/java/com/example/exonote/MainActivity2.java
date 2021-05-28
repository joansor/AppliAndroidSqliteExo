package com.example.exonote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exonote.Controller.IdentifiantDataHandler;
import com.example.exonote.Model.Identifiant;

public class MainActivity2 extends AppCompatActivity {

    private EditText nom = null;
    private EditText prenom = null;
    private EditText pseudo = null;
    private EditText mdp = null;
    private Button valider = null;
    private IdentifiantDataHandler db = new IdentifiantDataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nom = (EditText) findViewById(R.id.nameTextInsc);
        prenom = (EditText) findViewById(R.id.firstNameTextInsc);
        pseudo = (EditText) findViewById(R.id.pseudoTextInsc);
        mdp = (EditText) findViewById(R.id.mdpTextInsc);
        valider = (Button) findViewById(R.id.btnValiderInsc);



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom_str = nom.getText().toString();
                String prenom_str = prenom.getText().toString();
                String pseudo_str = pseudo.getText().toString();
                String mdp_str = mdp.getText().toString();

                if (!nom_str.equals("") && !prenom_str.equals("") && !pseudo_str.equals("") && !mdp_str.equals("")) {

                    Identifiant newIdentifiant = new Identifiant(pseudo_str,mdp_str,nom_str,prenom_str);
                    db.addIdentifiant(newIdentifiant);

                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);

                    startActivity(intent);


                } else {

                    Toast.makeText(getApplicationContext(), "Vous n'avez pas rempli tout les champs", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}