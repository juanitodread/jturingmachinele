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
 * @(#)MementoLienzo.java	1.0 26/01/2010
 *
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
