package pfarecep;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Patient extends Personne {
    private LocalDate dateNaissance;
    private String sexe;
    private String adresse;
    private String email;
    private String password;
    private DossierMedical dossierMedical;
    private Receptionniste receptionniste;
    private List<RendezVous> rendezVousList = new ArrayList<>();
    private List<Service> servicesUtilises = new ArrayList<>();

    public Patient(int id, String nom, String prenom, String tel,
                   LocalDate dateNaissance, String sexe, String adresse,
                   String email, String password) {
        super(id, nom, prenom, tel);
        this.dateNaissance = dateNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.email = email;
        this.password = password;
    }

    public void prendreRendezVous(RendezVous rdv) throws PatientException {
        if (rdv == null) throw new PatientException("✘ Le rendez-vous est null.");
        if (rendezVousList.contains(rdv)) throw new PatientException("✘ Rendez-vous déjà pris.");
        
        rendezVousList.add(rdv);
        rdv.setPatient(this);
        System.out.println("✔ RDV #" + rdv.getIdRendezVous() + " pris avec succès.");
    }

    public void consulterService(Service service) throws ServiceException {
        if (service == null) {
            throw new ServiceException("❌ Le service est nul (null).");
        }

        if (servicesUtilises.contains(service)) {
            throw new ServiceException("⚠️ Ce service a déjà été consulté.");
        }

        servicesUtilises.add(service);
        System.out.println("✔ Service " + service.getNomService() + " consulté.");
    }







 

    @Override
    public void afficherInfos() {
        System.out.println("⦿ Patient : " + getNom() + " " + getPrenom());
        System.out.println("   Date de naissance : " + dateNaissance);
        System.out.println("   Sexe               : " + sexe);
        System.out.println("   Adresse            : " + adresse);
        System.out.println("   Email              : " + email);
        System.out.println("   Password           : " + password);
        System.out.println("   Nombre de RDV      : " + rendezVousList.size());
    }


    // Gestion de DossierMedical
    public DossierMedical getDossierMedical() { return dossierMedical; }
    public void setDossierMedical(DossierMedical dossierMedical) { 
        this.dossierMedical = dossierMedical; 
        if (dossierMedical != null) dossierMedical.setPatient(this);
    }

    // Gestion de Receptionniste
    public Receptionniste getReceptionniste() { return receptionniste; }
    public void setReceptionniste(Receptionniste receptionniste) { 
        this.receptionniste = receptionniste; 
        if (receptionniste != null && !receptionniste.getPatients().contains(this)) {
            receptionniste.getPatients().add(this);
        }
    }
    @Override
    public void seConnecter() {
        System.out.println( "le patient " +getNom() + " est connecté(e).");
    }

    public List<RendezVous> getRendezVousList() { return rendezVousList; }
    public List<Service> getServicesUtilises() { return servicesUtilises; }

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRendezVousList(List<RendezVous> rendezVousList) {
		this.rendezVousList = rendezVousList;
	}

	public void setServicesUtilises(List<Service> servicesUtilises) {
		this.servicesUtilises = servicesUtilises;
	}
	
    
}
