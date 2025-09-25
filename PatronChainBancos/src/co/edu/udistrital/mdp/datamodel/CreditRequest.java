package co.edu.udistrital.mdp.datamodel;

public class CreditRequest {
    private String clientName;
    private String creditType;
    private double amount;
    private int score;
    
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
