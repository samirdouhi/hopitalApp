package pfarecep;



public abstract class Personne {
    private int id;
    private String nom;
    private String prenom;
    private String tel;

    public Personne(int id, String nom, String prenom, String tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
    }

    public abstract void afficherInfos();

    public void seConnecter() {
        System.out.println(nom + " est connecté(e).");
    }

    public void seDeconnecter() {
        System.out.println(nom + " est déconnecté(e).");
    }

    public void modifierInfoPerso(String nouveauNom, String nouveauPrenom, String nouveauTel) {
        this.nom = nouveauNom;
        this.prenom = nouveauPrenom;
        this.tel = nouveauTel;
        System.out.println("🔄 Informations mises à jour : " + nom + " " + prenom + ", Tel: " + tel);
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }
}
