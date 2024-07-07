package com.michistore.ventas;

import com.michistore.ventas.controller.AppController;

/**
 *
 * @author Jhon https://github.com/Jhon0206
 * @version 1.0
 */
public class RunApp {

    public static void main(String[] args) {
        AppController controller = new AppController();
        controller.initView();
    }
}
