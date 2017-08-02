/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;
import modelo.Modelo;
import modelo.QampA;

/**
 *
 * @author David
 */
public class Enigma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Modelo m = new Modelo();
        Scanner sc = new Scanner(System.in);
        m.getQuestions().forEach((QampA q) -> {
            int option = 0;
            String s = q.toString();
            boolean error;
            do{       
                error = false;
                System.out.println(s);
                System.out.print("Opción: ");
                try {
                    option = Integer.parseInt(sc.nextLine());
                    System.out.print(option <= 0 || option > 4 ? "Número fuera de rango...\n":"La respuesta es: ");
                } catch(NumberFormatException e){
                    System.out.println("Por favor, introduzca un número...");
                    error = true;
                }
            } while(error || option <= 0 || option > 4);
            System.out.println(q.isCorrect(q.getFourOptions().get(option-1)));
        });
    }
    
}
