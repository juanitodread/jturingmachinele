/*
 * @(#)EstadoTransitivo.java	1.0 21/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */
package com.jturingmachinele.graphics.estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * Clase que representa un <code>EstadoTransitivo</code>, puede haber "n"
 * cantidad de estados transitivos.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class EstadoTransitivo extends Estado implements Serializable {

    private static final long serialVersionUID = 1l;
    private Color exitado = Color.BLACK;

    /**
     * Constructor por default para la clase <code>EstadoTransitivo</code>
     * la cual crea el estado en la posición (5,5) de lienzo y le asigna una
     * etiqueta vacia.
     */
    public EstadoTransitivo(){
        setCoordenadaXY(new Point(5, 5));
        setEtiqueta("");
    }

    /**
     * Constructor por sobrecargado para la clase <code>EstadoTransitivo</code>
     * la cual crea el estado en la posición definida por el usuario en el lienzo
     * y le asigna una etiqueta con la información definida por el usuario.
     *
     * @param xy Punto donde se dibujará el <code>EstadoTransitivo</code>.
     * @param etiqueta Que tendrá el <code>EstadoTransitivo</code>.
     */
    public EstadoTransitivo(Point xy, String etiqueta){
        setCoordenadaXY(xy);
        setEtiqueta(etiqueta);
    }

    /**
     * Dibuja un <code>EstadoTransitivo</code> en la posición establecida y con su
     * etiqueta definida.
     * @param g Objeto de tipo Graphics que permite dibujar gráficos.
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(exitado);
        //Dibujo el circulo
        g.drawOval(getCoordenadaXY().x, getCoordenadaXY().y,
                   EstadoTransitivo.RADIO * 2, EstadoTransitivo.RADIO * 2);
        //Dibujo la Etiqueta
        g.drawString(getEtiqueta(),
                     getCentroXY().x - 7,
                     getCentroXY().y + 5);
    }

    /**
     * Cambia el estatus a "Exitado" y asigna un color RGB={49, 132, 155} al
     * <code>EstadoTransitivo</code>.
     */
    @Override
    public void exitar() {
        exitado = new Color(49, 132, 155);
        setExitado(true);
    }

    /**
     * Cambia el estatus a "Desexitado" y asigna un color Negro al
     * <code>EstadoTransitivo</code>.
     */
    @Override
    public void desexitar() {
        exitado = Color.BLACK;
        setExitado(false);
    }

}
