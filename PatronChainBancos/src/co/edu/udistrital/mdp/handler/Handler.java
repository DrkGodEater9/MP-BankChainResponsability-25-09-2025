package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;

public interface Handler {
    void setNextHandler(Handler nextHandler);
    void handleRequest(CreditRequest request);
}
