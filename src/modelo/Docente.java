package modelo;

public class Docente extends Usuario{

    final static int MAX_LIBROS = 5;
    final static int MAX_DIAS = 15;

    public Docente(String nombreCompleto, String dni, String añoNacimiento) {
        super(nombreCompleto, dni, añoNacimiento);
    }

    @Override
    public int getMaxPrestamos() {
        return MAX_LIBROS;
    }

    @Override
    public int getDiasPrestamo() {
        return MAX_DIAS;
    }
}

