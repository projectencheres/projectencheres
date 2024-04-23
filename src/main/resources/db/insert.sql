-- Insertion de données pour la table Utilisateur
INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES
('jdoe', 'Doe', 'John', 'jdoe@example.com', '0123456789', '123 Main St', '75001', 'Paris', 'password123', 100.00, FALSE),
('esmith', 'Smith', 'Emma', 'esmith@example.com', '0987654321', '456 Elm St', '75002', 'Lyon', 'password123', 150.00, FALSE);

-- Insertion de données pour la table Categorie
INSERT INTO Categories (libelle) VALUES
('Electronique'),
('Mobilier'),
('Livres');

-- Insertion de données pour la table Retrait
INSERT INTO Retraits (rue, code_postal, ville) VALUES
('789 Oak St', '75003', 'Marseille'),
('321 Pine St', '75004', 'Toulouse');

-- Insertion de données pour la table ArticleVendu après avoir les catégories et les lieux de retrait
INSERT INTO Articles (nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, categorie_article, lieu_retrait) VALUES
('iPhone 12', 'Smartphone dernière génération', '2024-04-10', '2024-04-20', 300.00, 1, 1),
('Chaise Scandinave', 'Chaise en bois style nordique', '2024-04-12', '2024-04-22', 50.00, 2, 2),
('Les Misérables', 'Livre classique par Victor Hugo', '2024-04-15', '2024-04-25', 10.00, 3, NULL);

-- Insertion de données pour la table Enchere
INSERT INTO Encheres (date_enchere, montant_enchere, no_article, no_utilisateur) VALUES
('2024-04-11 10:00:00', 320.00, 1, 1),  -- Supposons que l'utilisateur jdoe a enchéri pour l'iPhone 12
('2024-04-13 14:30:00', 60.00, 2, 2),   -- Supposons que l'utilisateur esmith a enchéri pour la Chaise Scandinave
('2024-04-16 16:00:00', 15.00, 3, 1);   -- Supposons que l'utilisateur jdoe a enchéri pour le livre Les Misérables
