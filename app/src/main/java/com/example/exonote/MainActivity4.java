package com.example.exonote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    TextView textView = null;
    Button retour = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        textView = (TextView) findViewById(R.id.textViewAccueil);
        retour = (Button) findViewById(R.id.btnRetour);
        String str_nom = "";
        String str_prenom = "";
        Intent intent = getIntent();
        if(intent.hasExtra("nom")){

            str_nom = intent.getStringExtra("nom");
        }
        if(intent.hasExtra("prenom")){

            str_prenom = intent.getStringExtra("prenom");
        }
        textView.setText("Bonjour "+str_nom+" "+str_prenom);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity4.this, MainActivity.class);

                startActivity(intent);

            }
        });
    }

}