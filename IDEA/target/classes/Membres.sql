
CREATE DATABASE base

CREATE TABLE `MEMBRE` (
  `email` VARCHAR(42) NOT NULL,
  `nom` VARCHAR(42) NOT NULL,
  `prenom` VARCHAR(42) NOT NULL,
  `mdp` VARCHAR(42) NOT NULL,
  `classe` VARCHAR(42) NOT NULL,
  PRIMARY KEY (`email`)
)
