package persistencia;
import modelo.Libro;
import modelo.Usuario;

import java.nio.file.Path;

public class UsuarioRepositorio extends RepositorioCsv<Usuario>{


    public UsuarioRepositorio(Path ruta) {
        super(ruta);
        cargar();
    }

    @Override
    protected Usuario parsear(String[] campos) {
        if(campos.length != 4){
            throw new IllegalArgumentException("Faltan campos para crear el usuario");
        }
        return Usuario.crear(
                campos[2],
                campos[0],
                campos[3],
                campos[1]
        );
    }
}
