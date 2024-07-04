package com.michistore.ventas.dao.impl;

import com.michistore.ventas.dao.DaoVenta;
import com.michistore.ventas.entidades.Detalle;
import com.michistore.ventas.entidades.Venta;
import com.michistore.ventas.util.ConectaBD;
import com.michistore.ventas.util.Utilitario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DaoVentaImpl implements DaoVenta {

    private final ConectaBD CNX;
    private String message;

    public DaoVentaImpl() {
        CNX = ConectaBD.getInstance();
    }

    @Override
    public List<Venta> selectAll() {
        List<Venta> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("cliente,")
                .append("empleado,")
                .append("monto,")
                .append("fecha")
                .append(" FROM venta");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Venta venta = new Venta();
                venta.setId(rs.getInt(1));
                venta.setCliente(rs.getInt(2));
                venta.setEmpleado(rs.getInt(3));
                venta.setMonto(rs.getDouble(4));
                venta.setFecha(Utilitario.stringDateTime(rs.getString(5)));
                lista.add(venta);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return lista;
    }

    @Override
    public Venta selectOne(Integer id) {
        Venta venta = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("cliente,")
                .append("empleado,")
                .append("monto,")
                .append("fecha")
                .append(" FROM venta")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    venta = new Venta();
                    venta.setId(rs.getInt(1));
                    venta.setCliente(rs.getInt(2));
                    venta.setEmpleado(rs.getInt(3));
                    venta.setMonto(rs.getDouble(4));
                    venta.setFecha(LocalDateTime.parse(rs.getString(5)));
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }

        return venta;
    }

    @Override
    public String insert(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO venta(")
                .append("cliente,")
                .append("empleado,")
                .append("monto,")
                .append("fecha")
                .append(") VALUES (?,?,?,?)");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, venta.getCliente());
            ps.setInt(2, venta.getEmpleado());
            ps.setDouble(3, venta.getMonto());
            ps.setString(4, venta.getFecha().toString());
            message = (ps.executeUpdate() == 0) ? "No se agregó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String update(Venta venta) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE venta SET ")
                .append("dni = ?,")
                .append("cliente = ?,")
                .append("empleado = ?,")
                .append("monto = ?,")
                .append("fecha = ?")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, venta.getCliente());
            ps.setInt(2, venta.getEmpleado());
            ps.setDouble(3, venta.getMonto());
            ps.setString(4, venta.getFecha().toString());
            ps.setInt(5, venta.getId());
            message = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM venta ")
                .append("WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {

            ps.setInt(1, id);
            message = (ps.executeUpdate() == 0) ? "No se eliminó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public List<Detalle> getVentaDetalle(Integer id) {
        List<Detalle> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("venta,")
                .append("producto,")
                .append("precio,")
                .append("cantidad")
                .append(" FROM detalle")
                .append(" WHERE id = ?");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                lista = new ArrayList<>();
                while (rs.next()) {
                    Detalle detalle = new Detalle();
                    detalle.setId(rs.getInt(1));
                    detalle.setVenta(rs.getInt(2));
                    detalle.setProducto(rs.getInt(3));
                    detalle.setPrecio(rs.getDouble(4));
                    detalle.setCantidad(rs.getInt(5));
                    lista.add(detalle);
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return lista;
    }

    @Override
    public String getMessage() {
        return message;
    }
}