package persistencia;

import excepciones.PersistenciaException;
import modelo.Identificable;

import java.util.List;

public interface Repositorio<T extends Identificable> {

    public List<T> listar();
    public T buscarPorId(int id);
    public void guardar(T elemento);
    public void eliminar(int id);
    public void cargar() throws PersistenciaException;

}
