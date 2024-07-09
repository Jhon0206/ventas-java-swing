package com.michistore.ventas.util;

import com.michistore.ventas.entidades.Empleado;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Utilitario {

    public static Empleado empleado;

    public static ResourceBundle bundle = ResourceBundle.getBundle("bundles/text");

    public static LocalDateTime stringDateTime(String fecha) {
        return LocalDateTime.parse(fecha,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static void noRowSelectedMessage() {
        JOptionPane.showMessageDialog(null,
                Utilitario.bundle.getString("message.select"),
                Utilitario.bundle.getString("message.warning"),
                JOptionPane.WARNING_MESSAGE);
    }
    
    public static void errorMessage(String message){
        JOptionPane.showMessageDialog(null,
                message,Utilitario.bundle.getString("message.error"),
                JOptionPane.WARNING_MESSAGE);    
    }
    
    public static Integer getIdOfTable(int row, JTable table){
        return Integer.valueOf(table.getValueAt(row, 0).toString());
    }
}
