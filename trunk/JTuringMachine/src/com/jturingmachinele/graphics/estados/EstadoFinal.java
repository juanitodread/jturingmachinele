/**
 *
 * @author Juan Sandoval
 */

package com.jturingmachinele.graphics.estados;

import java.awt.Graphics;
import java.io.Serializable;

public class EstadoFinal extends Estado implements Serializable {

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
