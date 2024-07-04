package com.michistore.ventas.dao.impl;

import com.michistore.ventas.dao.DaoProducto;
import com.michistore.ventas.entidades.Producto;
import com.michistore.ventas.util.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoProductoImpl implements DaoProducto {

    private final ConectaBD CNX;
    private String message;

    public DaoProductoImpl() {
        CNX = ConectaBD.getInstance();
    }

    @Override
    public List<Producto> selectAll() {
        List<Producto> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("precio,")
                .append("descripcion,")
                .append("cantidad,")
                .append("categoria")
                .append(" FROM producto");

        try (Connection c = CNX.getConexion(); 
                PreparedStatement ps = c.prepareStatement(sql.toString()); 
                ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombres(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setDescripcion(rs.getString(4));
                producto.setCantidad(rs.getInt(5));
                producto.setCategoria(rs.getInt(6));
                lista.add(producto);
            }
            rs.close();
        } catch (Exception e) {
            message = e.getMessage();
        }

        return lista;
    }

    @Override
    public Producto selectOne(Integer id) {
        Producto producto = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("precio,")
                .append("descripcion,")
                .append("cantidad,")
                .append("categoria")
                .append(" FROM producto")
                .append(" WHERE id = ?");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    producto = new Producto();
                    producto.setId(rs.getInt(1));
                    producto.setNombres(rs.getString(2));
                    producto.setPrecio(rs.getDouble(3));
                    producto.setDescripcion(rs.getString(4));
                    producto.setCantidad(rs.getInt(5));
                    producto.setCategoria(rs.getInt(6));
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }

        return producto;
    }

    @Override
    public String insert(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO producto(")
                .append("nombre,")
                .append("precio,")
                .append("descripcion,")
                .append("cantidad,")
                .append("categoria")
                .append(") VALUES (?,?,?,?,?)");
        try (Connection c = CNX.getConexion();
                PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, producto.getNombres());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getCategoria());
            message = (ps.executeUpdate() == 0) ? "No se agregó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String update(Producto producto) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE producto SET ")
                .append("nombre = ?,")
                .append("precio = ?,")
                .append("descripcion = ?,")
                .append("cantidad = ?,")
                .append("categoria = ?")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, producto.getNombres());
            ps.setDouble(2, producto.getPrecio());
            ps.setString(3, producto.getDescripcion());
            ps.setInt(4, producto.getCantidad());
            ps.setInt(5, producto.getCategoria());
            ps.setInt(6, producto.getId());
            message = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM producto ")
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
    public String getMessage() {
        return message;
    }

}