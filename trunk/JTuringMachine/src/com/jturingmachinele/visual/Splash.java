/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Splash.java
 *
 * Created on 6/02/2010, 01:29:23 PM
 */

package com.jturingmachinele.visual;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author jsandoval
 */
public class Splash extends javax.swing.JFrame implements Runnable{

    /** Creates new form Splash */
    public Splash() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("jTuringMachine");
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/SplashJTM_Med.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Splash().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public void run() {
        try {
            this.setLocationRelativeTo(null); //coloca el splash al centro de la pantalla
            this.setVisible(true); //Hace visible el Splash
            Thread.sleep(3000); //Mantiene el Splash visible por 7 segundos
            this.dispose(); //Cierra el Splash
            Aplicacion app = new Aplicacion();
            app.setVisible(true);
            //app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (InterruptedException ex) {
            Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
