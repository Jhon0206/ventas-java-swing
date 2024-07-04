package com.michistore.ventas.dao;

import java.util.List;
/**
 * 
 * @author jhon
 * @param <T> Clase que representa la entidad
 * @param <ID> El tipo de la clave o identificador
 */
public interface DaoInterface<T,ID> {
    List<T> selectAll();
    T selectOne(ID id);
    String insert(T categoria);
    String update(T categoria);
    String delete(ID id);
    String getMessage();
}
