package modelo;

import java.time.LocalDate;

public abstract class Usuario implements Identificable{

    private String nombreCompleto;
    private String dni;
    private int añoNacimiento;

    public String getId(){
        return dni;
    }

    public abstract int getMaxPrestamos();
    public abstract int getDiasPrestamo();

    public Usuario(String nombreCompleto, String dni, int añoNacimiento) {
        if(nombreCompleto == null || nombreCompleto.isBlank()){
            throw new IllegalArgumentException("Nombre no puede estar vacio");
        }
        if(dni == null || dni.isBlank()){
            throw new IllegalArgumentException("DNI no puede estar vacio");
        }
        if(añoNacimiento <= 1950 || añoNacimiento > LocalDate.now().getYear()-10){
            throw new IllegalArgumentException("DNI no puede estar vacio");
        }
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.añoNacimiento = añoNacimiento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
