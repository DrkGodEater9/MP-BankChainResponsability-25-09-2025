package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;

public class BranchManager extends BaseHandler {
    private double maxLimit = 2000000;
    
    @Override
    protected boolean canHandle(CreditRequest request) {
        return request.getAmount() <= maxLimit && 
               (request.getCreditType().toLowerCase().contains("mortgage") ||
                request.getCreditType().toLowerCase().contains("commercial") ||
                request.getCreditType().toLowerCase().contains("business"));
    }
    
    @Override
    protected void processRequest(CreditRequest request) {
        System.out.println("PROCESSED BY BRANCH MANAGER");
        System.out.println("Client: " + request.getClientName());
        System.out.println("Type: " + request.getCreditType());
        System.out.println("Amount: $" + request.getAmount());
        System.out.println("Credit score: " + request.getScore());
        
        if (request.getScore() >= 700) {
            System.out.println("REQUEST APPROVED");
            System.out.println("Processing: Mortgage loans, important commercial credits");
        } else {
            System.out.println("REQUEST REJECTED");
            System.out.println("Reason: Insufficient credit score for this type of credit (minimum 700)");
        }
        System.out.println();
    }
    
    @Override
    public void handleRequest(CreditRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Branch Manager: This request requires higher authorization, forwarding...");
            passToNext(request);
        }
    }
}
