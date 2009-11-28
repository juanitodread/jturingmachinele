/**
 *
 * @author Juan Sandoval
 */

package com.jturingmachinele.graphics.estados;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

public class EstadoInicial extends Estado implements Serializable {

    public EstadoInicial(){
    }

    public EstadoInicial(Point xy){
        this.setCoordenadaXY(xy);
    }

    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exitar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void desexitar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
