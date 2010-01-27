/*
 * @(#)MementoLienzo.java	1.0 26/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */
package com.jturingmachinele.visual.componentes;

import com.jturingmachinele.graphics.ObjetoGrafico;
import java.util.ArrayList;

/**
 * Clase que representa un memento para la clase <code>Lienzo</code>.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class MementoLienzo {
    ArrayList<ObjetoGrafico> objetosGraficos = null;

    /**
     * Crea un nuevo memento para el <code>Lienzo</code>.
     * @param objetosGraficos
     */
    public MementoLienzo(ArrayList<ObjetoGrafico> objetosGraficos){
        this.objetosGraficos = new ArrayList<ObjetoGrafico>();
        for(ObjetoGrafico obj : objetosGraficos){
            this.objetosGraficos.add(obj);
        }
    }

}
