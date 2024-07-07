/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.michistore.ventas.controller.validator;

import com.michistore.ventas.view.LoginFrame;
import com.michistore.ventas.view.MainFrame;

/**
 *
 * @author jhon_
 */
public class LoginValidator {
    
    public void login(LoginFrame loginFrame, MainFrame mainFrame){
        loginFrame.setVisible(false);
        loginFrame.txtPass.setText(null);        
        mainFrame.setVisible(true);
    }

    public void logout(LoginFrame loginFrame, MainFrame mainFrame) {
        mainFrame.setVisible(false);      
        loginFrame.setVisible(true);
    }
}
