package com.michistore.ventas.dao;
import com.michistore.ventas.entidades.Detalle;
import com.michistore.ventas.entidades.Venta;
import java.util.List;

public interface DaoVenta  extends DaoInterface<Venta, Integer>{
    /**
     * Devuelve los detalles de la venta según el ID de la venta
     * @param id clave primaria de la venta - foranea en la tabla detalles
     * @return Una lista con los registros de detalle venta
     */
    List<Detalle> getVentaDetalle(Integer id);
}
