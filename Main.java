package pfarecep;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            // Réceptionnistes
            Receptionniste recep1 = new Receptionniste(1, "Fatima", "Zahra", "0600011122", "Accueil");
            Receptionniste recep2 = new Receptionniste(2, "samir", "Mouhssine", "0600022233", "Accueil");

            // Services
            Service service1 = new Service(1, "Cardiologie", 12);
            Service service2 = new Service(2, "Neurologie", 10);

            // Salles
            Salle salle1 = new Salle(101, "Salle A", "Consultation", 4, "Étage 2");
            Salle salle2 = new Salle(102, "Salle B", "Soins", 3, "Étage 1");

            // Patients
            Patient patient1 = new Patient(1, "Youssef", "Bouzid", "0600112233",
                    LocalDate.of(1998, 3, 15), "H", "Casablanca", "youssef@gmail.com", "pass123");
            Patient patient2 = new Patient(2, "Salma", "Khalfi", "0600556677",
                    LocalDate.of(1995, 6, 10), "F", "Fès", "salma@gmail.com", "salma123");

            // Dossiers médicaux
            DossierMedical dossier1 = new DossierMedical(4801, LocalDate.of(2025, 5, 12),
                    "Asthme", "Ventoline", "Poussière", "Ventoline", "Observation générale");
            DossierMedical dossier2 = new DossierMedical(4802, LocalDate.of(2025, 5, 13),
                    "Migraine chronique", "Ibuprofène", "Aucune", "Doliprane", "Patiente souvent stressée");

            // RDVs patient1
            List<RendezVous> rdvsPatient1 = new ArrayList<>();
            rdvsPatient1.add(new RendezVous(3001, LocalDate.of(2025, 5, 13), LocalTime.of(10, 30), "Planifié"));
            rdvsPatient1.add(new RendezVous(3002, LocalDate.of(2025, 5, 14), LocalTime.of(11, 0), "Confirmé"));
            rdvsPatient1.add(new RendezVous(3003, LocalDate.of(2025, 5, 15), LocalTime.of(9, 15), "En attente"));

            // RDVs patient2
            List<RendezVous> rdvsPatient2 = new ArrayList<>();
            rdvsPatient2.add(new RendezVous(3004, LocalDate.of(2025, 5, 16), LocalTime.of(14, 0), "Planifié"));
            rdvsPatient2.add(new RendezVous(3005, LocalDate.of(2025, 5, 17), LocalTime.of(9, 45), "Confirmé"));
            rdvsPatient2.add(new RendezVous(3006, LocalDate.of(2025, 5, 18), LocalTime.of(11, 15), "Annulé"));

            // Associer patients aux services
            service1.getPatients().add(patient1);
            service2.getPatients().add(patient2);

            // Affectations patient1
            for (RendezVous rdv : rdvsPatient1) {
                rdv.setPatient(patient1);
                rdv.setReceptionniste(recep1);
                rdv.setSalle(salle1);
                rdv.setService(service1);
                patient1.prendreRendezVous(rdv);
                recep1.creerRendezVous(rdv);
            }
            salle1.setRendezVousList(rdvsPatient1);

            // Affectations patient2
            for (RendezVous rdv : rdvsPatient2) {
                rdv.setPatient(patient2);
                rdv.setReceptionniste(recep2);
                rdv.setSalle(salle2);
                rdv.setService(service2);
                patient2.prendreRendezVous(rdv);
                recep2.creerRendezVous(rdv);
            }
            salle2.setRendezVousList(rdvsPatient2);

            // Lier dossiers médicaux
            dossier1.setPatient(patient1);
            dossier1.setReceptionniste(recep1);
            patient1.setDossierMedical(dossier1);

            dossier2.setPatient(patient2);
            dossier2.setReceptionniste(recep2);
            patient2.setDossierMedical(dossier2);

            // Associations diverses pour recep1
            recep1.setService(service1);
            recep1.getSallesGerees().add(salle1);
            recep1.getSallesGerees().add(salle2);
            recep1.getServices().add(service1);
            service1.getReceptionnistes().add(recep1);
            salle1.setDisponibilite(false);
            recep1.inscrirePatient(patient1);

            // Associations diverses pour recep2
            recep2.setService(service2);
            recep2.getSallesGerees().add(salle1);
            recep2.getSallesGerees().add(salle2);
            recep2.getServices().add(service2);
            service2.getReceptionnistes().add(recep2);
            recep2.inscrirePatient(patient2);

            // === Menu interactif ===
            int choix;
            do {
                System.out.println("\n=========== MENU PRINCIPAL ===========");
                System.out.println("1. Consulter les dossiers médicaux des patients");
                System.out.println("2. Afficher les informations des salles");
                System.out.println("3. Afficher les informations des patients");
                System.out.println("4. Afficher les informations des réceptionnistes");
                System.out.println("5. Afficher les services associés");
                System.out.println("6. Consulter tous les rendez-vous");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");
                choix = sc.nextInt();
                sc.nextLine(); // vider buffer

                switch (choix) {
                    case 1:
                        System.out.println("\n◇ DOSSIERS MÉDICAUX");
                        dossier1.consulterDossierMedical();
                        dossier2.consulterDossierMedical();
                        break;
                    case 2:
                        System.out.println("\n◇ SALLES");
                        salle1.verifierDisponibiliteSalle();
                        salle1.afficherInfos();
                        salle2.afficherInfos();
                        break;
                    case 3:
                        System.out.println("\n◇ PATIENTS");
                        patient1.afficherInfos();
                        patient2.afficherInfos();
                        break;
                    case 4:
                        System.out.println("\n◇ RÉCEPTIONNISTES");
                        recep1.afficherInfos();
                        recep2.afficherInfos();
                        recep1.demandeGererPersonnel(service1);
                        break;
                    case 5:
                        System.out.println("\n◇ SERVICES ASSOCIÉS");
                        recep1.ConsultarService();
                        recep2.ConsultarService();
                        break;
                    case 6:
                        System.out.println("\n📅 TOUS LES RENDEZ-VOUS :");

                        System.out.println("\n--- Patient 1 ---");
                        for (RendezVous rdv : rdvsPatient1) {
                            rdv.consulterRendezVous();
                        }

                        System.out.println("\n--- Patient 2 ---");
                        for (RendezVous rdv : rdvsPatient2) {
                            rdv.consulterRendezVous();
                        }
                        break;
                    case 0:
                        System.out.println("✅ Fin du programme.");
                        break;
                    default:
                        System.out.println("❌ Choix invalide !");
                }
            } while (choix != 0);

            sc.close();

        } catch (Exception e) {
            System.out.println("[ERREUR] " + e.getMessage());
        }
    }
}




