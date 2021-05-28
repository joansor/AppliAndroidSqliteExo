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

public class MainActivity3 extends AppCompatActivity {

    private EditText pseudo = null;
    private EditText mdp = null;
    private String nom_str = null;
    private String prenom_str = null;
    private Button valider = null;
    private IdentifiantDataHandler db = new IdentifiantDataHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        pseudo = (EditText) findViewById(R.id.pseudoTextConn);
        mdp = (EditText) findViewById(R.id.mdpTextConn);
        valider = (Button) findViewById(R.id.btnValiderConn);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!pseudo.equals("") && !mdp.equals("")){

                    String pseudo_str = pseudo.getText().toString();
                    String mdp_str = mdp.getText().toString();
                    Identifiant result = db.getIdentifiant(pseudo_str, mdp_str);
                    System.out.println(result);
                    nom_str = result.getNom();
                    System.out.println(nom_str);
                    prenom_str = result.getPrenom();
                    System.out.println(prenom_str);
                   if(nom_str != null && prenom_str != null){


                       Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                       intent.putExtra("nom", nom_str);
                       intent.putExtra("prenom", prenom_str);

                       startActivity(intent);

                   }else{

                       Toast.makeText(getApplicationContext(), "Vous n'exitez pas chez nous!", Toast.LENGTH_LONG).show();
                   }

                }else{

                    Toast.makeText(getApplicationContext(), "Vous n'avez pas rempli tout les champs", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}