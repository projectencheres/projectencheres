-- Création des tables selon le diagramme de classe fourni

-- Table Utilisateur
CREATE TABLE Utilisateur (
    noUtilisateur SERIAL PRIMARY KEY,
    pseudo VARCHAR(255) NOT NULL,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    telephone VARCHAR(20),
    rue VARCHAR(255),
    codePostal VARCHAR(10),
    ville VARCHAR(255),
    motDePasse VARCHAR(255) NOT NULL,
    credit NUMERIC(10,2) DEFAULT 0,
    administrateur BOOLEAN NOT NULL DEFAULT FALSE
);

-- Table ArticleVendu
CREATE TABLE Article (
    noArticle SERIAL PRIMARY KEY,
    nomArticle VARCHAR(255) NOT NULL,
    description TEXT,
    dateDebutEncheres DATE NOT NULL,
    dateFinEncheres DATE NOT NULL,
    miseAPrix NUMERIC(10,2) NOT NULL,
    prixVente NUMERIC(10,2),
    etatVente VARCHAR(50),
    categorieArticle INT NOT NULL,
    lieuRetrait INT
);

-- Table Retrait
CREATE TABLE Retrait (
    noRetrait SERIAL PRIMARY KEY,
    rue VARCHAR(255),
    code_postal VARCHAR(10),
    ville VARCHAR(255)
);

-- Table Categorie
CREATE TABLE Categorie (
    noCategorie SERIAL PRIMARY KEY,
    libelle VARCHAR(255) NOT NULL
);

-- Table Enchère
CREATE TABLE Enchere (
    noEnchere SERIAL PRIMARY KEY,
    dateEnchere TIMESTAMP NOT NULL,
    montant_enchere NUMERIC(10,2) NOT NULL,
    noArticle INT NOT NULL,
    noUtilisateur INT NOT NULL,
    FOREIGN KEY (noArticle) REFERENCES Article(noArticle),
    FOREIGN KEY (noUtilisateur) REFERENCES Utilisateur(noUtilisateur)
);

-- Relations entre les tables
ALTER TABLE Article ADD FOREIGN KEY (categorieArticle) REFERENCES Categorie(noCategorie);
ALTER TABLE Article ADD FOREIGN KEY (lieuRetrait) REFERENCES Retrait(noRetrait);