/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import interfaceDAO.IArticleDAO;
import java.awt.List;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author p1809164
 */
public class ArticleDAO implements IArticleDAO{
    private static DataSource ds;
    private static Connection connexionBD;
    private final ArrayList LesArticles = new ArrayList(); 

    public ArticleDAO() {
    }

    @Override
    public java.util.List<Article> getLesArticles() {
         try {
             st=connexionBD.createStatement();
             rst=st.executeQuery("Select * from produits");
             while(rst.next())
             {
                 int id=rst.getInt("ID_PRODUIT");
                 String libelle=rst.getString("LIBELLE");
                 String categorie =rst.getString("CATEGORIE");
                 String sous_categorie=rst.getString("SOUS_CATEGORIE");
                 int quantite=rst.getInt("QUANTITE");
                 float prix=rst.getInt("PRIX");
                 Article article= new Article(id,libelle,categorie,sous_categorie,quantite,prix);
                 lesArticles.add(article);
             }

         } catch (SQLException ex) 
         {
             Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         if(connexionBD!=null)try {
             connexionBD.close();
         } catch (SQLException ex) {
             Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return LesArticles; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int setLesArticles(java.util.List<Article> lesArticles) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertArticle(Article a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprArticle(int refArticle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setDataSource(DataSource ds) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setConnection(Connection connexionBD) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
