package app;

import modelo.Libro;
import persistencia.LibroRepositorio;
import persistencia.Repositorio;
import persistencia.RepositorioCsv;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args){

        RepositorioCsv<Libro> repositorioLibros = new LibroRepositorio(Path.of(("C:/Juan/studies/CLASES JAVA/CLASES/EJERCICIOS/SistemaBibliotecaCsv/Datos/libros.csv")));

        repositorioLibros.mostrarLista();




    }
}