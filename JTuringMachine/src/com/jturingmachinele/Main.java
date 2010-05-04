/*
 * @(#)Main.java	1.0 04/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele;

import com.jturingmachinele.visual.Splash;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Clase principal de la aplicación.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class Main {
    public static void main(String[] args){
        //JFrame.setDefaultLookAndFeelDecorated(true);
	//JDialog.setDefaultLookAndFeelDecorated(true);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
		new Thread(new Splash()).start();
            }
	});
   }
}
