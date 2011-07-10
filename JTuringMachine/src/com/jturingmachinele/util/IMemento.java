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
 * @(#)IMemento.java	1.0 26/01/2010
 *
 */
package com.jturingmachinele.util;

/**
 * Interfaz que permite implementar el patron memento a alguna clase en cuestion.
 * La clase que implemente <code>IMemento</code> debera sobreescribir los dos
 * métodos, uno para crear un memento y el otro para restaurar un memento.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public interface IMemento {

    /**
     * Crea un nuevo memento.
     * @return Objeto que será el mememnto de la clase que implemente esta interfaz.
     */
    public Object getMemento();

    /**
     * Establece un nuevo memento de la clase que implemente esta interfaz.
     */
    public void setMemento(Object memento);

    /**
     * Restaura la clase a su memento anterior.
     */
    public void deshacer();

    /**
     * Recorre la clase a su memento próximo.
     */
    public void rehacer();
}
