/*
 * @(#)TransicionRecta.java	1.0 23/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.graphics.transiciones;

import com.jturingmachinele.graphics.estados.Estado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.Observable;

/**
 * Clase que representa una <code>TransicionCiclo</code>, para representar un
 * movimiento de la Máquina de Turing que sale de un Estado y regresa al mismo,
 * es por esto que se le llama transición de ciclo.
 * @author msena
 */
public class TransicionCiclo extends Transicion implements Serializable {

    private static final long serialVersionUID = 1l;
    /**
     * Tamaño de la punta de la flecha en pixeles
     */
    public static final int TAMANIO_FLECHA = 10;
    /**
     * Angulo que forman las dos rectas de la flecha.
     */
    public static final double ANGULO_FLECHA = Math.PI / 6;

    /**
     * Crea una <code>TransicionCiclo</code>, utilizando el contructor de la clase
     * padre <code>Transicion</code>.
     * @param nodoInicial Estado de donde partirá la transición
     * @param nodoFinal Estado a donde llegará la transición.
     * @param etiqueta Etiqueta que mostrará la transición.
     */
    public TransicionCiclo(Estado nodoInicial, Estado nodoFinal, String etiqueta){
        super(nodoInicial, nodoFinal, etiqueta);
    }

    /**
     * Dibuja una <code>TransicionCiclo</code> de un estado a sí mismo, con su etiqueta.
     * @param g Objeto para dibujar graficos en el lienzo.
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        Point [] puertoCiclo = getNodoInicial().getPuertos();
        Point puertoSalida = puertoCiclo[11].getLocation();
        //Point puertoLlegada = puertoCiclo[14].getLocation();
        g.drawArc(puertoSalida.x, puertoSalida.y - 30, 30, 30, 300, 300);
        dibujarFlecha(g, puertoSalida.x + 60, puertoSalida.y - 50, puertoSalida.x + 20, puertoSalida.y);
        g.drawString(getEtiqueta(), puertoSalida.x + 5, puertoSalida.y - 35);
    }

    private void dibujarFlecha(Graphics g, int x1, int y1, int x2, int y2){
        //Obtenemos la variacion de x y y
        double dY = - (y1 - y2) * 1.0;
        double dX = (x1 - x2) * 1.0;
        //Obtenemos el angulo Tetha con respecto al horizonte del plano
        float tetha = (float) Math.atan(dY / dX);
        //Si la variacion de x es negativa sumamos un PI (180º)
        if(dX < 0){
            tetha += Math.PI;
        }
        Point verticeIzq, verticeDer;
        //Obtenemos los valores de los puntos donde se dibujaran las lineas que conforman la flecha
        verticeIzq = new Point((int)(x2 + TransicionRecta.TAMANIO_FLECHA * Math.cos(tetha - ANGULO_FLECHA)),
                               (int)(y2 - TransicionRecta.TAMANIO_FLECHA * Math.sin(tetha - ANGULO_FLECHA)));
        verticeDer = new Point((int)(x2 + TransicionRecta.TAMANIO_FLECHA * Math.cos(tetha + ANGULO_FLECHA)),
                               (int)(y2 - TransicionRecta.TAMANIO_FLECHA * Math.sin(tetha + ANGULO_FLECHA)));
        //Dibujamos las dos lineas para hacer la flecha
        g.drawLine(verticeIzq.x, verticeIzq.y, x2, y2);
        g.drawLine(verticeDer.x, verticeDer.y, x2, y2);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}