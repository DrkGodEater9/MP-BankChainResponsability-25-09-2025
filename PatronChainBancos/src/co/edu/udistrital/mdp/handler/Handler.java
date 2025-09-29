package co.edu.udistrital.mdp.handler;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
/**
 * Handler define la estructura básica para la cadena de responsabilidad.
 * Cada manejador puede procesar la solicitud o pasarla al siguiente.
 */
public interface Handler {
        /**
     * Asigna el siguiente manejador en la cadena.
     */
    void setNextHandler(Handler nextHandler);
        /**
     * Procesa la solicitud de crédito o la reenvía si no aplica.
     */
    void handleRequest(CreditRequest request);
}

