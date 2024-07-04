package com.michistore.ventas.dao;
import com.michistore.ventas.entidades.Empleado;

public interface DaoEmpleado  extends DaoInterface<Empleado, Integer>{
    Empleado login(String user, String pass);
}
