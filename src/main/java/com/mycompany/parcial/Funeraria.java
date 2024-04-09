package com.mycompany.parcial;

import java.util.Scanner;
import java.util.Stack;

public class Funeraria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> valores = new Stack<>();

        String menu = "1. Bóveda\n2. Terreno\n3. Osario\n4. Salir";

        int opcion;
        do {
            System.out.println(menu);
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    valores.push(4000000);
                    break;
                case 2:
                    valores.push(8000000);
                    break;
                case 3:
                    valores.push(1500000);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opción equivocada");
                    break;
            }
        } while (opcion != 4);

        int totalBovedas = 0;
        int granTotal = 0;
        while (!valores.empty()) {
            int valor = valores.pop();
            if (valor == 4000000) {
                totalBovedas += valor;
            }
            granTotal += valor;
        }

        System.out.println("El total de valores de bóvedas es: " + totalBovedas);
        System.out.println("El gran total de todas las propiedades es: " + granTotal);
    }
}
