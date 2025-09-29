package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * RegionalManager maneja créditos corporativos o de inversión
 * hasta un límite de 10 millones. 
 * Aprueba si el puntaje es >= 750, de lo contrario rechaza o reenvía.
 */
public class RegionalManager extends BaseHandler {
        // Límite máximo que puede aprobar este cargo
    private double maxLimit = 10000000;
    
    @Override
    protected boolean canHandle(CreditRequest request) {
                // Verifica que el monto no supere el límite y que el tipo sea corporativo o inversión
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
               // Se aprueba solo si el score es alto (750 o más)
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
                // Si cumple con las condiciones, lo procesa. De lo contrario, lo pasa al siguiente

        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Regional Manager: This request exceeds all available authorizations, forwarding...");
            passToNext(request);
        }
    }
}

