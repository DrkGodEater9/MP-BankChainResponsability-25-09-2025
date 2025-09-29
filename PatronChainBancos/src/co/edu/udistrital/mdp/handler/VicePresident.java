package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * Handler que representa al Vicepresidente.
 * Se encarga de solicitudes de alto nivel (fusiones, políticas, institucionales o legales).
 */
public class VicePresident extends BaseHandler {
        /**
     * Verifica si la solicitud corresponde al tipo
     * que el Vicepresidente puede manejar.
     */
    @Override
    protected boolean canHandle(CreditRequest request) {
        return request.getCreditType().toLowerCase().contains("merger") ||
               request.getCreditType().toLowerCase().contains("policy") ||
               request.getCreditType().toLowerCase().contains("institutional") ||
               request.getCreditType().toLowerCase().contains("legal");
    }
    /**
     * Procesa la solicitud si cumple con las condiciones
     * y valida el puntaje del cliente.
     */
    @Override
    protected void processRequest(CreditRequest request) {
        System.out.println("PROCESSED BY VICE PRESIDENT");
        System.out.println("Client: " + request.getClientName());
        System.out.println("Type: " + request.getCreditType());
        System.out.println("Amount: $" + request.getAmount());
        System.out.println("Credit score: " + request.getScore());
        
        if (request.getScore() >= 800) {
            System.out.println("REQUEST APPROVED");
            System.out.println("Processing: Mergers, institutional policies, major legal cases");
        } else {
            System.out.println("REQUEST REJECTED");
            System.out.println("Reason: Insufficient credit score for institutional operations (minimum 800)");
        }
        System.out.println();
    }
    /**
     * Maneja la solicitud si puede hacerlo,
     * en caso contrario la reenvía al siguiente en la cadena.
     */
    @Override
    public void handleRequest(CreditRequest request) {
        if (canHandle(request)) {
            processRequest(request);
        } else {
            System.out.println("Vice President: This request does not correspond to my area of competence, forwarding...");
            passToNext(request);
        }
    }
}

