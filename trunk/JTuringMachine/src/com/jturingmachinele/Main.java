/*
 * @(#)Main.java	1.0 04/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele;

import com.jturingmachinele.visual.Aplicacion;

/**
 * Clase principal de la aplicación.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Aplicacion().setVisible(true);
            }
        });
   }
}
