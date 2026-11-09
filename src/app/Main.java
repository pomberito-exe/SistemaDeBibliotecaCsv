package app;

import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;
import persistencia.*;
import vista.Menu;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args){

        RepositorioCsv<Libro> repositorioLibros = new LibroRepositorio(Path.of(("C:/Juan/personal//SistemaBibliotecaCsv/Datos/libros.csv")));
        RepositorioCsv<Usuario> repositorioUsuarios = new UsuarioRepositorio(Path.of("C:/Juan/personal//SistemaBibliotecaCsv/Datos/usuarios.csv"));
        RepositorioCsv<Prestamo> repositorioPrestamo = new PrestamoRepositorio(Path.of("C:/Juan/personal//SistemaBibliotecaCsv/Datos/prestamos.csv"));

        repositorioLibros.mostrarLista();
        repositorioUsuarios.mostrarLista();
        repositorioPrestamo.mostrarLista();

        while(true){
            Menu.mostrarMenu();
        }



    }

}