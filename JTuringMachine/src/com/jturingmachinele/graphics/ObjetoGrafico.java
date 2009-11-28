/**
 * Clase Abstracta de la cual heredarán todas las demas figuras
 *
 * @author Juan Sandoval
 */
package com.jturingmachinele.graphics;

import java.awt.Graphics;
import java.io.Serializable;

public abstract class ObjetoGrafico implements Serializable{
    
    /**
     * Método que dibuja una figura
     * @param g
     */
    public abstract void dibujar(Graphics g);
}
