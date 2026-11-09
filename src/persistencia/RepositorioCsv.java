package persistencia;

import excepciones.PersistenciaException;
import modelo.Identificable;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioCsv <T extends Identificable> implements Repositorio<T> {

    private static final String SEPARADOR = ";";
    private final Path ruta;

    protected final List<T> elementos = new ArrayList<>();

    public RepositorioCsv(Path ruta) {
        this.ruta = ruta;
    }

    @Override
    public List<T> listar() {
        return List.of();
    }

    @Override
    public T buscarPorId(int id) {
        return null;
    }

    @Override
    public void guardar(T elemento) {

    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public void cargar(){

        elementos.clear();
        if(!Files.exists(ruta)){
            throw new PersistenciaException("Archivo no encontrado: " + ruta);
        }
        BufferedReader lector = null;

        try{
            lector = Files.newBufferedReader(ruta, StandardCharsets.UTF_8);
            lector.readLine();
            int numeroLinea = 1;
            String linea = lector.readLine();
            while(linea != null){
                numeroLinea++;
                if(!linea.isBlank()){
                    procesarLinea(linea, numeroLinea);
                }
                linea = lector.readLine();

            }
        }catch(IOException e){
            throw new PersistenciaException("No se pudo leer el archivo en: " + ruta + " Mas detalles: " + e.getMessage());
        } finally {
            cerrar(lector);
        }

    }

    private void procesarLinea(String linea, int numeroLinea) {
        try {
            T elemento = parsear(linea.split(RepositorioCsv.SEPARADOR, -1));
            elementos.add(elemento);
        } catch (IllegalArgumentException | DateTimeException | IndexOutOfBoundsException e) {
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    protected abstract T parsear(String[] campos);

    private void cerrar(Closeable recurso) {
        if(recurso != null){
            try{
                recurso.close();
            }catch(IOException e){
                throw new PersistenciaException("Problema al cerrar el recuros: " + e.getMessage());
            }
        }
    }

    public void mostrarLista(){
        for(T e: elementos){
            System.out.println(e);
        }
    }


}
