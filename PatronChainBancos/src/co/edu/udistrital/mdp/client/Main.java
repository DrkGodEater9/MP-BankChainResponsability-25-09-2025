package co.edu.udistrital.mdp.client;

import co.edu.udistrital.mdp.datamodel.CreditRequest;
import co.edu.udistrital.mdp.handler.*;
import java.util.Scanner;

public class Main {    
    public static void main(String[] args) {
           // Crear los handlers
        Handler cashier = new Cashier();
        Handler advisor = new CommercialAdvisor();
        Handler manager = new BranchManager();
        Handler regional = new RegionalManager();
        Handler vp = new VicePresident();

        // Armamos la cadena de responsabilidad
        cashier.setNextHandler(advisor);
        advisor.setNextHandler(manager);
        manager.setNextHandler(regional);
        regional.setNextHandler(vp);

        // Aqui creamos las solicitudes de prueba
        CreditRequest[] requests = {
            new CreditRequest("Juan Perez", "Consultation", 20000, 0),
            new CreditRequest("Ana Gomez", "Personal Loan", 150000, 620),
            new CreditRequest("Carlos Ruiz", "Mortgage Credit", 1800000, 710),
            new CreditRequest("Empresa XYZ", "Corporate Credit", 7000000, 760),
            new CreditRequest("Banco ABC", "Institutional Policy", 20000000, 820),
            new CreditRequest("Luis Torres", "Withdrawal", 60000, 0), // esta solicitud esta fuera de límite del cajero
            new CreditRequest("María Diaz", "Business Credit", 2500000, 690) //esta solicitud supera límite del branch manager
        };

        // Procesamiento de solicitudes
        for (CreditRequest request : requests) {
            System.out.println("Processing request for: " + request.getClientName());
            cashier.handleRequest(request);
            System.out.println("========================================");
        }

        // Ejemplo de una cadena reducida
        System.out.println("=== Example with reduced chain (Cashier -> Advisor) ===");
        Handler cashierOnly = new Cashier();
        Handler advisorOnly = new CommercialAdvisor();
        cashierOnly.setNextHandler(advisorOnly);

        CreditRequest testRequest = new CreditRequest("Pedro Castro", "Corporate Credit", 8000000, 770);
        cashierOnly.handleRequest(testRequest);
    }
}
