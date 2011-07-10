/*
 *  TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 *   
 *  Copyright (C) 2009  SystarSystems.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or 
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see http://www.gnu.org/licenses/.
 * 
 * @(#)TransicionRecta.java	1.0 22/01/2010
 *
 */
package com.jturingmachinele.graphics.transiciones;

import com.jturingmachinele.graphics.estados.Estado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.util.Observable;

/**
 * Clase que representa una <code>TransicionRecta</code>, para representar
 * el movimiento de una máquina de turing en forma lineal.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class TransicionRecta extends Transicion implements Serializable{

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
     * Crea una <code>TransicionRecta</code>
     */
    public TransicionRecta(){
        super(null, null, "");
    }

    /**
     * Crea una <code>TransicionRecta</code>
     * @param nodoInicial Estado de donde partirá la transición
     * @param nodoFinal Estado a donde llegará la transición.
     * @param etiqueta Etiqueta que mostrará la transición
     */
    public TransicionRecta(Estado nodoInicial, Estado nodoFinal, String etiqueta){
        super(nodoInicial, nodoFinal, etiqueta);
    }

    /**
     * Dibuja una <code>TransicionRecta</code> de un estado a otro con su etiqueta.
     * @param g Objeto para dibujar graficos en el lienzo.
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        Point[] puertosInicial = this.getNodoInicial().getPuertos();
        Point[] puertosFinal = this.getNodoFinal().getPuertos();
        short[] puertos = this.getPuertos();
        if((puertosInicial[puertos[0]].x != puertosFinal[puertos[1]].x) ||
           (puertosInicial[puertos[0]].y != puertosFinal[puertos[1]].y)){
            g.drawLine(puertosInicial[puertos[0]].x, puertosInicial[puertos[0]].y,
                   puertosFinal[puertos[1]].x, puertosFinal[puertos[1]].y);
            this.dibujarFlecha(g, puertosInicial[puertos[0]].x, puertosInicial[puertos[0]].y,
                                 puertosFinal[puertos[1]].x, puertosFinal[puertos[1]].y);
            dibujarEtiqueta(g, puertosInicial[puertos[0]].x, puertosInicial[puertos[0]].y,
                                 puertosFinal[puertos[1]].x, puertosFinal[puertos[1]].y);
        }
    }


    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
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

    private void dibujarEtiqueta(Graphics g, int x1, int y1, int x2, int y2){
        int x = 0;
        int y = 0;
        x = x1 + 10 + (x2 - x1) / 2;
        y = y1 - 5 + (y2 - y1) / 2;
        g.drawString(getEtiqueta(), x, y);
    }

}
