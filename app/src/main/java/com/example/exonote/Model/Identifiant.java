package com.example.exonote.Model;

public class Identifiant {
    private String pseudo;
    private String mdp;
    private String nom;
    private String prenom;

    public Identifiant(String pseudo, String mdp, String nom, String prenom) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Identifiant() {
    }

    public Identifiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
