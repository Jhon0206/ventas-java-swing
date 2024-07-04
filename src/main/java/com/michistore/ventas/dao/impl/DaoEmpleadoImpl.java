package com.michistore.ventas.dao.impl;

import com.michistore.ventas.dao.DaoEmpleado;
import com.michistore.ventas.entidades.Empleado;
import com.michistore.ventas.util.ConectaBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpleadoImpl implements DaoEmpleado {

    private final ConectaBD CNX;
    private String message;

    public DaoEmpleadoImpl() {
        CNX = ConectaBD.getInstance();
    }

    @Override
    public List<Empleado> selectAll() {
        List<Empleado> lista = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("correo,")
                .append("telefono")
                .append(" FROM empleado");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString()); ResultSet rs = ps.executeQuery();) {

            lista = new ArrayList<>();
            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt(1));
                empleado.setDni(rs.getString(2));
                empleado.setNombres(rs.getString(3));
                empleado.setPaterno(rs.getString(4));
                empleado.setMaterno(rs.getString(5));
                empleado.setCorreo(rs.getString(6));
                lista.add(empleado);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }

        return lista;
    }

    @Override
    public Empleado selectOne(Integer id) {
        Empleado empleado = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("correo,")
                .append("telefono")
                .append(" FROM empleado")
                .append(" WHERE id = ?");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setId(rs.getInt(1));
                    empleado.setDni(rs.getString(2));
                    empleado.setNombres(rs.getString(3));
                    empleado.setPaterno(rs.getString(4));
                    empleado.setMaterno(rs.getString(5));
                    empleado.setCorreo(rs.getString(6));
                    empleado.setTelefono(rs.getString(7));
                }
            } catch (Exception e) {
                message = e.getMessage();
            }

        } catch (Exception e) {
            message = e.getMessage();
        }

        return empleado;
    }

    @Override
    public String insert(Empleado empleado) {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO empleado(")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("correo,")
                .append("telefono")
                .append(") VALUES (?,?,?,?,?,?)");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getPaterno());
            ps.setString(4, empleado.getMaterno());
            ps.setString(5, empleado.getCorreo());
            ps.setString(6, empleado.getTelefono());
            message = (ps.executeUpdate() == 0) ? "No se agregó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String update(Empleado empleado) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE empleado SET ")
                .append("dni = ?,")
                .append("nombres = ?,")
                .append("paterno = ?,")
                .append("materno = ?,")
                .append("correo = ?,")
                .append("telefono = ?")
                .append(" WHERE id = ?");
        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, empleado.getDni());
            ps.setString(2, empleado.getNombres());
            ps.setString(3, empleado.getPaterno());
            ps.setString(4, empleado.getMaterno());
            ps.setString(5, empleado.getCorreo());
            ps.setString(6, empleado.getTelefono());
            ps.setInt(7, empleado.getId());
            message = (ps.executeUpdate() == 0) ? "No se actualizó" : null;
        } catch (Exception e) {
            message = e.getMessage();
        }
        return message;
    }

    @Override
    public String delete(Integer id) {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM empleado ")
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
    public Empleado login(String user, String pass) {
        Empleado empleado = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT ")
                .append("id,")
                .append("dni,")
                .append("nombres,")
                .append("paterno,")
                .append("materno,")
                .append("correo,")
                .append("telefono")
                .append(" FROM empleado")
                .append(" WHERE correo = ?")
                .append(" AND AES_DECRYPT(clave, ?) = ?");

        try (Connection c = CNX.getConexion(); PreparedStatement ps = c.prepareStatement(sql.toString());) {
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, pass);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setId(rs.getInt(1));
                    empleado.setDni(rs.getString(2));
                    empleado.setNombres(rs.getString(3));
                    empleado.setPaterno(rs.getString(4));
                    empleado.setMaterno(rs.getString(5));
                    empleado.setCorreo(rs.getString(6));
                } else {
                    message = "Credenciales inválidas";
                }
            } catch (Exception e) {
                message = e.getMessage();
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        return empleado;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
