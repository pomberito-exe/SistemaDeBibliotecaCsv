package vista;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println("MENU");
        System.out.println("1. Listar libros");
        System.out.println("2. Listar  usuarios");
        System.out.println("3. Listar préstamos");
    }

    public static int elegirOpcion(int inicio, int fin){
        while(!sc.hasNextInt()){
            sc.next();
            System.out.println("Solo se admiten numeros");
        }
        int opcion = sc.nextInt();
        while(opcion < inicio || opcion > fin){
            System.out.println("Opcion fuera de rango");
            opcion = sc.nextInt();
        }
        return opcion;
    }
}
