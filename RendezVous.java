package pfarecep;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous {
    // Attributs du diagramme
    private int idRendezVous;
    private LocalDate date;
    private LocalTime heure;
    private String statut;
    
    // Relations (cardinalités fournies)
    private Patient patient;
    private Salle salle;
    private Receptionniste receptionniste;
    private Service service;

    // Constructeur
    public RendezVous(int idRendezVous, LocalDate date, LocalTime heure, String statut) {
        this.idRendezVous = idRendezVous;
        this.date = date;
        this.heure = heure;
        this.statut = statut;
    }

    // =============== METHODE DU DIAGRAMME ===============
    public void consulterRendezVous() throws RendezVousException {
        if (date == null || heure == null) {
            throw new RendezVousException("❌ Date ou heure manquante");
        }
        if (patient == null || salle == null || receptionniste == null) {
            throw new RendezVousException("❌ Données incomplètes");
        }

        System.out.println(
            "📅 RDV #" + idRendezVous + 
            " | " + date + " " + heure + 
            " | Statut : " + statut + 
            " | Patient : " + patient.getNom() + 
            " | Salle : " + salle.getNomSalle() + 
            " | Réceptionniste : " + receptionniste.getNom()
        );
    }

    // =============== GETTERS/SETTERS STANDARDS ===============
    public int getIdRendezVous() { return idRendezVous; }
    public void setIdRendezVous(int idRendezVous) { this.idRendezVous = idRendezVous; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getHeure() { return heure; }
    public void setHeure(LocalTime heure) { this.heure = heure; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; } // Setter simple

    public Salle getSalle() { return salle; }
    public void setSalle(Salle salle) { this.salle = salle; } // Setter simple

    public Receptionniste getReceptionniste() { return receptionniste; }
    public void setReceptionniste(Receptionniste receptionniste) { this.receptionniste = receptionniste; } // Setter simple

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }


}
