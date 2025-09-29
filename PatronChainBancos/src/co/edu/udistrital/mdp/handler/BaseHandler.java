package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * BaseHandler define la lógica común para todos los manejadores
 * dentro de la cadena de responsabilidad.
 */
public abstract class BaseHandler implements Handler {
    private Handler nextHandler; // Siguiente manejador en la cadena
    
    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
        /**
     * Pasa la solicitud al siguiente manejador si existe,
     * de lo contrario la rechaza.
     */
    protected void passToNext(CreditRequest request) {
        if (nextHandler != null) {
            nextHandler.handleRequest(request);
        } else {
            System.out.println("REQUEST REJECTED");
            System.out.println("No authorized personnel to handle this request for: $" + request.getAmount() + " for " + request.getCreditType());
            System.out.println("Client: " + request.getClientName());
            System.out.println();
        }
    }
        /**
     * Verifica si el manejador puede atender la solicitud.
     */
    protected abstract boolean canHandle(CreditRequest request);
        /**
     * Procesa la solicitud si cumple con los criterios.
     */
    protected abstract void processRequest(CreditRequest request);

}
