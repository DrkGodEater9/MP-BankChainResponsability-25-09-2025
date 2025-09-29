package co.edu.udistrital.mdp.datamodel;

/**
 * Clase que representa una solicitud de crédito.
 */
public class CreditRequest {
    private String clientName;   // Nombre del cliente
    private String creditType;   // Tipo de crédito
    private double amount;       // Monto solicitado
    private int score;           // Puntaje del cliente
        
    /**
     * Constructor para inicializar la solicitud de crédito.
     */
    public CreditRequest(String clientName, String creditType, double amount, int score) {
        this.clientName = clientName;
        this.creditType = creditType;
        this.amount = amount;
        this.score = score;
    }
    
    // Getters
    public String getClientName() { return clientName; }
    public String getCreditType() { return creditType; }
    public double getAmount() { return amount; }
    public int getScore() { return score; }
}

