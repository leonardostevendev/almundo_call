package com.almundo;

import com.almundo.util.storage.Calls;
import com.almundo.util.storage.Users;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class Main {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);
    System.out.println("Hola, empecemos................");
    System.out.println("Dale un nombre al Call Center................");
    String callCenterName = s.next();

    System.out.println("Dale un numero de telefono para que se comuniquen...");
    String telNumber = s.next();
    System.out.println("Con cuantas personas quieres que cuente el call center ?");
    int callCenterSize = s.nextInt();

    CallCenter callCenter = new CallCenter(callCenterName, telNumber, callCenterSize);

    System.out.println("*********************     Bienvenido a " + callCenterName + " (" + telNumber + ")" + "*********************");
    System.out.println("El siguiente es tu menú, tu decides que hacer...");

    int option = 1;

    while (option > 0) {

      System.out.println("1. Realizar llamadas");
      System.out.println("2. Imprimir log de llamadas");
      System.out.println("3. Ver usuarios");
      System.out.println("");
      System.out.println("Ingresa una opción");
      option = s.nextInt();

      switch (option) {
        case 1:
          System.out.println("Ingrese la cantidad de llamadas a realizar a nuestro call center");
          int quatCalls = s.nextInt();
          callCenter.makeCall(quatCalls);
          break;
        case 2:
          callCenter.calls.printLog();
          break;
        case 3:
          callCenter.users.printLog();
          break;
        case 4:
          System.out.println("Bye bye");
          break;
          
        default:
          System.out.println("invalid option");
      }

    }

  }
} // Fin clase $(name)
