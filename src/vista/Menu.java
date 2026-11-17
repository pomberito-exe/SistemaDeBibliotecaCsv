package vista;

import modelo.Libro;
import servicio.Biblioteca;

import java.time.LocalDateTime;
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

        switch(solicitarInt(1, CANT_MENU_1)){

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

        int opcionMenu2 =  solicitarInt(1, cantidadOpcionMenu2);

        switch (menu2Elegido){
            case "LIBROS":
                switch (opcionMenu2){
                    case 1:
                        System.out.println("Creando libro...");
                        biblioteca.cargarElemento(solicitarLibro());
                        break;
                    case 2:
                        System.out.println("Listando libros...");
                        biblioteca.mostrarListado(menu2Elegido);
                        break;
                    case 3:
                        System.out.println("Listando libros disponibles...");
                        biblioteca.mostrarLibrosDisponibles();
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

    private static Libro solicitarLibro() {
        String titulo = inputTexto("Titulo: ");
        String autor = inputTexto("Autor: ");
        int anio = solicitarInt(1000, LocalDateTime.now().getYear(), "Anio: ");
        return null;
    }


    private static String inputTexto(String s) {

        sc.nextLine();
        String input;

        boolean respuestaCorrecta = true;

        do {

            if(respuestaCorrecta == false){
                System.out.println("Datos de texto no pueden ser menores a 2 ni estar en blanco");
            }

            System.out.println(s);
            input = sc.nextLine();

            respuestaCorrecta = !(input.isBlank()) || !(input.length() < 2);


        } while(respuestaCorrecta);

        return input;

    }


    public static int solicitarInt(int inicio, int fin){
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


    public static int solicitarInt(int inicio, int fin, String mensaje){

        System.out.println(mensaje);

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
