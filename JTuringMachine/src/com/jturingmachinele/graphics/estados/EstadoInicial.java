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
 * @(#)EstadoInicial.java	1.0 20/01/2010
 *
 */
package com.jturingmachinele.graphics.estados;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * Clase que representa un <code>EstadoInicial</code>, solo puede haber un
 * estado inicial por lo tanto la clase implementa el patron <b>Singleton</b>
 * para que solo exista un <code>EstadoInicial</code>.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class EstadoInicial extends Estado implements Serializable {

    private static EstadoInicial INSTANCIA = null;
    private static final long serialVersionUID = 1l;
    private Color exitado = Color.BLACK;

    /**Se utilizaba cuando no era un singleton, ahora ya lo es, por lo tanto
     * no se debe usar.
     *
     * @deprecated No utilizar dado que es un singleton
     */
    public EstadoInicial(){
    }

    /**
     * Constructor del <code>EstadoInicial</code>.
     * @param xy Posición de la coordenada de la esquina superior izquierda del rectangulo
     * donde se dibujará el <code>EstadoInicial</code>.
     * @param etiqueta Nombre que se le dará al <code>EstadoInicial</code>.
     */
    private EstadoInicial(Point xy, String etiqueta){
        setCoordenadaXY(xy);
        setEtiqueta(etiqueta);
    }

    /**
     * Metodo sincronizado que crea una instancia unica del <code>EstadoInicial</code>.
     * @param xy Posición de la coordenada de la esquina superior izquierda del rectangulo
     * donde se dibujará el <code>EstadoInicial</code>.
     * @param etiqueta Nombre que se le dará al <code>EstadoInicial</code>.
     */
    private static synchronized void crearInstancia(Point xy, String etiqueta){
        if(INSTANCIA == null){
            INSTANCIA = new EstadoInicial(xy, etiqueta);
        }
    }

    /**
     * Obtiene una instancia de <code>EstadoInicial</code>, si no existe crea uno
     * nuevo, si ya existe una instancia solo la retorna debido a que solo puede
     * existir un <code>EstadoInicial</code>.
     * @return Una instancia de <code>EstadoInicial</code>.
     */
    public static EstadoInicial getInstancia(){
        if(INSTANCIA == null){
            crearInstancia(new Point(50, 250), "q1");
        }
        return INSTANCIA;
    }

    /**
     * Dibuja un <code>EstadoInicial</code> en la posición establecida y con su
     * etiqueta definida.
     * @param g Objeto de tipo Graphics que permite dibujar gráficos.
     */
    @Override
    public void dibujar(Graphics g) {
        g.setColor(exitado);
        //Dibujo el circulo
        g.drawOval(getCoordenadaXY().x, getCoordenadaXY().y,
                   EstadoInicial.RADIO * 2, EstadoInicial.RADIO * 2);
        //Dibujo la flecha
        g.drawLine(getCoordenadaXY().x - 20, getCentroXY().y,
                   getCoordenadaXY().x, getCentroXY().y);
        g.drawLine(getCoordenadaXY().x, getCentroXY().y,
                   getCoordenadaXY().x - 5, getCentroXY().y - 5);
        g.drawLine(getCoordenadaXY().x, getCentroXY().y,
                   getCoordenadaXY().x - 5, getCentroXY().y + 5);
        //Dibujo la Etiqueta
        g.drawString(getEtiqueta(),
                     getCentroXY().x - 7,
                     getCentroXY().y + 5);
    }

    /**
     * Cambia el estatus a "Exitado" y asigna un color RGB={228,109,10} al
     * <code>EstadoInicial</code>.
     */
    @Override
    public void exitar() {
        exitado = new Color(228, 109, 10);
        setExitado(true);
    }

    /**
     * Cambia el estatus a "Desexitado" y asigna un color Negro al
     * <code>EstadoInicial</code>.
     */
    @Override
    public void desexitar() {
         exitado = Color.BLACK;
         setExitado(false);
    }

}
