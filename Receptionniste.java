package pfarecep;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Receptionniste extends Personne {
    private String poste;
    private Service service; 
    private List<Service> services = new ArrayList<>();
    private List<Salle> sallesGerees = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<RendezVous> rendezVousList = new ArrayList<>();

   
    
    
    public Receptionniste(int id, String nom, String prenom, String tel, String poste) {
        super(id, nom, prenom, tel);
        this.poste = poste;
    }

    
    @Override
    public void afficherInfos() {
        System.out.println("👩‍💼 Réceptionniste : " + getNom() + " " + getPrenom());
        System.out.println("• Poste   : " + poste);
        System.out.println("• Service : " + (service != null ? service.getNomService() : "Aucun"));

        System.out.println("• Patients inscrits : " + patients.size());
        for (Patient p : patients) {
            System.out.println("   → " + p.getNom() + " " + p.getPrenom());
        }

        System.out.println("• RDV gérés         : " + rendezVousList.size());
        for (RendezVous rdv : rendezVousList) {
            String nomPatient = (rdv.getPatient() != null)
                    ? rdv.getPatient().getNom() + " " + rdv.getPatient().getPrenom()
                    : "Inconnu";
            System.out.println("   → RDV #" + rdv.getIdRendezVous() + " - " +
                    rdv.getDate() + " à " + rdv.getHeure() + " avec " + nomPatient);
        }

        System.out.println("• Salles gérées     : " + sallesGerees.size());
        for (Salle salle : sallesGerees) {
            System.out.println("   → " + salle.getNomSalle() + " (" + salle.getTypeSalle() + ")");
        }
    }
    
    @Override
    public void seConnecter() {
        System.out.println( "le receptionniste " +getNom() + " est connecté(e).");
    }
    
   
    public void inscrirePatient(Patient p) throws PatientException {
        if (p == null) {
            throw new PatientException("❌ Patient invalide !");
        }
        if (!patients.contains(p)) {
            patients.add(p);
            p.setReceptionniste(this);
            System.out.println("👤 Patient inscrit : " + p.getNom());
        } else {
            throw new PatientException("⚠️ Patient déjà inscrit !");
        }
    }

    public void creerRendezVous(RendezVous r) throws RendezVousException {
        if (r == null)
            throw new RendezVousException("❌ Rendez-vous null !");
        
        if (rendezVousList.contains(r))
            throw new RendezVousException("⚠️ RDV déjà existant !");
        
        if (r.getPatient() == null || r.getSalle() == null || r.getService() == null)
            throw new RendezVousException("⚠️ RDV incomplet (patient, salle ou service manquant)");

        rendezVousList.add(r);
        r.setReceptionniste(this);
        System.out.println("📅 RDV #" + r.getIdRendezVous() + " créé");
    }

    public void modifierRendezVous(RendezVous r, LocalDate date, LocalTime heure) throws RendezVousException {
        if (r == null)
            throw new RendezVousException("❌ RDV null !");
        
        if (!rendezVousList.contains(r))
            throw new RendezVousException("❌ RDV introuvable dans la liste !");
        
        if (date == null || heure == null)
            throw new RendezVousException("❌ Date ou heure invalide !");
        
        r.setDate(date);
        r.setHeure(heure);
        System.out.println("📆 RDV modifié : " + r.getIdRendezVous());
    }

    public void annulerRendezVous(RendezVous r) throws RendezVousException {
        if (r == null)
            throw new RendezVousException("❌ RDV null !");
        
        if (!rendezVousList.contains(r))
            throw new RendezVousException("❌ RDV non trouvé pour annulation !");
        
        rendezVousList.remove(r);
        r.setStatut("Annulé");
        System.out.println("❌ RDV annulé : " + r.getIdRendezVous());
    }


    public void demandeGererPersonnel(Service s) {
        if (s != null) {
            System.out.println("📋 Gestion du personnel pour le service : " + s.getNomService());

            System.out.println("   → Simulation d’ajout de personnel...");

            // Simulation
            System.out.println("   👤 Patients ajoutés :");
            System.out.println("      • Amine Othmani");
            System.out.println("      • Laila Zerhouni");

            System.out.println("   🩺 Médecins ajoutés :");
            System.out.println("      • Dr. Selma Khadiri (Cardiologue)");
            System.out.println("      • Dr. Anas Bouazza (Généraliste)");

            System.out.println("   🧑‍⚕️ Infirmiers ajoutés :");
            System.out.println("      • Amina Bakkali (Jour)");
            System.out.println("      • Youssef El Idrissi (Nuit)");

            System.out.println("✅ Personnel simulé ajouté avec succès.");
        } else {
            System.out.println("❌ Service non assigné.");
        }
    }

    
    public void ConsultarService() {
        if (services.isEmpty()) {
            System.out.println("❌ Aucun service associé");
            return;
        }

        for (Service service : services) {
         
            System.out.println("🩺 SERVICE : " + service.getNomService());
 
            System.out.println("🆔 ID              : " + service.getIdService());
            System.out.println("👥 Employés        : " + service.getNombreEmployes());

            // Réceptionnistes associés
            List<Receptionniste> recs = service.getReceptionnistes();
            System.out.println("👩‍💼 Réceptionnistes : " + (recs.isEmpty() ? "Aucun" : ""));
            for (Receptionniste r : recs) {
                System.out.println("   • " + r.getNom() + " " + r.getPrenom());
            }

            // Patients associés
            List<Patient> patients = service.getPatients();
            System.out.println("👤 Patients        : " + (patients.isEmpty() ? "Aucun" : ""));
            for (Patient p : patients) {
                System.out.println("   • " + p.getNom() + " " + p.getPrenom());
            }

            }
        }
    



   

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }

    public List<Service> getServices() { return services; }
    public List<Salle> getSallesGerees() { return sallesGerees; }
    public List<Patient> getPatients() { return patients; }
    public List<RendezVous> getRendezVousList() { return rendezVousList; }

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void setSallesGerees(List<Salle> sallesGerees) {
		this.sallesGerees = sallesGerees;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public void setRendezVousList(List<RendezVous> rendezVousList) {
		this.rendezVousList = rendezVousList;
	}
}

