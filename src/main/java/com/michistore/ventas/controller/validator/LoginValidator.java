package com.michistore.ventas.controller.validator;

import com.michistore.ventas.dao.DaoEmpleado;
import com.michistore.ventas.dao.impl.DaoEmpleadoImpl;
import com.michistore.ventas.util.Utilitario;
import com.michistore.ventas.view.LoginFrame;
import com.michistore.ventas.view.MainFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jhon_
 */
public class LoginValidator {

    private final DaoEmpleado daoEmpleado = new DaoEmpleadoImpl();

    public void login(LoginFrame loginFrame, MainFrame mainFrame) {
        try {
            String user = loginFrame.txtEmail.getText();
            String pass = String.valueOf(loginFrame.txtPass.getPassword());
            Utilitario.empleado = daoEmpleado.login(user, pass);
            if (Utilitario.empleado != null) {
                loginFrame.setVisible(false);
                loginFrame.txtPass.setText(null);
                mainFrame.setVisible(true);
                
            }
            else{
            JOptionPane.showMessageDialog(loginFrame,
                    Utilitario.bundle.getString("login.credentials"),
                    Utilitario.bundle.getString("message.warning"),
                     JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(loginFrame,
                    daoEmpleado.getMessage(),
                    Utilitario.bundle.getString("message.error"),
                     JOptionPane.ERROR_MESSAGE);
        }

    }

    public void logout(LoginFrame loginFrame, MainFrame mainFrame) {
        Utilitario.empleado = null;
        mainFrame.setVisible(false);
        loginFrame.setVisible(true);
    }
}
