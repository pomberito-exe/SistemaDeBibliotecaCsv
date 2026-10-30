package persistencia;
import modelo.Prestamo;
import modelo.Usuario;

import java.nio.file.Path;
import java.time.LocalDate;

public class PrestamoRepositorio extends RepositorioCsv<Prestamo>{


    public PrestamoRepositorio(Path ruta) {
        super(ruta);
        cargar();
    }

    @Override
    protected Prestamo parsear(String[] campos) {
        if(campos.length != 5){
            throw new IllegalArgumentException("Faltan campos para crear el prestamo");
        }
        return new Prestamo(
                Integer.parseInt(campos[0].trim()),
                campos[1].trim(),
                campos[2].trim(),
                LocalDate.parse(campos[3].trim())
        );
    }
}
