package pfarecep;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    // Attributs du diagramme
    private int idSalle;
    private String nomSalle;
    private String typeSalle;
    private int capacite;
    private boolean disponibilite;
    private String localisation;

    // Listes de relations (sans méthodes de gestion)
    private List<RendezVous> rendezVousList = new ArrayList<>();
    private List<Receptionniste> gestionnaires = new ArrayList<>();

    // Constructeur
    public Salle(int idSalle, String nomSalle, String typeSalle, int capacite, String localisation) {
        this.idSalle = idSalle;
        this.nomSalle = nomSalle;
        this.typeSalle = typeSalle;
        this.capacite = capacite;
        this.disponibilite = true;
        this.localisation = localisation;
    }

    // ======================= METHODES DU DIAGRAMME =======================
    public void reserverSalle() throws SalleException {
        if (!disponibilite) {
            throw new SalleException("❌ Salle déjà occupée : " + nomSalle);
        }
        disponibilite = false;
        System.out.println("🏥 Salle " + nomSalle + " réservée.");
    }

    public void verifierDisponibiliteSalle() {
        System.out.println("🕓 Salle " + nomSalle + " est " + (disponibilite ? "disponible" : "occupée"));
    }

    public void afficherInfos() {
        System.out.println("🏠 Salle : " + nomSalle + " (ID: " + idSalle + ")");
        System.out.println("• Type         : " + typeSalle);
        System.out.println("• Capacité     : " + capacite);
        System.out.println("• Localisation : " + localisation);
        System.out.println("• Disponibilité: " + (disponibilite ? "✅ Disponible" : "❌ Occupée"));
        System.out.println("• Rendez-vous  : " + rendezVousList.size());
        System.out.println("───────────────────────────────");
    }

    // ======================= GETTERS/SETTERS =======================
    public int getIdSalle() { return idSalle; }
    public String getNomSalle() { return nomSalle; }
    public String getTypeSalle() { return typeSalle; }
    public int getCapacite() { return capacite; }
    public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public void setRendezVousList(List<RendezVous> rendezVousList) {
		this.rendezVousList = rendezVousList;
	}

	public boolean isDisponible() { return disponibilite; }
    public String getLocalisation() { return localisation; }
    public List<RendezVous> getRendezVousList() { return new ArrayList<>(rendezVousList); }
    public List<Receptionniste> getGestionnaires() { return new ArrayList<>(gestionnaires); }

    public void setCapacite(int capacite) { this.capacite = capacite; }
    public void setDisponibilite(boolean disponibilite) { this.disponibilite = disponibilite; }
}





