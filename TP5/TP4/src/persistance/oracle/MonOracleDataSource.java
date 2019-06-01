/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistance.oracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.datasource.OracleDataSource;

/**
 *
 * @author Niakulu
 */
public class MonOracleDataSource extends OracleDataSource {

    MonOracleDataSource ods;
    private MonOracleDataSource(){
    }
    }
    public static MonOracleDataSource getOracleDataSource() throws IOException {
        if (ods == null) {
            FileInputStream fichier = null;
            Properties props = new Properties();
            fichier = new FileInputStream("src/persistance/oracle/connOracle.properties");
            3
            props.load(fichier);
            fichier.close();
            try {
                ods = new MonOracleDataSource(); // on peut instancier à vide
            } catch (SQLException ex) { // … OracleDataSource() peut lever cette exception
                System.out.println("*** Erreur de CONNEXION ORACLE ...");
            }
// on construit la source de données :
            ods.setDriverType(props.getProperty("pilote"));
            ods.setPortNumber(new Integer(props.getProperty("port")));
            ods.setServiceName(props.getProperty("service"));
            ods.setServerName(props.getProperty("Serveur"));
            ods.setUser(props.getProperty("user"));
            ods.setPassword(props.getProperty("pwd"));
        }
// sinon, une instance de source de données existe deja, on la renvoie :
        return ods;

    }
}