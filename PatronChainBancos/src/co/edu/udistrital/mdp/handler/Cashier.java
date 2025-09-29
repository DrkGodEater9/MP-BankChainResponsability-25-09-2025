package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * Cashier maneja operaciones básicas como consultas, depósitos
 * y retiros menores, hasta un límite de 50 mil.
 */
public class Cashier extends BaseHandler {
    private double maxLimit = 50000;
    
    @Override
    protected boolean canHandle(CreditRequest request) {
                // Verifica que el monto esté dentro del límite
        // y que el tipo de solicitud corresponda
        return request.getAmount() <= maxLimit && 
               (request.getCreditType().toLowerCase().contains("consultation") ||
                request.getCreditType().toLowerCase().contains("deposit") ||
                request.getCreditType().toLowerCase().contains("withdrawal"));
    }
    
    @Override
    protected void processRequest(CreditRequest request) {
                // Simula el procesamiento de la solicitud

        System.out.println("PROCESSED BY CASHIER");
        System.out.println("Client: " + request.getClientName());
        System.out.println("Type: " + request.getCreditType());
        System.out.println("Amount: $" + request.getAmount());
        System.out.println("REQUEST APPROVED");
        System.out.println("Processing: Balance consultations, deposits, minor withdrawals");
        System.out.println();
    }
    
    @Override
    public void handleRequest(CreditRequest request) {
                // Procesa si aplica, de lo contrario pasa al siguiente

        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Cashier: I cannot process this request, forwarding...");
            passToNext(request);
        }
    }
}

