package com.example.exonote.Controller;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.exonote.Model.Identifiant;

public class IdentifiantDataHandler extends SQLiteOpenHelper {

    public static final String DROP_DATABASE_IDENTIFIANT = "DROP TABLE IF EXISTS Identifiant;";
    public static final String CREATE_DATABASE_IDENTIFIANT = "CREATE TABLE Identifiant(nom TEXT,prenom TEXT,pseudo TEXT,mdp TEXT);";

    public static final String INSERT_DATABASE_IDENTIFIANT = "INSERT INTO Identifiant(nom,prenom,pseudo,mdp) VALUES";

    public IdentifiantDataHandler(Context context) {
        super(context, "database.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DATABASE_IDENTIFIANT);
        String insert1 = "(\"testNom\",\"testPrenom\",\"test\",\"mdp\");";
        db.execSQL(INSERT_DATABASE_IDENTIFIANT + insert1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_DATABASE_IDENTIFIANT);
        onCreate(db);
    }

    public void addIdentifiant(Identifiant identifiant) {

        System.out.println("addIdentifiantNom : " + identifiant.getNom());
        System.out.println("addIdentifiantPrénom  :" + identifiant.getPrenom());
        SQLiteDatabase db = this.getWritableDatabase();
        String insertIdentifiant = "('" + identifiant.getNom() + "','" + identifiant.getPrenom() + "','" + identifiant.getPseudo() + "','" + identifiant.getMdp() + "');";
        db.execSQL(INSERT_DATABASE_IDENTIFIANT + insertIdentifiant);

    }

    public Identifiant getIdentifiant(String pseudo, String mdp) {

        Identifiant identifiant = new Identifiant();
        String selectQuery = "SELECT * FROM Identifiant WHERE pseudo = ? AND mdp = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(pseudo), String.valueOf(mdp)});

        if (!selectQuery.isEmpty()) {

            if (cursor.moveToFirst()) {

                do {
                    identifiant.setMdp(cursor.getString(cursor.getColumnIndex("mdp")));
                    identifiant.setPseudo(cursor.getString(cursor.getColumnIndex("pseudo")));
                    identifiant.setNom(cursor.getString(cursor.getColumnIndex("nom")));
                    identifiant.setPrenom(cursor.getString(cursor.getColumnIndex("prenom")));

                } while (cursor.moveToNext());
            }
        }
        db.close();
        return identifiant;
    }
}
