package pfarecep;

import java.util.ArrayList;
import java.util.List;

public class Service {
    private int idService;
    private String nomService;
    private int nombreEmployes;

    private List<Patient> patients = new ArrayList<>();
    private List<Receptionniste> receptionnistes = new ArrayList<>();

    public Service(int id, String nom, int nb) {
        this.idService = id;
        this.nomService = nom;
        this.nombreEmployes = nb;
    }

    // Getters & Setters
    public int getIdService() { return idService; }
    public void setIdService(int idService) { this.idService = idService; }

    public String getNomService() { return nomService; }
    public void setNomService(String nomService) { this.nomService = nomService; }

    public int getNombreEmployes() { return nombreEmployes; }
    public void setNombreEmployes(int nombreEmployes) { this.nombreEmployes = nombreEmployes; }

    public List<Patient> getPatients() { return patients; }
    public void setPatients(List<Patient> patients) { this.patients = patients; }

    public List<Receptionniste> getReceptionnistes() { return receptionnistes; }
    public void setReceptionnistes(List<Receptionniste> receptionnistes) { this.receptionnistes = receptionnistes; }
    
}



