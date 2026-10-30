package modelo;

public class Estudiante extends Usuario{

    final static int MAX_LIBROS = 3;
    final static int MAX_DIAS = 7;

    public Estudiante(String nombreCompleto, String dni, String añoNacimiento) {
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
