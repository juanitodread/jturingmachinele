/*
 * @(#)Aplicacion.java	1.0 04/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.visual;

import com.jturingmachinele.graphics.ObjetoGrafico;
import com.jturingmachinele.graphics.estados.Estado;
import com.jturingmachinele.graphics.estados.EstadoFinal;
import com.jturingmachinele.graphics.estados.EstadoInicial;
import com.jturingmachinele.graphics.estados.EstadoTransitivo;
import com.jturingmachinele.graphics.transiciones.Transicion;
import com.jturingmachinele.graphics.transiciones.TransicionArco;
import com.jturingmachinele.graphics.transiciones.TransicionCiclo;
import com.jturingmachinele.graphics.transiciones.TransicionRecta;
import com.jturingmachinele.persistencia.PersistirXML;
import com.jturingmachinele.util.ExtencionArchivo;
import com.jturingmachinele.visual.componentes.Lienzo;
import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

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
    private JPopupMenu popUp;
    private JMenuItem itmEliminar;
    private JMenu menuEstados;
    private int popUpX, popUpY;
    private String tipoTransicion;
    private DefaultTreeModel modelo;
    private DefaultMutableTreeNode padre;
    private JTree treeArbolObjetos;
    private JScrollPane scrollArbolObjetos = new JScrollPane();
    DefaultTreeCellRenderer render;

    public static final int LINUX = 0;
    public static final int WINDOWS = 1;
    public static final int SOLARIS = 2;

    /** Creates new form Aplicacion */
    public Aplicacion() {
            lienzo = new Lienzo();
            initComponents();
            //Icono Oficial de jTuringMachine
            this.setIconImage (new ImageIcon(getClass().getResource(
            "/com/jturingmachinele/visual/img/jTM_Logo.png")).getImage());
            configurarJTree();
            configurarPopup();
            setVisible(true);
            configurarGUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoApariencias = new javax.swing.ButtonGroup();
        btnGrupoEstados = new javax.swing.ButtonGroup();
        btnGrupoTransiciones = new javax.swing.ButtonGroup();
        pnlEste = new javax.swing.JPanel();
        pnlNorte = new javax.swing.JPanel();
        pnlNortePrincipal = new javax.swing.JPanel();
        jtbEstado = new javax.swing.JToolBar();
        tBtnTransicion = new javax.swing.JToggleButton();
        tBtnFinal = new javax.swing.JToggleButton();
        jtbTransicion = new javax.swing.JToolBar();
        tBtnCiclo = new javax.swing.JToggleButton();
        tBtnRecta = new javax.swing.JToggleButton();
        tBtnArco = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        pnlNorteDerecha = new javax.swing.JPanel();
        jtbMaquina = new javax.swing.JToolBar();
        txtCadena = new javax.swing.JTextField();
        btnValidar = new javax.swing.JButton();
        separadorMaquina = new javax.swing.JToolBar.Separator();
        tBtnVistaPrevia = new javax.swing.JToggleButton();
        pnlSur = new javax.swing.JPanel();
        pnlSurPrincipal = new javax.swing.JPanel();
        lbConsolaError = new javax.swing.JLabel();
        pnlSurDerecha = new javax.swing.JPanel();
        pnlSurDerecha.setVisible(false);
        btnMenosZoom = new javax.swing.JButton();
        sldZoom = new javax.swing.JSlider();
        btnMasZoom = new javax.swing.JButton();
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
        setTitle("jTuringMachine");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlEste.setBorder(javax.swing.BorderFactory.createTitledBorder("Arbol de objetos"));

        javax.swing.GroupLayout pnlEsteLayout = new javax.swing.GroupLayout(pnlEste);
        pnlEste.setLayout(pnlEsteLayout);
        pnlEsteLayout.setHorizontalGroup(
            pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        pnlEsteLayout.setVerticalGroup(
            pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );

        getContentPane().add(pnlEste, java.awt.BorderLayout.LINE_START);

        pnlNorte.setLayout(new java.awt.BorderLayout());

        pnlNortePrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jtbEstado.setRollover(true);
        jtbEstado.setToolTipText("Estado");

        btnGrupoEstados.add(tBtnTransicion);
        tBtnTransicion.setSelected(true);
        tBtnTransicion.setText("Transitivo");
        tBtnTransicion.setToolTipText("Selecciona la creación de un estado transitivo.");
        tBtnTransicion.setFocusable(false);
        tBtnTransicion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnTransicion.setRolloverEnabled(true);
        tBtnTransicion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbEstado.add(tBtnTransicion);

        btnGrupoEstados.add(tBtnFinal);
        tBtnFinal.setText("Final");
        tBtnFinal.setToolTipText("Selecciona la creación de un estado final");
        tBtnFinal.setFocusable(false);
        tBtnFinal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnFinal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbEstado.add(tBtnFinal);

        pnlNortePrincipal.add(jtbEstado);

        jtbTransicion.setRollover(true);
        jtbTransicion.setToolTipText("Transicion");

        btnGrupoTransiciones.add(tBtnCiclo);
        tBtnCiclo.setText("Ciclo");
        tBtnCiclo.setFocusable(false);
        tBtnCiclo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnCiclo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbTransicion.add(tBtnCiclo);

        btnGrupoTransiciones.add(tBtnRecta);
        tBtnRecta.setSelected(true);
        tBtnRecta.setText("Recta");
        tBtnRecta.setFocusable(false);
        tBtnRecta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnRecta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbTransicion.add(tBtnRecta);

        btnGrupoTransiciones.add(tBtnArco);
        tBtnArco.setText("Arco");
        tBtnArco.setFocusable(false);
        tBtnArco.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnArco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbTransicion.add(tBtnArco);

        pnlNortePrincipal.add(jtbTransicion);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlNortePrincipal.add(jButton1);

        pnlNorte.add(pnlNortePrincipal, java.awt.BorderLayout.CENTER);

        pnlNorteDerecha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jtbMaquina.setFloatable(false);
        jtbMaquina.setRollover(true);

        txtCadena.setMaximumSize(new java.awt.Dimension(200, 20));
        txtCadena.setMinimumSize(new java.awt.Dimension(200, 20));
        txtCadena.setPreferredSize(new java.awt.Dimension(200, 20));
        jtbMaquina.add(txtCadena);

        btnValidar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/book_edit.png"))); // NOI18N
        btnValidar.setToolTipText("Validar cadena con la máquina generáda.");
        btnValidar.setFocusable(false);
        btnValidar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnValidar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMaquina.add(btnValidar);
        jtbMaquina.add(separadorMaquina);

        tBtnVistaPrevia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/zoom.png"))); // NOI18N
        tBtnVistaPrevia.setToolTipText("Habilita la vista previa.");
        tBtnVistaPrevia.setFocusable(false);
        tBtnVistaPrevia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tBtnVistaPrevia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tBtnVistaPrevia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBtnVistaPreviaActionPerformed(evt);
            }
        });
        jtbMaquina.add(tBtnVistaPrevia);

        pnlNorteDerecha.add(jtbMaquina);

        pnlNorte.add(pnlNorteDerecha, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlNorte, java.awt.BorderLayout.PAGE_START);

        pnlSur.setLayout(new java.awt.BorderLayout());

        pnlSurPrincipal.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        lbConsolaError.setText("Consola: ");
        pnlSurPrincipal.add(lbConsolaError);

        pnlSur.add(pnlSurPrincipal, java.awt.BorderLayout.CENTER);

        pnlSurDerecha.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnMenosZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/magifier_zoom_out.png"))); // NOI18N
        btnMenosZoom.setToolTipText("Disminuir zoom");
        btnMenosZoom.setFocusable(false);
        btnMenosZoom.setMaximumSize(new java.awt.Dimension(20, 23));
        btnMenosZoom.setMinimumSize(new java.awt.Dimension(20, 23));
        btnMenosZoom.setPreferredSize(new java.awt.Dimension(23, 23));
        btnMenosZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosZoomActionPerformed(evt);
            }
        });
        pnlSurDerecha.add(btnMenosZoom);

        sldZoom.setMaximum(200);
        sldZoom.setMinimum(25);
        sldZoom.setMinorTickSpacing(25);
        sldZoom.setPaintTicks(true);
        sldZoom.setValue(100);
        sldZoom.setMaximumSize(new java.awt.Dimension(150, 24));
        sldZoom.setMinimumSize(new java.awt.Dimension(150, 24));
        sldZoom.setPreferredSize(new java.awt.Dimension(150, 24));
        sldZoom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldZoomStateChanged(evt);
            }
        });
        pnlSurDerecha.add(sldZoom);

        btnMasZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/jturingmachinele/visual/img/magnifier_zoom_in.png"))); // NOI18N
        btnMasZoom.setToolTipText("Aumentar zoom");
        btnMasZoom.setFocusable(false);
        btnMasZoom.setMaximumSize(new java.awt.Dimension(23, 23));
        btnMasZoom.setMinimumSize(new java.awt.Dimension(23, 23));
        btnMasZoom.setPreferredSize(new java.awt.Dimension(23, 23));
        btnMasZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasZoomActionPerformed(evt);
            }
        });
        pnlSurDerecha.add(btnMasZoom);

        pnlSur.add(pnlSurDerecha, java.awt.BorderLayout.EAST);

        getContentPane().add(pnlSur, java.awt.BorderLayout.PAGE_END);

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Área de trabajo"));
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
            setTitle(String.format("%s - jTuringMachine",
                                   archivo.getName()));
            lienzo.setObjetosGraficos(PersistirXML.abrir(archivo));
            refrescarMenuEstados(false, null);
            itemCerrarArchivo.setEnabled(true);
            openFile = true;
            lienzo.setEnabled(true);
            lienzo.setVisible(true);
        }
        selector = null;
        archivo = null;
        actualizaNodosArbol(lienzo.getObjetosGraficos());
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
                setTitle(String.format("%s - jTuringMachine",
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
            openFile = false;
            itemCerrarArchivo.setEnabled(false);
            setTitle("jTuringMachine");
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
        EstadoInicial.getInstancia().setCoordenadaXY(new Point(50, 50));
        actualizaNodosArbol(lienzo.getObjetosGraficos());
    }//GEN-LAST:event_itemNuevoArchivoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(JOptionPane.showConfirmDialog(this, "¿Está seguro que desea salir de la aplicación?",
                                         "jTuringMachine", JOptionPane.YES_NO_OPTION,
                                         JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        String cad = JOptionPane.showInputDialog(this,"Visibiliada");
//        AWTUtilities.setWindowOpacity(Aplicacion.this, Float.parseFloat(cad));
        lienzo.getEstados();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tBtnVistaPreviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBtnVistaPreviaActionPerformed
        vistaPrevia(tBtnVistaPrevia.isSelected());
    }//GEN-LAST:event_tBtnVistaPreviaActionPerformed

    private void sldZoomStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldZoomStateChanged
        // TODO add your handling code here:
        lienzo.setEscala(sldZoom.getValue() / 100F);
    }//GEN-LAST:event_sldZoomStateChanged

    private void btnMenosZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosZoomActionPerformed
        sldZoom.setValue(sldZoom.getValue() - 10);
    }//GEN-LAST:event_btnMenosZoomActionPerformed

    private void btnMasZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasZoomActionPerformed
        sldZoom.setValue(sldZoom.getValue() + 10);
    }//GEN-LAST:event_btnMasZoomActionPerformed

    //Configuramos el popUp
    private void configurarPopup(){
        //Añadimos el item para eliminar
        popUp = new JPopupMenu();
        itmEliminar = new JMenuItem("Eliminar estado");
        menuEstados = new JMenu("Transición");
        refrescarMenuEstados(false,null);
        popUp.add(itmEliminar);
        popUp.add(menuEstados);
    }

    //Refrescamos el combo de transiciones del popUp
    private void refrescarMenuEstados(boolean ciclo, String pareja){
        manejadorMenuPopUp manejador = new manejadorMenuPopUp();
        menuEstados.removeAll();
        menuEstados.setText(String.format("Transición %s", tipoTransicion));
        if(ciclo){
            JMenuItem item = new JMenuItem(pareja);
            item.addActionListener(manejador);
            menuEstados.add(item);
        }else{
            for(Estado est : lienzo.getEstados()){
                JMenuItem item = new JMenuItem(est.getEtiqueta());
                item.addActionListener(manejador);
                menuEstados.add(item);
            }
//            for(ObjetoGrafico estado : lienzo.getObjetosGraficos()){
//                if(estado.getClass().getName().contains("Estado")){
//                    Estado aux = (Estado)estado;
//                    JMenuItem item = new JMenuItem(aux.getEtiqueta());
//                    item.addActionListener(manejador);
//                    menuEstados.add(item);
//                }
//            }
        }
    }

    /**
     * Define si una transición esta retornando de un estado al que ya ha llegado
     * otra transición y va hacia el mismo estado de donde salió la anterior.
     * @param transicion Objeto de tipo <code>Transicion</code>
     */
    private boolean definirRetorno(Transicion transicion){
        boolean retorno = false;
        for(Transicion tran : lienzo.getTransiciones()){
            if(transicion.getNodoFinal().equals(tran.getNodoInicial())){
                retorno = true;
                break;
            }
        }
//        for(ObjetoGrafico e: lienzo.getObjetosGraficos()){
//            if(e.getClass().getSuperclass().equals(Transicion.class)){
//                Transicion tran = (Transicion)e;
//                if(transicion.getNodoFinal().equals(tran.getNodoInicial())){
//                    retorno = true;
//                    break;
//                }
//            }else{
//                retorno = false;
//            }
//        }
        return retorno;
    }

    //Clic en el lienzo, se usara para crear un nuevo estado
    private void lienzoMouseClicked(java.awt.event.MouseEvent evt){
        boolean crear = true;
        if(!evt.isMetaDown()){
            for(Estado est : lienzo.getEstados()){
                if(est.isFlotando(evt.getX(), evt.getY())){
                    crear = false;
                }
            }
//            for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
//                if(obj.getClass().getName().contains("Estado")){
//                    Estado est = (Estado) obj;
//                    if(est.isFlotando(evt.getX(), evt.getY())){
//                        crear = false;
//                    }
//                }
//            }
            if(crear){
                Estado nuevo;
                String etiqueta = JOptionPane.showInputDialog(this, "Etiqueta");
                if(etiqueta != null && !etiqueta.isEmpty()){
                    if(tBtnTransicion.isSelected()){
                        nuevo = new EstadoTransitivo(evt.getPoint(), etiqueta);
                    }else{
                        nuevo = new EstadoFinal(evt.getPoint(), etiqueta);
                    }
                    lienzo.setObjetoGrafico(nuevo);
                    refrescarMenuEstados(false,null);
                    actualizaNodosArbol(lienzo.getObjetosGraficos());
                }
            }
        }
    }

    //Evento que sucede cuando se mueve el ratón.
    private void lienzoMouseReleased(java.awt.event.MouseEvent evt){
        //Valido si es un clic derecho
        if(evt.isPopupTrigger()){
            Estado est = lienzo.getEstadoSeleccionado(evt.getX(), evt.getY());
            if(est != null){
                popUpX = evt.getX();
                popUpY = evt.getY();
                itmEliminar.setText(String.format("Eliminar estado: %s",
                                                  est.getEtiqueta()));
                itmEliminar.setName(est.getEtiqueta());
                if(est.getEtiqueta().equals("q1")){
                    itmEliminar.setVisible(false);
                }else{
                    itmEliminar.setVisible(true);
                }
                boolean ciclo = false;
                if(tBtnCiclo.isSelected()){
                    ciclo = true;
                    tipoTransicion = "ciclo";
                }else if(tBtnRecta.isSelected()){
                    tipoTransicion = "recta";
                }else{
                    tipoTransicion = "arco";
                }
                refrescarMenuEstados(ciclo, est.getEtiqueta());
                popUp.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }else{
            for(Estado est : lienzo.getEstados()){
                est.setMoving(false);
            }
//            for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
//                if(obj.getClass().getName().contains("Estado")){
//                    Estado est = (Estado) obj;
//                    est.setMoving(false);
//                }
//            }
        }
    }

    private void lienzoMousePressed(java.awt.event.MouseEvent evt){
        if(evt.isPopupTrigger()){
            Estado est = lienzo.getEstadoSeleccionado(evt.getX(), evt.getY());
            if(est != null){
                popUpX = evt.getX();
                popUpY = evt.getY();
                itmEliminar.setText(String.format("Eliminar estado: %s",
                                                  est.getEtiqueta()));
                itmEliminar.setName(est.getEtiqueta());
                if(est.getEtiqueta().equals("q1")){
                    itmEliminar.setVisible(false);
                }else{
                    itmEliminar.setVisible(true);
                }
                popUp.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }

    //Evento que sucede cuando se arrastra un estado.
    private void lienzoMouseDragged(java.awt.event.MouseEvent evt){
        if(!evt.isMetaDown()){
            for(Estado est : lienzo.getEstados()){
                if(!est.isFlotando(evt.getX(), evt.getY()) && !est.isMoving()){
                    est.setMoving(false);
                }else if((est.isFlotando(evt.getX(), evt.getY()) || est.isMoving()) && !est.isBloqueado()){
                    est.setMoving(true);
                    Point posicion = new Point(evt.getX() - Estado.RADIO,
                                               evt.getY() - Estado.RADIO);
                    est.setCoordenadaXY(posicion);
                    lienzo.bloquearEstados(est);
                    lienzo.repaint();
                }
            }
//            for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
//                if(obj.getClass().getName().contains("Estado")){
//                    Estado est = (Estado) obj;
//                    if(!est.isFlotando(evt.getX(), evt.getY()) && !est.isMoving()){
//                        est.setMoving(false);
//                    }else if((est.isFlotando(evt.getX(), evt.getY()) || est.isMoving()) && !est.isBloqueado()){
//                        est.setMoving(true);
//                        Point posicion = new Point(evt.getX() - Estado.RADIO,
//                                                   evt.getY() - Estado.RADIO);
//                        est.setCoordenadaXY(posicion);
//                        lienzo.bloquearEstados(est);
//                        lienzo.repaint();
//                    }
//                }
//            }
        }
    }

    //Evento para cambiar el color de un estado cuando el raton pase por encima.
    private void lienzoMouseMoved(java.awt.event.MouseEvent evt){
        for(Estado est : lienzo.getEstados()){
            est.setBloqueado(false);
            if(est.isFlotando(evt.getX(), evt.getY()) && !est.isExitado()){
                est.exitar();
                est.setExitado(true);
            }else if(!est.isFlotando(evt.getX(), evt.getY()) && est.isExitado()){
                est.desexitar();
                est.setExitado(false);
            }
            lienzo.repaint();
        }
//        for(ObjetoGrafico obj : lienzo.getObjetosGraficos()){
//            if(obj.getClass().getName().contains("Estado")){
//                Estado est = (Estado) obj;
//                est.setBloqueado(false);
//                if(est.isFlotando(evt.getX(), evt.getY()) && !est.isExitado()){
//                    est.exitar();
//                    est.setExitado(true);
//                }else if(!est.isFlotando(evt.getX(), evt.getY()) && est.isExitado()){
//                    est.desexitar();
//                    est.setExitado(false);
//                }
//                lienzo.repaint();
//            }
//        }
    }

    private void itmEliminarActionPerformed(ActionEvent e){
        JMenuItem item = (JMenuItem) e.getSource();
        lienzo.eliminarEstado(item.getName());
    }


    private void vistaPrevia(boolean isVistaPrevia){
        boolean activar = (isVistaPrevia ? false : true);
        lienzo.setVistaPrevia(isVistaPrevia);
        pnlNortePrincipal.setVisible(activar);
        pnlEste.setVisible(activar);
        pnlSurDerecha.setVisible(isVistaPrevia);
        if(!isVistaPrevia){
            sldZoom.setValue(100);
        }
    }

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
                if(!lienzo.isVistaPrevia()){
                    lienzoMouseReleased(evt);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt){
                if(!lienzo.isVistaPrevia()){
                    lienzoMouseClicked(evt);
                }
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt){
                if(!lienzo.isVistaPrevia()){
                    lienzoMousePressed(evt);
                }
            }
        });

        lienzo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter(){
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if(!lienzo.isVistaPrevia()){
                    lienzoMouseDragged(evt);
                }
            }
            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                if(!lienzo.isVistaPrevia()){
                    lienzoMouseMoved(evt);
                }
            }
        });

        //Eventos del popUp

        itmEliminar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itmEliminarActionPerformed(e);
                actualizaNodosArbol(lienzo.getObjetosGraficos());
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.ButtonGroup btnGrupoApariencias;
    private javax.swing.ButtonGroup btnGrupoEstados;
    private javax.swing.ButtonGroup btnGrupoTransiciones;
    private javax.swing.JButton btnMasZoom;
    private javax.swing.JButton btnMenosZoom;
    private javax.swing.JButton btnValidar;
    private javax.swing.JMenuItem itemAbrirArchivo;
    private javax.swing.JMenuItem itemAcercaDe;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenuItem itemCerrarArchivo;
    private javax.swing.JMenuItem itemDeshacer;
    private javax.swing.JMenuItem itemGuardarArchivo;
    private javax.swing.JMenuItem itemNuevoArchivo;
    private javax.swing.JMenuItem itemRehacer;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JToolBar jtbEstado;
    private javax.swing.JToolBar jtbMaquina;
    private javax.swing.JToolBar jtbTransicion;
    private javax.swing.JLabel lbConsolaError;
    private javax.swing.JMenu menuApariencias;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuAyuda;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JMenu menuHerramientas;
    private javax.swing.JPanel pnlEste;
    private javax.swing.JPanel pnlNorte;
    private javax.swing.JPanel pnlNorteDerecha;
    private javax.swing.JPanel pnlNortePrincipal;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSur;
    private javax.swing.JPanel pnlSurDerecha;
    private javax.swing.JPanel pnlSurPrincipal;
    private javax.swing.JRadioButtonMenuItem rdioMenuLinux;
    private javax.swing.JRadioButtonMenuItem rdioMenuMetal;
    private javax.swing.JRadioButtonMenuItem rdioMenuSolaris;
    private javax.swing.JRadioButtonMenuItem rdioMenuWindows;
    private javax.swing.JSeparator separador1;
    private javax.swing.JToolBar.Separator separadorMaquina;
    private javax.swing.JSlider sldZoom;
    private javax.swing.JToggleButton tBtnArco;
    private javax.swing.JToggleButton tBtnCiclo;
    private javax.swing.JToggleButton tBtnFinal;
    private javax.swing.JToggleButton tBtnRecta;
    private javax.swing.JToggleButton tBtnTransicion;
    private javax.swing.JToggleButton tBtnVistaPrevia;
    private javax.swing.JTextField txtCadena;
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

    /**
     * Inicializa las configuraciones del <code>JTree</code> para mostrarse en pantalla
     */
    private void configurarJTree() {
        //Iniciar el JTree con el modelo de jTuringMachine
        padre = new DefaultMutableTreeNode("Maquina de Turing");//Crear nodo padre
        modelo = new DefaultTreeModel(padre);//Crear el modelo y asignarle el nodo padre
        treeArbolObjetos = new JTree(modelo);//Asignar el modelo al JTree

        scrollArbolObjetos.setViewportView(treeArbolObjetos);//Agregar el JTree a el JScrollPane
        //Agregamos las propiedades al JPanelEste
        javax.swing.GroupLayout pnlEsteLayout = new javax.swing.GroupLayout(pnlEste);
        pnlEste.setLayout(pnlEsteLayout);
        pnlEsteLayout.setHorizontalGroup(
            pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
            .addGroup(pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollArbolObjetos, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
        );
        pnlEsteLayout.setVerticalGroup(
            pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
            .addGroup(pnlEsteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(scrollArbolObjetos, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE))
        );

        getContentPane().add(pnlEste, java.awt.BorderLayout.LINE_START);

        // Cambiamos los iconos
        render= (DefaultTreeCellRenderer)treeArbolObjetos.getCellRenderer();
        render.setLeafIcon(new ImageIcon(getClass().getResource(
                "/com/jturingmachinele/visual/img/Estado_Transicion.png")));
        render.setOpenIcon(new ImageIcon(getClass().getResource(
                "/com/jturingmachinele/visual/img/Estado_Transicion.png")));
        render.setClosedIcon(new ImageIcon(getClass().getResource(
                "/com/jturingmachinele/visual/img/Estado_Transicion.png")));
    }

    /**
     * Actualiza el <code>JTree</code> cada que se modifica el lienzo (agregar o
     * eliminar gráficos, abrir archivos etc.)
     * @param objetos ArrayList con los objetos creados en el Lienzo
     */
    public void actualizaNodosArbol(ArrayList<ObjetoGrafico> objetos){
            configurarJTree();
            DefaultMutableTreeNode nodoEstado = null;
            DefaultMutableTreeNode nodoTransicion = null;
            for(ObjetoGrafico o: objetos){
                if(o.getClass().getSuperclass().equals(Estado.class)){
                    Estado est = (Estado)o;
                    nodoEstado = new DefaultMutableTreeNode("Estado: " + est.getEtiqueta());
                    padre.add(nodoEstado);

                }
                else
                    if(o.getClass().getSuperclass().equals(Transicion.class)){
                        Transicion tran = (Transicion)o;
                        nodoTransicion = new DefaultMutableTreeNode("Transicion: "
                                            + tran.getEtiqueta());
                        for(int a=0; a<padre.getChildCount(); a++){
                            if(padre.getChildAt(a).toString().equalsIgnoreCase("Estado: "
                                    + tran.getNodoInicial().getEtiqueta())){
                                nodoEstado = (DefaultMutableTreeNode)padre.getChildAt(a);
                            }
                        } 
                        nodoEstado.add(nodoTransicion);
                    }
            }
            modelo.setRoot(padre);
            treeArbolObjetos.setModel(modelo);                
    }

    private class manejadorMenuPopUp implements ActionListener{
        public void actionPerformed(ActionEvent evento){
            Transicion trans;
            String etiqueta = JOptionPane.showInputDialog(Aplicacion.this, 
                                                          "Etiqueta", 
                                                          "jTuringMachine", 
                                                          JOptionPane.INFORMATION_MESSAGE);
            if(etiqueta != null && !etiqueta.isEmpty()){
                Estado estIni = lienzo.getEstadoSeleccionado(popUpX, popUpY);
                Estado estFin = lienzo.getEstado(evento.getActionCommand());
                if(tBtnCiclo.isSelected()){
                    trans = new TransicionCiclo(estIni, etiqueta);
                }else if(tBtnRecta.isSelected()){
                    trans = new TransicionRecta(estIni, estFin, etiqueta);
                }else{
                    trans = new TransicionArco(estIni, estFin, etiqueta);
                }
                lienzo.setObjetoGrafico(trans);
                actualizaNodosArbol(lienzo.getObjetosGraficos());
            }
        }
    }


}
