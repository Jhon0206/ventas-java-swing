package com.michistore.ventas.controller;

import com.formdev.flatlaf.FlatLightLaf;
import com.michistore.ventas.view.LoginFrame;
import com.michistore.ventas.view.MainFrame;
import com.michistore.ventas.controller.validator.LoginValidator;
import com.michistore.ventas.view.AccountFrame;
import com.michistore.ventas.view.CategoryFrame;
import com.michistore.ventas.view.CustomerFrame;
import com.michistore.ventas.view.HomeFrame;
import com.michistore.ventas.view.ProductFrame;
import com.michistore.ventas.view.SalesFrame;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class AppController {

    LoginFrame loginFrame;
    MainFrame mainFrame;
    LoginValidator loginValidator;
    CategoryFrame categoryFrame;
    CustomerFrame customerFrame;
    ProductFrame productFrame;
    HomeFrame homeFrame;
    SalesFrame salesFrame;
    AccountFrame accountFrame;

    public AppController() {
        FlatLightLaf.setup();
        loginFrame = new LoginFrame();
        mainFrame = new MainFrame();
        loginValidator = new LoginValidator();
        categoryFrame = new CategoryFrame();
        customerFrame = new CustomerFrame();
        productFrame = new ProductFrame();
        homeFrame = new HomeFrame();
        salesFrame = new SalesFrame();
        accountFrame = new AccountFrame();
    }

    public void initView() {
        loginFrame.setLocationRelativeTo(null);
        mainFrame.setLocationRelativeTo(null); //Centrado en pantalla
        loginFrame.setVisible(true);
        URL url = getClass().getResource("/img/logo.png");
        ImageIcon image = new ImageIcon(url);
        loginFrame.setIconImage(image.getImage());
        mainFrame.setIconImage(image.getImage());
        loginMethods();
        mainMethods();
    }

    private void loginMethods() {        
        loginFrame.btnClose.addActionListener(e -> System.exit(0));
        loginFrame.btnEnter.addActionListener(e -> loginValidator.login(loginFrame, mainFrame));
    }

    private void mainMethods() {
        putInternalFrame(homeFrame);
        putInternalFrame(categoryFrame);
        putInternalFrame(customerFrame);
        putInternalFrame(productFrame);
        putInternalFrame(salesFrame);
        putInternalFrame(accountFrame);
        showInternalFrame(homeFrame);
        mainFrame.menuItemCategoria.addActionListener(e -> showInternalFrame(categoryFrame));
        mainFrame.menuItemCliente.addActionListener(e -> showInternalFrame(customerFrame));
        mainFrame.menuItemProducto.addActionListener(e -> showInternalFrame(productFrame));
        mainFrame.menuItemNewSale.addActionListener(e -> showInternalFrame(salesFrame));
        mainFrame.menuItemCuenta.addActionListener(e -> showInternalFrame(accountFrame));
        mainFrame.menuItemSalir.addActionListener(e->loginValidator.logout(loginFrame, mainFrame));
    }

    private void putInternalFrame(JInternalFrame frame) {
        mainFrame.contenedor.add(frame);
        ((BasicInternalFrameUI) frame.getUI()).setNorthPane(null);
        frame.setBorder(null);
    }

    private void showInternalFrame(JInternalFrame frame) {
        frame.setVisible(true);
        frame.toFront();
    }

}
