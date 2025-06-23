package pfarecep;

public class DossierMedicalException extends Exception {
	private static final long serialVersionUID = 1L;
    public DossierMedicalException() {
        super();
    }

    public DossierMedicalException(String message) {
        super(message);
    }
}
