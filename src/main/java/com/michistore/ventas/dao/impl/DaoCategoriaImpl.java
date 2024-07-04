package com.michistore.ventas.dao.impl;

import com.michistore.ventas.dao.DaoCategoria;
import com.michistore.ventas.entidades.Categoria;
import com.michistore.ventas.util.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoriaImpl implements DaoCategoria {

    private final ConectaBD CNX;
    private String message;

    public DaoCategoriaImpl() {
        CNX = ConectaBD.getInstance();
    }

    @Override
    public List<Categoria> selectAll() {
        List<Categoria> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion")
                .append(" FROM categoria");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt(1));
                categoria.setNombre(rs.getString(2));
                categoria.setDescripcion(rs.getString(3));
                lista.add(categoria);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return lista;
    }

    @Override
    public Categoria selectOne(Integer id) {
        Categoria categoria = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("nombre,")
                .append("descripcion")
                .append(" FROM categoria")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt(1));
                    categoria.setNombre(rs.getString(2));
                    categoria.setDescripcion(rs.getString(3));
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return categoria;
    }

    @Override
    public String insert(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO categoria(")
                .append("nombre,")
                .append("descripcion")
                .append(") VALUES (?,?)");
        try (Connection c = CNX.getConexion();PreparedStatement ps = c.prepareStatement(sql.toString());) {            
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            message = (ps.executeUpdate() == 0) ? "No se agregó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String update(Categoria categoria) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE categoria SET ")
                .append("nombre = ?,")
                .append("descripcion = ?")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion();PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, categoria.getNombre());
            ps.setString(2, categoria.getDescripcion());
            ps.setInt(3, categoria.getId());
            message = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM categoria ")
                .append("WHERE id = ?");
        try (Connection c = CNX.getConexion();PreparedStatement ps = c.prepareStatement(sql.toString());) {
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
