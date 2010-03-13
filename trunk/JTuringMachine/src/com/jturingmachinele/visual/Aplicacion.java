/*
 * @(#)Aplicacion.java	1.0 04/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.visual;

import com.jturingmachinele.graphics.ObjetoGrafico;
import com.jturingmachinele.graphics.estados.Estado;
import com.jturingmachinele.graphics.estados.EstadoInicial;
import com.jturingmachinele.graphics.estados.EstadoTransitivo;
import com.jturingmachinele.graphics.transiciones.Transicion;
import com.jturingmachinele.graphics.transiciones.TransicionArco;
import com.jturingmachinele.graphics.transiciones.TransicionRecta;
import com.jturingmachinele.persistencia.PersistirXML;
import com.jturingmachinele.util.ExtencionArchivo;
import com.jturingmachinele.visual.componentes.Lienzo;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * JFrame que representa la interfaz para la aplicación jTuringMachine.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class Aplicacion extends javax.swing.JFrame {

    private Lienzo lienzo = null;
    private JScrollPane scroll = null;
    private JFileChooser selector = null;
    private File archivo = null;
    private int apariencia;
    private boolean openFile = false;

    public static final int LINUX = 0;
    public static final int WINDOWS = 1;
    public static final int SOLARIS = 2;

    /** Creates new form Aplicacion */
    public Aplicacion() {
            lienzo = new Lienzo();
            lienzo.setVisible(false);
            //lienzo.setObjetoGrafico(EstadoInicial.getInstancia(new Point(250, 250), "q1"));
            EstadoTransitivo et = new EstadoTransitivo(new Point(300,150),"q2");
            lienzo.setObjetoGrafico(et);
//            lienzo.setObjetoGrafico(new TransicionArco(EstadoInicial.getInstancia(),et,"aDx"));
//            lienzo.setObjetoGrafico(new TransicionRecta(EstadoInicial.getInstancia(),et,"aDx"));
            initComponents();
            setVisible(true);
            configurarGUI();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoApariencias = new javax.swing.ButtonGroup();
        pnlNorte = new javax.swing.JPanel();
        pnlSur = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemNuevoArchivo = new javax.swing.JMenuItem();
        itemAbrirArchivo = new javax.swing.JMenuItem();
        itemGuardarArchivo = new javax.swing.JMenuItem();
        itemCerrarArchivo = new javax.swing.JMenuItem();
        separador1 = new javax.swing.JSeparator();
        itemSalir = new javax.swing.JMenuItem();
        menuEdicion = new javax.swing.JMenu();
        itemDeshacer = new javax.swing.JMenuItem();
        itemRehacer = new javax.swing.JMenuItem();
        menuHerramientas = new javax.swing.JMenu();
        menuApariencias = new javax.swing.JMenu();
        rdioMenuLinux = new javax.swing.JRadioButtonMenuItem();
        rdioMenuWindows = new javax.swing.JRadioButtonMenuItem();
        rdioMenuSolaris = new javax.swing.JRadioButtonMenuItem();
        rdioMenuMetal = new javax.swing.JRadioButtonMenuItem();
        menuAyuda = new javax.swing.JMenu();
        itemAyuda = new javax.swing.JMenuItem();
        itemAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("{:::jTuringMachine | Ornitorrinco:::}");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout pnlNorteLayout = new javax.swing.GroupLayout(pnlNorte);
        pnlNorte.setLayout(pnlNorteLayout);
        pnlNorteLayout.setHorizontalGroup(
            pnlNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
        );
        pnlNorteLayout.setVerticalGroup(
            pnlNorteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout pnlSurLayout = new javax.swing.GroupLayout(pnlSur);
        pnlSur.setLayout(pnlSurLayout);
        pnlSurLayout.setHorizontalGroup(
            pnlSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 947, Short.MAX_VALUE)
        );
        pnlSurLayout.setVerticalGroup(
            pnlSurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(pnlSur, java.awt.BorderLayout.PAGE_END);

        pnlPrincipal.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        menuArchivo.setMnemonic('A');
        menuArchivo.setText("Archivo");

        itemNuevoArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNuevoArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/page.png"))); // NOI18N
        itemNuevoArchivo.setMnemonic('N');
        itemNuevoArchivo.setText("Nuevo archivo");
        itemNuevoArchivo.setToolTipText("Limpia el lienzo para poder dibujar una nueva máquina.");
        itemNuevoArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemNuevoArchivo);

        itemAbrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemAbrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/page_add.png"))); // NOI18N
        itemAbrirArchivo.setMnemonic('A');
        itemAbrirArchivo.setText("Abrir archivo");
        itemAbrirArchivo.setToolTipText("Abre un archivo .jtmx en la extención especificada.");
        itemAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemAbrirArchivo);

        itemGuardarArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        itemGuardarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/page_save.png"))); // NOI18N
        itemGuardarArchivo.setMnemonic('G');
        itemGuardarArchivo.setText("Guardar archivo");
        itemGuardarArchivo.setToolTipText("Guarda un archivo con extensión .jtmx con la máquina de Turing en la ruta especificada.");
        itemGuardarArchivo.setEnabled(false);
        itemGuardarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemGuardarArchivo);

        itemCerrarArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        itemCerrarArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/page_delete.png"))); // NOI18N
        itemCerrarArchivo.setMnemonic('C');
        itemCerrarArchivo.setText("Cerrar archivo");
        itemCerrarArchivo.setToolTipText("Cierra el archivo.");
        itemCerrarArchivo.setEnabled(false);
        itemCerrarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarArchivoActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrarArchivo);
        menuArchivo.add(separador1);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/application_form_delete.png"))); // NOI18N
        itemSalir.setMnemonic('S');
        itemSalir.setText("Salir");
        itemSalir.setToolTipText("Sale de la aplicación.");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        barraMenu.add(menuArchivo);

        menuEdicion.setMnemonic('E');
        menuEdicion.setText("Edición");

        itemDeshacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        itemDeshacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/arrow_undo.png"))); // NOI18N
        itemDeshacer.setMnemonic('D');
        itemDeshacer.setText("Deshacer");
        itemDeshacer.setToolTipText("Regresa el lienzo a su estado anterior inmediato.");
        itemDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeshacerActionPerformed(evt);
            }
        });
        menuEdicion.add(itemDeshacer);

        itemRehacer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        itemRehacer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/arrow_redo.png"))); // NOI18N
        itemRehacer.setMnemonic('R');
        itemRehacer.setText("Rehacer");
        itemRehacer.setToolTipText("Regresa el lienzo a su estado siguiente inmediato.");
        itemRehacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRehacerActionPerformed(evt);
            }
        });
        menuEdicion.add(itemRehacer);

        barraMenu.add(menuEdicion);

        menuHerramientas.setMnemonic('H');
        menuHerramientas.setText("Herramientas");

        menuApariencias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/application_view_tile.png"))); // NOI18N
        menuApariencias.setMnemonic('p');
        menuApariencias.setText("Apariencias");
        menuApariencias.setToolTipText("Cambia las apariencias dependiendo del sistema operativo.");

        btnGrupoApariencias.add(rdioMenuLinux);
        rdioMenuLinux.setMnemonic('L');
        rdioMenuLinux.setText("Linux");
        rdioMenuLinux.setToolTipText("Cambia la apariencia a Linux, siempre y cuando esté disponible.");
        rdioMenuLinux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/tux.png"))); // NOI18N
        rdioMenuLinux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioMenuLinuxActionPerformed(evt);
            }
        });
        menuApariencias.add(rdioMenuLinux);

        btnGrupoApariencias.add(rdioMenuWindows);
        rdioMenuWindows.setMnemonic('W');
        rdioMenuWindows.setText("Windows");
        rdioMenuWindows.setToolTipText("Cambia la apariencia a Windows, siempre y cuando esté disponible.");
        rdioMenuWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/bricks.png"))); // NOI18N
        rdioMenuWindows.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioMenuWindowsActionPerformed(evt);
            }
        });
        menuApariencias.add(rdioMenuWindows);

        btnGrupoApariencias.add(rdioMenuSolaris);
        rdioMenuSolaris.setMnemonic('S');
        rdioMenuSolaris.setText("Solaris");
        rdioMenuSolaris.setToolTipText("Cambia la apariencia a Sun Solaris, siempre y cuando esté disponible.");
        rdioMenuSolaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/weather_sun.png"))); // NOI18N
        rdioMenuSolaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioMenuSolarisActionPerformed(evt);
            }
        });
        menuApariencias.add(rdioMenuSolaris);

        btnGrupoApariencias.add(rdioMenuMetal);
        rdioMenuMetal.setMnemonic('M');
        rdioMenuMetal.setSelected(true);
        rdioMenuMetal.setText("Metal");
        rdioMenuMetal.setToolTipText("Cambia la apariencia a la default de la JVM.");
        rdioMenuMetal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/control_repeat.png"))); // NOI18N
        rdioMenuMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdioMenuMetalActionPerformed(evt);
            }
        });
        menuApariencias.add(rdioMenuMetal);

        menuHerramientas.add(menuApariencias);

        barraMenu.add(menuHerramientas);

        menuAyuda.setMnemonic('y');
        menuAyuda.setText("Ayuda");

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        itemAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/help.png"))); // NOI18N
        itemAyuda.setMnemonic('C');
        itemAyuda.setText("Contenido de ayuda");
        itemAyuda.setToolTipText("Muestra el contenido de ayuda de la aplicación.");
        menuAyuda.add(itemAyuda);

        itemAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        itemAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/award_star_bronze_2.png"))); // NOI18N
        itemAcercaDe.setMnemonic('A');
        itemAcercaDe.setText("Acerca de...");
        itemAcercaDe.setToolTipText("Muestra información general de la aplicación.");
        itemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAcercaDeActionPerformed(evt);
            }
        });
        menuAyuda.add(itemAcercaDe);

        barraMenu.add(menuAyuda);

        setJMenuBar(barraMenu);

        getAccessibleContext().setAccessibleName("jTuringMachine | Ornitorrinco");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirArchivoActionPerformed
        selector = new JFileChooser();
        selector.addChoosableFileFilter(new ExtencionArchivo());
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(selector.showOpenDialog(this) != JFileChooser.CANCEL_OPTION){
            archivo = selector.getSelectedFile();
            setTitle(String.format("%s - {:::jTuringMachine | Ornitorrinco:::}",
                                   archivo.getName()));
            lienzo.setObjetosGraficos(PersistirXML.abrir(archivo));
            itemCerrarArchivo.setEnabled(true);
            openFile = true;
            lienzo.setEnabled(true);
            lienzo.setVisible(true);
        }
        selector = null;
        archivo = null;
    }//GEN-LAST:event_itemAbrirArchivoActionPerformed

    private void itemGuardarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarArchivoActionPerformed
        selector = new JFileChooser();
        selector.addChoosableFileFilter(new ExtencionArchivo());
        selector.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if(selector.showSaveDialog(this) != JFileChooser.CANCEL_OPTION){
            if(selector.getSelectedFile().getName().lastIndexOf(".")==-1){
                archivo = new File(selector.getSelectedFile().getAbsolutePath()+".jtmx");
            }else{
                archivo = selector.getSelectedFile();
            }
            if(PersistirXML.guardar(archivo, lienzo.getObjetosGraficos())){
                JOptionPane.showMessageDialog(this,
                                              "El archivo ha sido guardado con éxito.",
                                              "jTuringMachine",
                                              JOptionPane.INFORMATION_MESSAGE);
                itemCerrarArchivo.setEnabled(true);
                openFile = true;
                setTitle(String.format("%s - {:::jTuringMachine | Ornitorrinco:::}",
                                       archivo.getName()));
            }else{
                JOptionPane.showMessageDialog(this,
                                              "El archivo ha sido guardado con éxito.",
                                              "jTuringMachine",
                                              JOptionPane.ERROR_MESSAGE);
            }
        }
        selector = null;
        archivo = null;
    }//GEN-LAST:event_itemGuardarArchivoActionPerformed

    private void itemCerrarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarArchivoActionPerformed
        if(openFile && JOptionPane.showConfirmDialog(this,
                                                     "¿Está seguro que desea salir de la aplicación?",
                                                     "jTuringMachine",
                                                     JOptionPane.YES_NO_CANCEL_OPTION,
                                                     JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            lienzo.limpiar();
            lienzo.setEnabled(false);
            lienzo.setVisible(false);
            openFile = false;
            itemCerrarArchivo.setEnabled(false);
            setTitle("{:::jTuringMachine | Ornitorrinco:::}");
        }
    }//GEN-LAST:event_itemCerrarArchivoActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        if(JOptionPane.showConfirmDialog(this, 
                                         "¿Está seguro que desea salir de la aplicación?",
                                         "jTuringMachine",
                                         JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeshacerActionPerformed
        lienzo.deshacer();
    }//GEN-LAST:event_itemDeshacerActionPerformed

    private void itemRehacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRehacerActionPerformed
        lienzo.rehacer();
    }//GEN-LAST:event_itemRehacerActionPerformed

    private void rdioMenuLinuxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioMenuLinuxActionPerformed
        try {
            setApariencia(LINUX);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Apariencia no disponible en este sistema operatívo.",
                                          "jTuringMachine", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rdioMenuLinuxActionPerformed

    private void rdioMenuWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioMenuWindowsActionPerformed
        try {
            setApariencia(WINDOWS);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(this, "Apariencia no disponible en este sistema operatívo.",
                                          "jTuringMachine", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Apariencia no disponible en este sistema operatívo.",
                                          "jTuringMachine", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rdioMenuWindowsActionPerformed

    private void rdioMenuSolarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioMenuSolarisActionPerformed
        try {
            setApariencia(SOLARIS);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Apariencia no disponible en este sistema operatívo.",
                                          "jTuringMachine", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_rdioMenuSolarisActionPerformed

    private void rdioMenuMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdioMenuMetalActionPerformed
        try {
            setApariencia(-1);
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_rdioMenuMetalActionPerformed

    private void itemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAcercaDeActionPerformed
        AcercaDe acercaDe = new AcercaDe(this, true);
        acercaDe.setVisible(true);
    }//GEN-LAST:event_itemAcercaDeActionPerformed

    private void itemNuevoArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoArchivoActionPerformed
        lienzo.limpiar();
        lienzo.setEnabled(true);
        lienzo.setVisible(true);
        EstadoTransitivo et = new EstadoTransitivo(new Point(300,150),"q2");
        lienzo.setObjetoGrafico(et);
        TransicionArco tranArc = new TransicionArco(EstadoInicial.getInstancia(),et,"aDx");
        TransicionArco tranArcR = new TransicionArco(et,EstadoInicial.getInstancia(),"aIy");
        tranArc.setRetorno(definirRetorno(tranArc));
        lienzo.setObjetoGrafico(tranArc);
        tranArcR.setRetorno(definirRetorno(tranArcR));
        lienzo.setObjetoGrafico(tranArcR);
    }//GEN-LAST:event_itemNuevoArchivoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir de la aplicación?",
                                         "jTuringMachine", JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Define si una transición esta retornando de un estado al que ya ha llegado
     * otra transición y va hacia el mismo estado de donde salió la anterior.
     * @param transicion Objeto de tipo <code>Transicion</code>
     */
    private boolean definirRetorno(Transicion transicion){
        boolean retorno = false;
        ArrayList<ObjetoGrafico> objects = lienzo.getObjetosGraficos();
        for(ObjetoGrafico e: objects){            
            if(e.getClass().getSuperclass().equals(Transicion.class))
            {
                Transicion tran = (Transicion)e;
                if(transicion.getNodoFinal().equals(tran.getNodoInicial())){
                    retorno = true;
                    break;
                }                
            }
            else{
                    retorno = false;
                }
        }
        return retorno;
    }

    private void lienzoMouseReleased(java.awt.event.MouseEvent evt){
        for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
            if(obj.getClass().getName().contains("Estado")){
                Estado est = (Estado) obj;
                est.setMoving(false);
            }
        }
    }

    private void lienzoMouseDragged(java.awt.event.MouseEvent evt){
        if(evt.isMetaDown()){
            for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
                if(obj.getClass().getName().contains("Estado")){
                    Estado est = (Estado) obj;
                    if(!est.isFlotando(evt.getX(), evt.getY()) && !est.isMoving()){
                        est.setMoving(false);
                    }else if(est.isFlotando(evt.getX(), evt.getY()) || est.isMoving()){
                        est.setMoving(true);
                        Point posicion = new Point(evt.getX() - Estado.RADIO,
                                                   evt.getY() - Estado.RADIO);
                        est.setCoordenadaXY(posicion);
                        lienzo.repaint();
                    }
                }                
            }
        }
    }

    private void lienzoMouseMoved(java.awt.event.MouseEvent evt){
        for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
            if(obj.getClass().getName().contains("Estado")){
                Estado est = (Estado) obj;
                if(est.isFlotando(evt.getX(), evt.getY()) && !est.isExitado()){
                    est.exitar();
                    est.setExitado(true);
                }else if(!est.isFlotando(evt.getX(), evt.getY()) && est.isExitado()){
                    est.desexitar();
                    est.setExitado(false);
                }
                lienzo.repaint();                
            }
        }
    }
    /**
    * @param args the command line arguments
    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Aplicacion().setVisible(true);
//            }
//        });
//    }

    private void configurarGUI(){
        scroll = new JScrollPane(lienzo,
                                 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnlPrincipal.add(scroll);
        setPreferredSize(new Dimension(1066,800));
        setSize(new Dimension(1066,800));

        //Evento de arrastrar del lienzo
        lienzo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lienzoMouseReleased(evt);
            }
        });

        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter(){
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lienzoMouseDragged(evt);
            }
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lienzoMouseMoved(evt);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.ButtonGroup btnGrupoApariencias;
    private javax.swing.JMenuItem itemAbrirArchivo;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenuItem itemCerrarArchivo;
    private javax.swing.JMenuItem itemDeshacer;
    private javax.swing.JMenuItem itemGuardarArchivo;
    private javax.swing.JMenuItem itemNuevoArchivo;
    private javax.swing.JMenuItem itemRehacer;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu menuApariencias;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JMenu menuHerramientas;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JRadioButtonMenuItem rdioMenuLinux;
    private javax.swing.JRadioButtonMenuItem rdioMenuMetal;
    private javax.swing.JRadioButtonMenuItem rdioMenuSolaris;
    private javax.swing.JRadioButtonMenuItem rdioMenuWindows;
    private javax.swing.JSeparator separador1;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the apariencia
     */
    public int getApariencia() {
        return apariencia;
    }

    /**
     * @param apariencia the apariencia to set
     */
    public void setApariencia(int apariencia) throws InstantiationException,
                                                     IllegalAccessException,
                                                     UnsupportedLookAndFeelException,
                                                     ClassNotFoundException {
        switch(apariencia){
            case LINUX : {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            }break;
            case WINDOWS : {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }break;
            case SOLARIS : {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }break;
            default : {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            };
        }
        SwingUtilities.updateComponentTreeUI(this);
        this.apariencia = apariencia;
    }
}
