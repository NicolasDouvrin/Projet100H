package devweb.entities;

public class Membre {
        private String email;
        private String nom;
        private String prenom;
        private String classe;
        private String mdp;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Membre(String email, String nom, String prenom, String classe, String mdp) {

        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.mdp = mdp;
    }
}
