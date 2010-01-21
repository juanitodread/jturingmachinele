/*
 * @(#)ObjetoGrafico.java	1.0 19/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
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
