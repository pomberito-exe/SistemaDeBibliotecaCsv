package modelo;

import java.time.LocalDate;

public abstract class Usuario implements Identificable{

    private String nombreCompleto;
    private String dni;
    private String email;

    public String getId(){
        return dni;
    }

    public abstract int getMaxPrestamos();
    public abstract int getDiasPrestamo();

    public Usuario(String nombreCompleto, String dni, String email) {
        if(nombreCompleto == null || nombreCompleto.isBlank()){
            throw new IllegalArgumentException("Nombre no puede estar vacio");
        }
        if(dni == null || dni.isBlank()){
            throw new IllegalArgumentException("DNI no puede estar vacio");
        }
        if(email.isBlank()){
            throw new IllegalArgumentException("Email no puede estar vacio");
        }
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.email = email;
    }


    public static Usuario crear(String nombreCompleto, String dni, String email, String tipoUsuario){
        if(tipoUsuario == null){
            throw new IllegalArgumentException("Se debe indicar el tipo de usuario");
        }
        switch (tipoUsuario.toUpperCase().trim()){
            case "ESTUDIANTE":
                return new Estudiante(nombreCompleto, dni, email);
            case "DOCENTE":
                return new Docente(nombreCompleto, dni, email);
            default:
                throw new IllegalArgumentException("Tipo de usuario inválido " + tipoUsuario);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
