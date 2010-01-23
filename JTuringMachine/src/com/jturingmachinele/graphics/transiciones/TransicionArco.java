/**
 *
 * @author Juan Sandoval
 */

package com.jturingmachinele.graphics.transiciones;

import com.jturingmachinele.graphics.estados.Estado;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Observable;

public class TransicionArco extends Transicion implements Serializable {

    public TransicionArco(Estado nodoInicial, Estado nodoFinal, String etiqueta){
        super(nodoInicial, nodoFinal, etiqueta);
    }

    @Override
    public void dibujar(Graphics g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
