package vista;

import servicio.Biblioteca;

import java.util.Scanner;

public class Menu {

    private static Biblioteca biblioteca = new Biblioteca();

    private static Scanner sc = new Scanner(System.in);
    private static final int CANT_MENU_1 = 3;
    private static final int CANT_MENU_LIBROS = 3;
    private static final int CANT_MENU_USUARIOS = 3;
    private static final int CANT_MENU_PRESTAMOS = 3;

    public static void mostrarMenu(){
        System.out.println("MENU");
        System.out.println("1. Menu libros");
        System.out.println("2. Menu  usuarios");
        System.out.println("3. Menu préstamos");

        int cantidadOpcionMenu2 = 0;
        String menu2Elegido = "";

        switch(elegirOpcion(1, CANT_MENU_1)){

            case 1:
                System.out.println("MENU LIBROS");
                System.out.println("1. Cargar libro");
                System.out.println("2. Listar libros");
                System.out.println("3. Listar libros disponibles");
                cantidadOpcionMenu2 = CANT_MENU_LIBROS;
                menu2Elegido = "LIBROS";
                break;

            case 2:
                System.out.println("MENU USUARIOS");
                System.out.println("1. Cargar libro");
                System.out.println("2. Listar usuarios");
                System.out.println("3. Listar libros disponibles");
                cantidadOpcionMenu2 = CANT_MENU_USUARIOS;
                menu2Elegido = "USUARIOS";
                break;

            case 3:
                System.out.println("MENU PRESTAMOS");
                System.out.println("1. Cargar libro");
                System.out.println("2. Listar prestamos");
                System.out.println("3. Listar libros disponibles");
                cantidadOpcionMenu2 = CANT_MENU_PRESTAMOS;
                menu2Elegido = "PRESTAMOS";
                break;
        }

        int opcionMenu2 =  elegirOpcion(1, cantidadOpcionMenu2);

        switch (menu2Elegido){
            case "LIBROS":
                switch (opcionMenu2){
                    case 1:
                        System.out.println("Creando libro...");
                        break;
                    case 2:
                        System.out.println("Listando libros...");
                        biblioteca.mostrarListado(menu2Elegido);
                        break;
                    case 3:
                        System.out.println("Listando libros disponibles...");
                        break;
                }
                break;
            case "USUARIOS":
                switch (opcionMenu2) {
                    case 2:
                        System.out.println("Listando usuarios...");
                        biblioteca.mostrarListado(menu2Elegido);
                        break;
                }
                break;
            case "PRESTAMOS":
                switch (opcionMenu2) {
                    case 2:
                        System.out.println("Listando prestamos...");
                        biblioteca.mostrarListado(menu2Elegido);
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("Error General del Menu");

        }

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
