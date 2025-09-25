package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;

public class RegionalManager extends BaseHandler {
    private double maxLimit = 10000000;
    
    @Override
    protected boolean canHandle(CreditRequest request) {
        return request.getAmount() <= maxLimit &&
                (request.getCreditType().toLowerCase().contains("corporate") ||
                request.getCreditType().toLowerCase().contains("investment"));
    }
    
    @Override
    protected void processRequest(CreditRequest request) {
        System.out.println("PROCESSED BY REGIONAL MANAGER");
        System.out.println("Client: " + request.getClientName());
        System.out.println("Type: " + request.getCreditType());
        System.out.println("Amount: $" + request.getAmount());
        System.out.println("Credit score: " + request.getScore());
        
        if (request.getScore() >= 750) {
            System.out.println("REQUEST APPROVED");
            System.out.println("Processing: Large corporate credits, investment decisions");
        } else {
            System.out.println("REQUEST REJECTED");
            System.out.println("Reason: Insufficient credit score for corporate credits (minimum 750)");
        }
        System.out.println();
    }
    
    @Override
    public void handleRequest(CreditRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Regional Manager: This request exceeds all available authorizations, forwarding...");
            passToNext(request);
        }
    }
}
