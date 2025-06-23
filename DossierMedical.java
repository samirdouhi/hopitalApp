package pfarecep;


import java.time.LocalDate;

public class DossierMedical {
    private int idDossier;
    private LocalDate dateCreation;
    private String historiqueMaladies;
    private String traitement;
    private String allergies;
    private String medicamentsPrescrits;
    private String observation;

    private Patient patient;
    private Receptionniste receptionniste;

    public DossierMedical(int id, LocalDate dateCreation, String historiqueMaladies,
                          String traitement, String allergies, String medicamentsPrescrits,String observation) {
        this.idDossier = id;
        this.dateCreation = dateCreation;
        this.historiqueMaladies = historiqueMaladies;
        this.traitement = traitement;
        this.allergies = allergies;
        this.medicamentsPrescrits = medicamentsPrescrits;
        this.observation = observation;
    }

    public void consulterDossierMedical() throws DossierMedicalException {
        if (patient == null) {
            throw new DossierMedicalException("❌ Aucun patient associé à ce dossier médical.");
        }
        if (receptionniste == null) {
            throw new DossierMedicalException("❌ Aucun réceptionniste associé à ce dossier médical.");
        }

        System.out.println("📋 Dossier médical ID: " + idDossier);
        System.out.println("• Date de création       : " + dateCreation);
        System.out.println("• Historique maladies    : " + historiqueMaladies);
        System.out.println("• Traitement prescrit    : " + traitement);
        System.out.println("• Allergies              : " + allergies);
        System.out.println("• Médicaments prescrits  : " + medicamentsPrescrits);
        System.out.println("• observation            : " + observation);
        System.out.println("• Patient                : " + patient.getNom());
        System.out.println("• Réceptionniste         : " + receptionniste.getNom());
    }

    // Getters & Setters
    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public String getHistoriqueMaladies() { return historiqueMaladies; }
    public void setHistoriqueMaladies(String historiqueMaladies) { this.historiqueMaladies = historiqueMaladies; }

    public String getTraitement() { return traitement; }
    public void setTraitement(String traitement) { this.traitement = traitement; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getMedicamentsPrescrits() { return medicamentsPrescrits; }
    public void setMedicamentsPrescrits(String medicamentsPrescrits) { this.medicamentsPrescrits = medicamentsPrescrits; }

    public String getObservation() { return observation; }
    public void setObservation(String observation) { this.observation = observation; }

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Receptionniste getReceptionniste() {
		return receptionniste;
	}

	public void setReceptionniste(Receptionniste receptionniste) {
		this.receptionniste = receptionniste;
	}

}