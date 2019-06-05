package persistance.oracle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.pool.OracleDataSource;
import persistance.oracle.MonOracleDataSource;

/**
 * Classe DataSource pour une BD Oracle definie par le fichier de propriÃ©tÃ©s
 * (singleton)
 *

 */
public class MonOracleDataSource extends OracleDataSource {

    private static MonOracleDataSource ods;

    // constructeur privÃ© utilisÃ© dans getOracleDataSource()
    // OracleDataSource throws java.sql.SQLException, on doit la mentionner :
    private MonOracleDataSource() throws SQLException {
    }

    /**
     * MÃ©thode statique qui renvoie l'unique instance de MonOracleDataSource
     * construite Ã  partir du fichier de proprietes
     *
     * @return une instance de MonOracleDataSource
     */
    public static MonOracleDataSource getOracleDataSource() {

        if (ods == null) {

            FileInputStream fichier = null;
            Properties props = new Properties();

            try {
                fichier = new FileInputStream("src/persistance/oracle/connOracle.properties");

            } catch (FileNotFoundException ex1) {
                System.out.println("Fichier de proprietes Oracle non trouvÃ©");
                Logger.getLogger(MonOracleDataSource.class.getName()).log(Level.SEVERE, null, ex1);
            }
            try {
                props.load(fichier);

            } catch (IOException ex) {
                System.out.println("Erreur lors du chargement du fichier de proprietes Oracle");
                Logger.getLogger(MonOracleDataSource.class.getName()).log(Level.SEVERE, null, ex);

            } finally {
                try {
                    fichier.close();
                } catch (IOException ex) {
                    System.out.print("ProblÃ¨me d'entree/sortie" + ex.getMessage());
                }
            }
            try {
                ods = new MonOracleDataSource();
            } catch (SQLException ex) {
                System.out.println("*** erreur de CONNEXION ORACLE ...");
                Logger.getLogger(MonOracleDataSource.class.getName()).log(Level.SEVERE, null, ex);
            }

            ods.setDriverType(props.getProperty("pilote"));
            ods.setPortNumber(new Integer(props.getProperty("port")));
            ods.setServiceName(props.getProperty("service"));
            ods.setUser(props.getProperty("user"));
            ods.setPassword(props.getProperty("pwd"));
            ods.setServerName(props.getProperty("serveur"));
        }
        // sinon une instance de source de donnÃ©es existe deja, on la renvoie
        return ods;
    }
}
