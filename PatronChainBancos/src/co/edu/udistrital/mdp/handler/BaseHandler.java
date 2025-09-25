package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;

public abstract class BaseHandler implements Handler {
    private Handler nextHandler;
    
    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
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
    
    protected abstract boolean canHandle(CreditRequest request);
    protected abstract void processRequest(CreditRequest request);
}