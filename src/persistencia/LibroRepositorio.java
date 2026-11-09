package persistencia;

import modelo.Libro;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LibroRepositorio extends RepositorioCsv<Libro>{

    public LibroRepositorio(Path ruta) {
        super(ruta);
        cargar();
    }

    @Override
    protected Libro parsear(String[] campos) {
        if(campos.length != 5){
            throw new IllegalArgumentException("Faltan campos para crear el libro");
        }
        return new Libro(Integer.parseInt(campos[0]),
                campos[1],
                campos[2],
                Integer.parseInt(campos[3]),
                Boolean.parseBoolean(campos[4]));
    }

    public List<Libro> obtenerLibrosDisponibles(){

        List<Libro> listaLibrosDisponibles = new ArrayList<>();

        for(Libro libro : elementos){
            if(libro.isDisponible()){
                listaLibrosDisponibles.add(libro);
            }
        }
        return listaLibrosDisponibles;
    }

}
