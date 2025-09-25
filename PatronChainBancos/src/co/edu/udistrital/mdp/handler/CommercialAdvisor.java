package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;

public class CommercialAdvisor extends BaseHandler {
    private double maxLimit = 500000;
    
    @Override
    protected boolean canHandle(CreditRequest request) {
        return request.getAmount() <= maxLimit && 
               (request.getCreditType().toLowerCase().contains("opening") ||
                request.getCreditType().toLowerCase().contains("personal") ||
                request.getCreditType().toLowerCase().contains("card"));
    }
    
    @Override
    protected void processRequest(CreditRequest request) {
        System.out.println("PROCESSED BY COMMERCIAL ADVISOR");
        System.out.println("Client: " + request.getClientName());
        System.out.println("Type: " + request.getCreditType());
        System.out.println("Amount: $" + request.getAmount());
        System.out.println("Credit score: " + request.getScore());
        
        if (request.getScore() >= 600) {
            System.out.println("REQUEST APPROVED");
            System.out.println("Processing: Account opening, small personal loans, credit cards");
        } else {
            System.out.println("REQUEST REJECTED");
            System.out.println("Reason: Insufficient credit score (minimum 600)");
        }
        System.out.println();
    }
    
    @Override
    public void handleRequest(CreditRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Commercial Advisor: This request exceeds my authorization, forwarding...");
            passToNext(request);
        }
    }
}
