// Dans un premier temps

CREATE DATABASE base

// Puis dans la base

CREATE TABLE `MEMBRE` (
  `email` VARCHAR(42) NOT NULL,
  `nom` VARCHAR(42) NOT NULL,
  `prenom` VARCHAR(42) NOT NULL,
  `classe` VARCHAR(42) NOT NULL,
  `mdp` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`email`)
)

// Et enfin dans membre

INSERT INTO membre VALUE ('admin@hei.yncrea.fr','admin','admin','H00''hei2018')