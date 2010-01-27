/*
 * @(#)IMemento.java	1.0 26/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
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
