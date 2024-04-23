-- Création des tables selon le diagramme de classe fourni

-- Table Utilisateur
CREATE TABLE Utilisateurs (
    no_utilisateur SERIAL PRIMARY KEY,
    pseudo VARCHAR(255) NOT NULL,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    telephone VARCHAR(20),
    rue VARCHAR(255),
    code_postal VARCHAR(10),
    ville VARCHAR(255),
    mot_de_passe VARCHAR(255) NOT NULL,
    credit NUMERIC(10,2) DEFAULT 0,
    administrateur BOOLEAN NOT NULL DEFAULT FALSE
);

-- Table Article
CREATE TABLE Articles (
    no_article SERIAL PRIMARY KEY,
    nom_article VARCHAR(255) NOT NULL,
    description TEXT,
    date_debut_encheres DATE NOT NULL,
    date_fin_encheres DATE NOT NULL,
    mise_a_prix NUMERIC(10,2) NOT NULL,
    prix_vente NUMERIC(10,2),
    etat_vente VARCHAR(50),
    categorie_article INT NOT NULL,
    lieu_retrait INT
);

-- Table Retrait
CREATE TABLE Retraits (
    no_retrait SERIAL PRIMARY KEY,
    rue VARCHAR(255),
    code_postal VARCHAR(10),
    ville VARCHAR(255)
);

-- Table Categorie
CREATE TABLE Categories (
    no_categorie SERIAL PRIMARY KEY,
    libelle VARCHAR(255) NOT NULL
);

-- Table Enchère
CREATE TABLE Encheres (
    no_enchere SERIAL PRIMARY KEY,
    date_enchere TIMESTAMP NOT NULL,
    montant_enchere NUMERIC(10,2) NOT NULL,
    no_article INT NOT NULL,
    no_utilisateur INT NOT NULL,
    FOREIGN KEY (no_article) REFERENCES Articles(no_article),
    FOREIGN KEY (no_utilisateur) REFERENCES Utilisateurs(no_utilisateur)
);

-- Relations entre les tables
ALTER TABLE Articles ADD FOREIGN KEY (categorie_article) REFERENCES Categories(no_categorie);
ALTER TABLE Articles ADD FOREIGN KEY (lieu_retrait) REFERENCES Retraits(no_retrait);