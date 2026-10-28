package modelo;

public class Libro implements Identificable{

    private int id;
    private String titulo;
    private String autor;
    private int anio;
    private boolean disponible;

    public Libro(int id, String titulo, String autor, int anio, boolean disponible) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.disponible = disponible;
    }


    public String getId() {
        return String.valueOf(id);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anio=" + anio +
                ", disponible=" + disponible +
                '}';
    }
}
