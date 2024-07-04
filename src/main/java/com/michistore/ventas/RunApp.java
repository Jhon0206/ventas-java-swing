package com.michistore.ventas;

import com.formdev.flatlaf.FlatLightLaf;
import com.michistore.ventas.view.LoginView;

/**
 *
 * @author Jhon https://github.com/Jhon0206
 * @version 1.0
 */
public class RunApp {

    public static void main(String[] args) {
        System.out.println("Iniciando...");
        FlatLightLaf.setup();
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }
}
