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
 * @(#)EstadoFinal.java	1.0 21/01/2010
 *
 */

package com.jturingmachinele.graphics.estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * Clase que representa un <code>EstadoFinal</code>,  pueden existir "n" cantidad
 * de estados finales.
 *
 * @author Marcela Sena
 * @version 1.0
 */
public class EstadoFinal extends Estado implements Serializable {

    private static final long serialVersionUID = 11;
    private Color exitado = Color.BLACK;

    /**
     * Constructor por default para la clase <code>EstadoFinal</code> el cual
     * crea el estado en la posición (5,5) del lienzo y le asigna una etiqueta
     * vacía.
     */
    public EstadoFinal (){
        setCoordenadaXY(new Point(5,5));
        setEtiqueta("");
    }

    /**
     * Constructor sobrecargado para la clase <code>EstadoFinal</code> el cual
     * crea el estado final en la posición del lienzo definida por el usuario
     * y le asigna una etiqueta definida por el usuario.
     *
     * @param xy Punto donde el usuario define se dibujará el <code>EstadoFinal</code> en el lienzo
     * @param etiqueta Etiqueta que será asignada al <code>EstadoFinal</code>
     */
    public EstadoFinal(Point xy, String etiqueta){
        setCoordenadaXY(xy);
        setEtiqueta(etiqueta);
    }

    /**
     * Dibuja un <code>EstadoFinal</code> en una posición del lienzo con una
     * etiqueda definida.
     *
     * @param g Objeto de tipo Grphics que permite dibujar gráficos.
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(exitado);
        //Dibuja el Círculo Exterior
        g.drawOval(getCoordenadaXY().x, getCoordenadaXY().y, 
                   EstadoFinal.RADIO * 2, EstadoFinal.RADIO * 2);
        //Dibujar el Círculo Interior
        g.drawOval(getCoordenadaXY().x + 5, getCoordenadaXY().y + 5,
                   EstadoFinal.RADIO * 2 - 10, EstadoFinal.RADIO * 2 - 10);
        //Dibujar la Etiqueta
                g.drawString(getEtiqueta(),
                     getCentroXY().x - 7,
                     getCentroXY().y + 5);
    }

    /**
     * Cambia el estatus a "Exitado", y se asigna un color RGB = (117, 146, 60) al
     * <code>EstadoFinal</code>
     */
    @Override
    public void exitar() {
        exitado = new Color(117, 146, 60);
        setExitado(true);
    }

    /**
     * Cambia el estatus a "Desexitado", y se asigna un color Negro al
     * <code>EstadoFinal</code>
     */
    @Override
    public void desexitar() {
        exitado = Color.BLACK;
        setExitado(false);
    }

}
