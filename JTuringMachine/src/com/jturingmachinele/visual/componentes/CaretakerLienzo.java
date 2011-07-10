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
 * @(#)CaretakerLienzo.java	1.0 26/01/2010
 *
 */
package com.jturingmachinele.visual.componentes;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que guarda todos los mementos del lienzo y permite realizar operaciones
 * de "Deshacer" y "Rehacer" sobre el <code>Lienzo</code>.
 * 
 * @author Juan Sandoval
 * @version 1.0
 */
public class CaretakerLienzo {

    private List<MementoLienzo> estados;
    private int posicion = -1;

    /**
     * Crea un nuevo "Caretaker" para el objeto <code>Lienzo</code>.
     */
    public CaretakerLienzo(){
        estados = new ArrayList<MementoLienzo>();
        posicion = estados.size() - 1;
        System.out.println(estados.size());
    }

    /**
     * Recorre el "Caretaker" al memento anterior del <code>Lienzo</code>.
     * @return El memento anterior del <code>Lienzo</code>.
     */
    public MementoLienzo deshacer(){
        if(posicion > 0){
            posicion--;
        }
        System.out.println("--POSICION->" + posicion);
        System.out.println(estados.get(0).objetosGraficos.size());
        return (MementoLienzo) estados.get(posicion);        
    }

    /**
     * Recorre el "Caretaker" al memento siguiente del <code>Lienzo</code>.
     * @return El memento anterior del <code>Lienzo</code>.
     */
    public MementoLienzo rehacer(){
        if(posicion < estados.size() - 1){
            posicion++;
        }
        System.out.println("++++POSICION->" + posicion);
        System.out.println(estados.get(0).objetosGraficos.size());
        return (MementoLienzo) estados.get(posicion);
    }

    /**
     * Almacena un memento del estado actual del <code>Lienzo</code>.
     * @param memento El memento que será almacenado.
     */
    public void addMemento(MementoLienzo memento){
        estados.add(memento);
        posicion++;
        System.out.println("++POSICION->" + posicion);
    }

    /**
     * Determina si el memento actual es el memento mas reciente del estado del
     * <code>Lienzo</code>.
     * @return <code>True</code> si es el memento más reciente, y <code>False</code>
     * si no es el memento más reciente.
     */
    public boolean isMementoMaximo(){
        return (posicion == estados.size() - 1 ? true : false);
    }

    /**
     * Determina si el memento actual es el memento mas viejo del estado del
     * <code>Lienzo</code>.
     * @return <code>True</code> si es el memento más viejo, y <code>False</code>
     * si no es el memento más viejo.
     */
    public boolean isMementoMinimo(){
        return (posicion == 0 ? true : false);
    }

}
