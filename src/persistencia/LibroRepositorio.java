package persistencia;

import modelo.Libro;

import java.nio.file.Path;

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
}
