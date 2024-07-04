package com.michistore.ventas.dao.impl;

import com.michistore.ventas.dao.DaoCliente;
import com.michistore.ventas.entidades.Cliente;
import com.michistore.ventas.util.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoClienteImpl implements DaoCliente {

    private final ConectaBD CNX;
    private String message;

    public DaoClienteImpl() {
        CNX = ConectaBD.getInstance();
    }

    @Override
    public List<Cliente> selectAll() {
        List<Cliente> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("apellidos,")
                .append("correo")
                .append(" FROM cliente");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {
            lista = new ArrayList<>();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombres(rs.getString(3));
                cliente.setApellidos(rs.getString(4));
                cliente.setCorreo(rs.getString(5));
                lista.add(cliente);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }

        return lista;
    }

    @Override
    public Cliente selectOne(Integer id) {
        Cliente cliente = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("apellidos,")
                .append("correo")
                .append(" FROM cliente")
                .append(" WHERE id = ?");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setId(rs.getInt(1));
                    cliente.setDni(rs.getString(2));
                    cliente.setNombres(rs.getString(3));
                    cliente.setApellidos(rs.getString(4));
                    cliente.setCorreo(rs.getString(5));
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return cliente;
    }

    @Override
    public String insert(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO cliente(")
                .append("dni,")
                .append("nombres,")
                .append("apellidos,")
                .append("correo")
                .append(") VALUES (?,?,?,?)");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            message = (ps.executeUpdate() == 0) ? "No se agregó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String update(Cliente cliente) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE cliente SET ")
                .append("dni = ?,")
                .append("nombres = ?,")
                .append("apellidos = ?,")
                .append("correo = ?")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, cliente.getDni());
            ps.setString(2, cliente.getNombres());
            ps.setString(3, cliente.getApellidos());
            ps.setString(4, cliente.getCorreo());
            ps.setInt(5, cliente.getId());
            message = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM cliente ")
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