create table Produits
(
    id_produit NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1), libelle varchar2(50) NOT NULL, categorie varchar2(50) NOT NULL, sous_categorie varchar2(50), quantite number NOT NULL, prix INT NOT NULL,
    CONSTRAINT pk_table_produit PRIMARY KEY (id_produit)
)
INSERT INTO Produits (libelle,categorie,sous_categorie,quantite,prix)  values ('truc','Casque Audio','Casque nul',20,15);