/*
 * TP1 ASPE 2019
 * version3 avec icône, groupe de boutons pour l'annee
 * meilleure disposition
 */
package tp1.fenetu;

/**
 * @author vde
 */

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FenEtu extends JFrame {
    // declaration des composants
    private JLabel lbl_etatCivil, lbl_nom, lbl_prenom, lbl_annee;
    private JLabel lbl_loisirs, lbl_commentaire;
    
    // question facultative 4
    private JLabel lbl_image; // pour l'image F/G
    
    private JComboBox cbb_etatCivil;
    private JTextField tf_nom, tf_prenom;
    private JRadioButton rb_1A, rb_2A;
    private ButtonGroup groupAnnee ;
    private JCheckBox ckb_cinema, ckb_sport, ckb_lecture;
    private JTextArea ta_commentaire;
    private JButton bt_ajouter, bt_modifier, bt_suppr;
    
    // declaration des panneaux necessaires
    private JPanel pannECivil, pannNomAnLoisirs, pannComm, pannBoutons;
    // question facultative 5 (sinon tous les declarer)
    JPanel pann21, pann22, pann23;
    
    
    // constructeurs
    public FenEtu(String title) {
        super(title);
        initComponents();
    }

    // question facultative 2
    public FenEtu() {
        initComponents();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader rep = new BufferedReader(isr);
        System.out.print("Saisir le titre désiré pour la fenêtre de saisie etudiant : ");
        String leTitre = "Saisie Etudiant";
        try {
            leTitre = rep.readLine();
        } catch (IOException ex) {
            Logger.getLogger(FenEtu.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(leTitre);
    }
    
    // initialisation des composants
    private void initComponents() {
        
        // definition des composants
        lbl_etatCivil = new JLabel("Etat civil:");
        lbl_nom = new JLabel("Nom:");
        lbl_prenom = new JLabel("Prénom:");
        
        // label image
        lbl_image = new JLabel(new ImageIcon("src/gif/homme.png"));
        
        lbl_annee = new JLabel("Année:");
        lbl_loisirs = new JLabel("Loisirs:");
        lbl_commentaire = new JLabel("Commentaire:");
        // définit une textarea de 5 lignes et 15 caract. de large
        ta_commentaire = new JTextArea(5,15);
        
        cbb_etatCivil = new JComboBox();
        cbb_etatCivil.addItem("M.");
        cbb_etatCivil.addItem("Mme");
        
        tf_nom = new JTextField(12);
        tf_prenom = new JTextField(12);
        
        ckb_cinema = new JCheckBox("Cinéma");
        ckb_sport = new JCheckBox("Sport");
        ckb_lecture = new JCheckBox("Lecture");
        
        // Question facultative 1 : pré cocher
        rb_1A = new JRadioButton("1A", true);
        rb_2A = new JRadioButton("2A");
        // ajout des RB au même groupe de boutons pour gerer les exclusions :
        groupAnnee = new ButtonGroup();
        groupAnnee.add(rb_1A);
        groupAnnee.add(rb_2A);
        
        bt_ajouter = new JButton("Ajouter");
        bt_modifier = new JButton("Modifier");
        bt_suppr = new JButton("Supprimer");
        
        // definition du comportement de la fenetre
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
        // question facultative 4 : 3 lignes du centre + serrees
        // version initiale : tout en FlowLayout LEFT
        
        // definition du layout de la fenetre : grille de 4 lignes et 1 colonne
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new GridLayout(4,1));
        
        definir4Panneaux();
        
        // ajout des panneaux au content pane de la fenetre, sur le gridlayout
        contentPane.add(pannECivil); contentPane.add(pannNomAnLoisirs);
        contentPane.add(pannComm); contentPane.add(pannBoutons);
        
    }

    private void definir4Panneaux() {
        // definition d'un placement par defaut en FlowLayout cadré à G
        LayoutManager monLayout = new FlowLayout(FlowLayout.LEFT);
        
        // definition des 4 panneaux 
        pannECivil= new JPanel(); // 1ere ligne centrée : JPanel en FlowLO centré
        // question facultative 3
        pannECivil.add(lbl_image);
        pannECivil.add(lbl_etatCivil);
        pannECivil.add(cbb_etatCivil);
        
        // panneau 2 = nom/prenom + annee + loisirs en 3 lignes 1 col.
        pannNomAnLoisirs= new JPanel(new GridLayout(3,1));
        
        // sous panneau nom / prénom
        pann21 = new JPanel(monLayout);
        pann21.add(lbl_nom);
        pann21.add(tf_nom);
        pann21.add(lbl_prenom);
        pann21.add(tf_prenom);
        
        // sous panneau Annee
        pann22 = new JPanel(monLayout);
        pann22.add(lbl_annee);
        pann22.add(rb_1A);
        pann22.add(rb_2A);
        
        // sous panneau Loisirs
        pann23 = new JPanel(monLayout);
        pann23.add(lbl_loisirs);
        pann23.add(ckb_cinema);
        pann23.add(ckb_lecture);
        pann23.add(ckb_sport);
        
        pannNomAnLoisirs.add(pann21);
        pannNomAnLoisirs.add(pann22);
        pannNomAnLoisirs.add(pann23);
        
        pannComm= new JPanel(monLayout);
        pannComm.add(lbl_commentaire);
        pannComm.add(ta_commentaire);
        
        pannBoutons= new JPanel(); // boutons centrés 
        pannBoutons.add(bt_suppr);
        pannBoutons.add(bt_modifier);
        pannBoutons.add(bt_ajouter);
    }
    
    /**
     * @param args the command line arguments
     */public static void main(String[] args) {
        
         //FenEtu maFenetre = new FenEtu("Saisie Etudiant");
         FenEtu maFenetre = new FenEtu();
         maFenetre.pack();
         maFenetre.setVisible(true);
    }
}
