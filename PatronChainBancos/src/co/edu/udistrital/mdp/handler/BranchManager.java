package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * BranchManager maneja créditos hipotecarios, comerciales
 * o de negocio hasta un límite de 2 millones.
 */
public class BranchManager extends BaseHandler {
    private double maxLimit = 2000000; // Límite máximo que puede autorizar
    
    @Override
    protected boolean canHandle(CreditRequest request) {
              // Verifica monto y tipo de crédito permitido
        return request.getAmount() <= maxLimit && 
               (request.getCreditType().toLowerCase().contains("mortgage") ||
                request.getCreditType().toLowerCase().contains("commercial") ||
                request.getCreditType().toLowerCase().contains("business"));
    }
    
    @Override
    protected void processRequest(CreditRequest request) {
        // Simula el procesamiento de la solicitud
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
           // Procesa si corresponde, de lo contrario pasa al siguiente nivel
        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Branch Manager: This request requires higher authorization, forwarding...");
            passToNext(request);
        }
    }
}

