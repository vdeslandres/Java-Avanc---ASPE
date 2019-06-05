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
import javax.activation.DataSource;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
