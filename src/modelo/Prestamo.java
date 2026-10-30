package modelo;

import java.time.LocalDate;

public class Prestamo implements Identificable{

    public enum Estado {
        ACTIVO,
        DEVUELTO
    }

    private final int id;
    private final String libroId;
    private final String usuarioId;
    private final LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(int id, String libroId, String usuarioId, LocalDate fechaPrestamo) {
        if(id < 0) {
            throw new IllegalArgumentException("Id debe ser mayor o igual a cero");
        }
        if(usuarioId == null || usuarioId.isBlank()) {
            throw new IllegalArgumentException("Id del usuario inválido");
        }
        if(fechaPrestamo == null) {
            throw new IllegalArgumentException("La fecha de prestamo no puede estar vacía");
        }

        this.id = id;
        this.libroId = libroId;
        this.usuarioId = usuarioId;
        this.fechaPrestamo = fechaPrestamo;
    }


    public void devolver(LocalDate fechaDevolucion){
        if(getEstado() == Estado.DEVUELTO){
            throw new IllegalArgumentException("Prestamo: " + id + " ya fue devuelto");
        }
        if(fechaDevolucion == null){
            throw new IllegalArgumentException("La fecha de devolución no puede estar vacía");
        }
        if(fechaDevolucion.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de devolución no puede ser posterior al día de hoy");
        }
        setFechaDevolucion(fechaDevolucion);
    }

    public String getId() {
        return String.valueOf(id);
    }

    public String getLibroId() {
        return libroId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        if(fechaDevolucion.isBefore(fechaPrestamo)){
            throw new IllegalArgumentException("La fecha de devolución no puede ser anterior a la fecha de prestamo");
        }
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", libroId='" + libroId + '\'' +
                ", usuarioId='" + usuarioId + '\'' +
                ", fechaPrestamo=" + fechaPrestamo +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }

    public Estado getEstado(){
        return fechaDevolucion == null ? Estado.ACTIVO : Estado.DEVUELTO;
    }
}
