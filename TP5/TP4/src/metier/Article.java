/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author p1809164
 */
public class Article {
      private int id;
    private String libelle;
    private String categorie;
    private String sous_categorie;
    private int qualite;
    private float prix;
    
    public Article (int lId, String leLibelle, String laCategorie, String laSous_Categorie, int laQualite, float lePrix)
    {
        id=lId;
        libelle=leLibelle;
        categorie=laCategorie;
        sous_categorie=laSous_Categorie;
        qualite=laQualite;
        prix=lePrix;
    }

    //Accesseurs & mutateurs
    public int getId() {
        return id;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getSous_categorie() {
        return sous_categorie;
    }
    public void setSous_categorie(String sous_categorie) {
        this.sous_categorie = sous_categorie;
    }
    public int getQualite() {
        return qualite;
    }
    public void setQualite(int qualite) {
        this.qualite = qualite;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    //Surdéfinition de toString

    @Override
    public String toString() 
    {
        return "Article{" + "id=" + id + ", libelle=" + libelle + ", categorie=" + categorie + ", sous_categorie=" + sous_categorie + ", qualite=" + qualite + ", prix=" + prix + '}';
    }
    
}
