package servicio;

import modelo.Libro;
import modelo.Prestamo;
import modelo.Usuario;
import persistencia.LibroRepositorio;
import persistencia.PrestamoRepositorio;
import persistencia.RepositorioCsv;
import persistencia.UsuarioRepositorio;

import java.nio.file.Path;
import java.util.ArrayList;

public class Biblioteca {

    private final Path rutaLibro = Path.of("C:/Juan/personal//SistemaBibliotecaCsv/Datos/libros.csv");
    private final Path rutaUsuario = Path.of("C:/Juan/personal//SistemaBibliotecaCsv/Datos/usuarios.csv");
    private final Path rutaPrestamo = Path.of("C:/Juan/personal//SistemaBibliotecaCsv/Datos/prestamos.csv");

    LibroRepositorio repositorioLibro;
    RepositorioCsv repositorioUsuario;
    RepositorioCsv repositorioPrestamo;

    public Biblioteca() {
        repositorioLibro = new LibroRepositorio(rutaLibro);
        repositorioUsuario = new UsuarioRepositorio(rutaUsuario);
        repositorioPrestamo = new PrestamoRepositorio(rutaPrestamo);
    }

    public void mostrarListado(String repoAMostrar){
        switch (repoAMostrar){
            case "LIBROS":
                repositorioLibro.mostrarLista();
                break;
            case "USUARIOS":
                repositorioUsuario.mostrarLista();
                break;
            case "PRESTAMOS":
                repositorioPrestamo.mostrarLista();
                break;
            default:
                throw new IllegalArgumentException("No se encuentra el listado solicitado: " + repoAMostrar);
        }

    }

    public void cargarElemento(Object elemento){
        if(elemento == null){
            throw new IllegalArgumentException("El elemento a guardar no puede estar vacío");
        }
        if(elemento instanceof Libro){
            repositorioLibro.guardar((Libro)elemento);
        } else if (elemento instanceof Usuario) {
            repositorioUsuario.guardar((Usuario)elemento);
        } else if (elemento instanceof Prestamo){
            repositorioPrestamo.guardar((Prestamo)elemento);
        } else {
            throw new IllegalArgumentException("Elemento inválido: " + elemento.getClass());
        }


    }

    public void mostrarLibrosDisponibles(){

        for(Libro libro : repositorioLibro.obtenerLibrosDisponibles()){
            System.out.println(libro);
        }
    }







}
