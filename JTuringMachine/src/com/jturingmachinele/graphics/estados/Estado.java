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
 * @(#)Estado.java	1.0 20/01/2010
 *
 */
package com.jturingmachinele.graphics.estados;

import com.jturingmachinele.graphics.ObjetoGrafico;
import java.awt.Point;
import java.io.Serializable;

/**
 * Clase abstracta que permite definir los métodos y atributos de un estado en el lienzo
 * y de la cual heredaran los distintos tipos de Estados.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public abstract class Estado extends ObjetoGrafico implements Serializable {

    private static final long serialVersionUID = 1l;
    private Point coordenadaXY = new Point(0,0);
    private Point coordenadaX1Y = new Point(0,0);
    private Point coordenadaXY1 = new Point(0,0);
    private Point coordenadaX1Y1 = new Point(0,0);
    private Point centroXY = new Point(0,0);
    private Point[] puertos = new Point[16];
    private String etiqueta;
    private boolean exitado = false;
    private boolean moving = false;
    private boolean bloqueado = false;

    /**
     * Radio que tienen los estados, su valor es 25,
     */
    public static final int RADIO = 25;

    /**
     * Delimita el rectangulo de un objeto tipo <code>Estado.</code>
     * Este metodo define los 4 puntos que conforman el rectangulo imaginario
     * que envuelve al objeto, todo esto de acuerdo a la posición en que
     * se encuentre su esquina superior izquierda en dicho momento.
     */
    private void delimitarArea(){
        coordenadaX1Y.setLocation(coordenadaXY.x + 2 * RADIO,
                                  coordenadaXY.y);
        coordenadaXY1.setLocation(coordenadaXY.x,
                                  coordenadaXY.y + 2 * RADIO);
        coordenadaX1Y1.setLocation(coordenadaXY.x + 2 * RADIO,
                                   coordenadaXY.y + 2 * RADIO);
        centroXY.setLocation(coordenadaXY.x + RADIO,
                             coordenadaXY.y + RADIO);
        formarPuertos();
    }

    /**
     * Define los 16 puertos en donde pueden llegar las transiciones,
     * en el momento de la posición actual del estado.
     */
    private void formarPuertos(){
        double anguloConstante = Math.PI / 8;
        for(int i = 0; i < 16; i++){
            double radian = anguloConstante * i;
            puertos[i] = new Point(centroXY.x + (int)(RADIO * Math.cos(radian)),
                                   centroXY.y + (int)(RADIO * Math.sin(radian)));
        }
    }

    /**
     * Metodo que cambia el estatus del estado a exitado, se usa cuando un evento
     * del ratón ocurre sobre el Estado.
     */
    public abstract void exitar();

    /**
     * Metodo que cambia el estatus del estado a desexitado, se usa cuando
     * ha terminado la acción de un evento del ratón sobre el Estado.
     */
    public abstract void desexitar();

    /**
     * Determina si el raton se encuentra sobre algun <code>Estado</code>, si es
     * así retorna un <code>True</code>, sino retorna un <code>False</code>.
     * @param x Posición en el eje "X" del Raton.
     * @param y Posición en el eje "Y" del Raton.
     * @return <code>True</code> si está sobre el <code>Estado</code>,
     * <code>False</code> si no es así.
     */
    public boolean isFlotando(int x, int y){
        return ( x >= coordenadaXY.x && x <= coordenadaX1Y.x &&
                 y >= coordenadaXY.y && y <= coordenadaXY1.y ? true : false );
    }

    /**
     * Obtiene la coordenada de la esquina superior izquierda del rectangulo que
     * envuelve al Estado.
     * @return El punto donde esta la esquina superior izquierda.
     */
    public Point getCoordenadaXY() {
        return coordenadaXY;
    }

    /**
     * Establece la coordenada de la esquina superior izquierda del rectangulo
     * que envuelve al Estado.
     * @param coordenadaXY El punto (X,Y) que será la posición de la esquina
     * superior izquierda del rectangulo.
     */
    public void setCoordenadaXY(Point coordenadaXY) {
        this.coordenadaXY = coordenadaXY;
        delimitarArea();
    }

     /**
     * Obtiene la coordenada de la esquina superior derecha del rectangulo que
     * envuelve al Estado.
     * @return El punto donde esta la esquina superior derecha.
     */
    public Point getCoordenadaX1Y() {
        return coordenadaX1Y;
    }

//    /**
//     * Establece la coordenada de la esquina superior derecha del rectangulo
//     * que envuelve al Estado.
//     * @param coordenadaX1Y El punto (X,Y) que será la posición de la esquina
//     * superior derecha del rectangulo.
//     */
//    public void setCoordenadaX1Y(Point coordenadaX1Y) {
//        this.coordenadaX1Y = coordenadaX1Y;
//    }

    /**
    * Obtiene la coordenada de la esquina inferior izquierda del rectangulo que
    * envuelve al Estado.
    * @return El punto donde esta la esquina inferior izquierda.
    */
    public Point getCoordenadaXY1() {
        return coordenadaXY1;
    }

//    /**
//     * Establece la coordenada de la esquina inferior izquierda del rectangulo
//     * que envuelve al Estado.
//     * @param coordenadaXY1 El punto (X,Y) que será la posición de la esquina
//     * inferior izquierda del rectangulo.
//     */
//    public void setCoordenadaXY1(Point coordenadaXY1) {
//        this.coordenadaXY1 = coordenadaXY1;
//    }

    /**
    * Obtiene la coordenada de la esquina inferior derecha del rectangulo que
    * envuelve al Estado.
    * @return El punto donde esta la esquina inferior derecha.
    */
    public Point getCoordenadaX1Y1() {
        return coordenadaX1Y1;
    }

//    /**
//     * Establece la coordenada de la esquina inferior derecha del rectangulo
//     * que envuelve al Estado.
//     * @param coordenadaX1Y1 El punto (X,Y) que será la posición de la esquina
//     * inferior derecha del rectangulo.
//     */
//    public void setCoordenadaX1Y1(Point coordenadaX1Y1) {
//        this.coordenadaX1Y1 = coordenadaX1Y1;
//    }

    /**
     * Obtiene la coordenada del centro del Estado de acuerdo a la posición
     * en la que esta con respecto al lienzo.
     * @return La coordenada (X,Y) del centro del estado.
     */
    public Point getCentroXY() {
        return centroXY;
    }

//    /**
//     * Establece la coordenada del centro del Estado de acuerdo a la posición
//     * en la que esta con respecto al lienzo.
//     * @param centroXY Coordenada (X,Y) que será la posición del centro del
//     * estado.
//     */
//    public void setCentroXY(Point centroXY) {
//        this.centroXY = centroXY;
//    }

    /**
     * Obtiene un arreglo de Point's con la posición de los puntos donde se
     * encuentran los puertos a los que pueden llegar o salir las transiciones.
     * @return Arreglo de <code>Point</code> con las coordenadas de los 16 puntos.
     */
    public Point[] getPuertos() {
        return puertos;
    }

//    /**
//     * Estable un arreglo de Point's con la posición de los puntos donde se
//     * encuentran los puertos a los que pueden llegar o salir las transacciones.
//     * @param puertos Arreglo de tamaño 16 que contiene <code>Point</code> con
//     * las coordenadas de los puertos de salida o entrada de alguna Transaccion.
//     */
//    public void setPuertos(Point[] puertos) {
//        this.puertos = puertos;
//    }

    /**
     * Obtiene la etiqueta (Nombre) del estado en cuestión.
     * @return Nombre del <code>Estado</code>.
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Establece la etiqueta (Nombre) del estado en cuestión.
     * @param etiqueta Nombre del <code>Estado</code>.
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Verifica si el estado está exitado en ese momento. Si lo está retorna
     * un <code>True</code>, sino retorna un <code>False</code>
     * @return Estatus del <code>Estado</code>.
     */
    public boolean isExitado() {
        return exitado;
    }

    /**
     * Establece un estatus para la propiedad de exitación del estado. Si es un
     * <code>True</code> entonces el <code>Estado</code> está exitado y si es
     * <code>False</code> indicará que el <code>Estado</code> no está exitado.
     * @param exitado
     */
    public void setExitado(boolean exitado) {
        this.exitado = exitado;
    }

    /**
     * Verifica si el <code>Estado</code> esta siendo movido por el puntero del
     * ratón.
     * @return <code>true</code> si está siendo movido, y <code>false</code> si
     * no está siendo movido.
     */
    public boolean isMoving(){
        return moving;
    }

    /**
     * Establece el estatus de movimiento para el <code>Estado</code>.
     * @param moving Representa el movimiento del <code>Estado</code>, y deberá
     * ser <code>true</code> si está siendo movido, y <code>false</code> si
     * no está siendo movido.
     */
    public void setMoving(boolean moving){
        this.moving = moving;
    }

    public boolean isBloqueado(){
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado){
        this.bloqueado = bloqueado;
    }

    /**
     * Si tiene todos los parametros retorna una breve descripción de la etiqueta,
     * y las coordenadas principales del estado, si algun dato es <code>null</code>
     * entonces retorna el metodo <code>toString()</code> tal cual lo define la
     * clase <code>Object</code>.
     * @return Una descripción del estado.
     */
    @Override
    public String toString(){
        try{
            return String.format("Etiqueta: %1$s%nXY: [%2$d,%3$d]%nX1Y: [%4$d,%5$d]%nXY1: [%6$d,%7$d]%nX1Y1: [%8$d,%9$d]%nCentro: [%10$d,%11$d]%n",
                             etiqueta,
                             coordenadaXY.x, coordenadaXY.y,
                             coordenadaX1Y.x, coordenadaX1Y.y,
                             coordenadaXY1.x, coordenadaXY1.y,
                             coordenadaX1Y1.x, coordenadaX1Y1.y,
                             centroXY.x, centroXY.y);
        }catch(NullPointerException ex){
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
        }
    }

}
