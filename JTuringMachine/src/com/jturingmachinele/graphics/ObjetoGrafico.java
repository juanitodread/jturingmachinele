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
 * @(#)ObjetoGrafico.java	1.0 21/01/2010
 *
 */
package com.jturingmachinele.graphics;

import java.awt.Graphics;
import java.io.Serializable;

/**
 * Clase Abstracta de la cual heredarán todas las demas figuras.
 * Proporciona el mecanísmo para poder dibujar todas las figuras en el panel.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public abstract class ObjetoGrafico implements Serializable{

    private static final long serialVersionUID = 1l; //Id de versión del objeto serializado.
    private int id;

    /**
     * Devuelve el ID del objeto gráfico.
     * @return El id del objeto gráfico en cuestión.
     */
    public int getId(){
        return id;
    }

    /**
     * Establece el Id del objeto gráfico.
     * @param id del objeto gráfico en cuestión.
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Método que dibuja una figura.
     * @param g Objeto de tipo Graphics que permite dibujar gráficos.
     */
    public abstract void dibujar(Graphics g);
}
