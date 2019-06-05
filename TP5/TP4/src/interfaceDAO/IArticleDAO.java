/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.sql.Connection;
import java.util.List;
import javax.activation.DataSource;
import metier.Article;

/**
 *
 * @author p1809164
 */
public interface IArticleDAO {

    public List<Article> getLesArticles();

    public int setLesArticles(List<Article> lesArticles);

    public void insertArticle(Article a);

    public boolean supprArticle(int refArticle);

    public void setDataSource(DataSource ds);

    public void setConnection(Connection connexionBD);

}
