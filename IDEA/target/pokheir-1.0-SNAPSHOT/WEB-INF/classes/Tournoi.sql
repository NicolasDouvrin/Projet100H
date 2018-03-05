CREATE TABLE tournoi (
  idTournoi INT NOT NULL AUTO_INCREMENT,
  nbInscrits VARCHAR(42) NOT NULL,
  nbPlaces VARCHAR(15) NOT NULL,
  type BOOLEAN NOT NULL,
  PRIMARY KEY (idTournoi)
)

CREATE TABLE participe (
  emailInscrit VARCHAR(42) NOT NULL,
  idTournoiInscrit INT NOT NULL,
  PRIMARY KEY (emailInscrit,idTournoiInscrit)
)
