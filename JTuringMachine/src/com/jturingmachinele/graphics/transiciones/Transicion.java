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
 * @(#)Transicion.java	1.0 22/01/2010
 *
 */
package com.jturingmachinele.graphics.transiciones;

import com.jturingmachinele.graphics.ObjetoGrafico;
import com.jturingmachinele.graphics.estados.Estado;
import java.awt.Point;
import java.io.Serializable;
import java.util.Observer;

/**
 * Clase que representa una <code>Transicion</code>, para representar
 * el movimiento de una máquina de turing.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public abstract class Transicion extends ObjetoGrafico implements Serializable, Observer {

    private static final long serialVersionUID = 1l;
    private Estado nodoInicial, nodoFinal;
    private String etiqueta;
    private boolean retorno = false;

    /**
     * Crea una instancia de una <code>Transicion</code>.
     * @param nodoInicial Estado de donde partirá la transición.
     * @param nodoFinal Estado al que llegará la transición.
     * @param etiqueta Etiqueta de la transición
     */
    public Transicion(Estado nodoInicial, Estado nodoFinal, String etiqueta){
        this.nodoInicial = nodoInicial;
        this.nodoFinal = nodoFinal;
        this.etiqueta = etiqueta;
    }

    /**
     * Obtiene los puertos de donde inicia la transición hasta donde termina.
     * El primer valor es el puerto del estado de incio y el segundo
     * es el valor del puerto del estado final.
     * @return Un arreglo con dos valores, el puerto del estado inicial y
     * el puerto del estado final respectivamente.
     */
    public short[] getPuertos(){
        short[] resultado = new short[2];//Devuelo los dos puertos
        Point[] ini = getNodoInicial().getPuertos();
        Point[] fin = getNodoFinal().getPuertos();
        float[] distanciaNodo = new float[16];//Distancia de un puerto a todos los demas
        float[][] matriz = new float[16][2];//Matriz de tipo [posicionFinal][Distancia]

        for(int i = 0; i < ini.length; i++){
            for(int j = 0; j < fin.length; j++){
                distanciaNodo[j] = (float) Math.sqrt( Math.pow(Math.abs(fin[j].x - ini[i].x), 2)
                                                    + Math.pow(Math.abs(fin[j].y - ini[i].y), 2));
            }
            matriz[i][1] = getPuntoMenor(distanciaNodo[0], distanciaNodo[1],
                                         distanciaNodo[2], distanciaNodo[3],
                                         distanciaNodo[4], distanciaNodo[5],
                                         distanciaNodo[6], distanciaNodo[7],
                                         distanciaNodo[8], distanciaNodo[9],
                                         distanciaNodo[10], distanciaNodo[11],
                                         distanciaNodo[12], distanciaNodo[13],
                                         distanciaNodo[14], distanciaNodo[15]);
            for(int k = 0; k < distanciaNodo.length; k++){
                if(matriz[i][1] == distanciaNodo[k]){
                    matriz[i][0] = k;
                    break;
                }
            }
        }
        float aux = getPuntoMenor(matriz[0][1], matriz[1][1], matriz[2][1], matriz[3][1],
                                  matriz[4][1], matriz[5][1], matriz[6][1], matriz[7][1],
                                  matriz[8][1], matriz[9][1], matriz[10][1], matriz[11][1],
                                  matriz[12][1], matriz[13][1], matriz[14][1], matriz[15][1]);
        for(int i = 0; i < distanciaNodo.length; i++){
            if(aux == matriz[i][1]){
                resultado[0] = (short) i;
                resultado[1] = (short) matriz[i][0];
            }
        }
        return resultado;
    }

    /**
     * Obtiene el punto más chico de entre 16 posibles.
     * @param _1 Punto 1
     * @param _2 Punto 2
     * @param _3 Punto 3
     * @param _4 Punto 4
     * @param _5 Punto 5
     * @param _6 Punto 6
     * @param _7 Punto 7
     * @param _8 Punto 8
     * @param _9 Punto 9
     * @param _10 Punto 10
     * @param _11 Punto 11
     * @param _12 Punto 12
     * @param _13 Punto 13
     * @param _14 Punto 14
     * @param _15 Punto 15
     * @param _16 Punto 16
     * @return El valor más pequeño de entre los 16.
     */
    private float getPuntoMenor(float _1, float _2, float _3, float _4, float _5, float _6,
                             float _7, float _8, float _9, float _10, float _11, float _12,
                             float _13, float _14, float _15, float _16){
        return Math.min(_1, Math.min(_2, Math.min(_3, Math.min(_4, Math.min(_5,
               Math.min(_6, Math.min(_7, Math.min(_8, Math.min(_9, Math.min(_10,
               Math.min(_11, Math.min(_12, Math.min(_13, Math.min(_14, Math.min(_15,_16)))))))))))))));
    }

    public int getCuadranteNodoFin(Point inicio, Point fin){
        int cuadrante =0;

        if(fin.getX()>=inicio.getX() && fin.getY()<=inicio.getY()){
            cuadrante = 1;
        }else{
            if(fin.getX()<=inicio.getX() && fin.getY()<=inicio.getY()){
                cuadrante = 2;
            }else{
                if(fin.getX()<=inicio.getX() && fin.getY()>=inicio.getY()){
                    cuadrante = 3;
                }else{
                    if(fin.getX()>=inicio.getX() && fin.getY()>=inicio.getY()){
                        cuadrante = 4;
                    }
                }
            }
        }
        return cuadrante;
    }
    
    /**
     * Obtiene el
     * @return the nodoInicial
     */
    public Estado getNodoInicial() {
        return nodoInicial;
    }

    /**
     * @param nodoInicial the nodoInicial to set
     */
    public void setNodoInicial(Estado nodoInicial) {
        this.nodoInicial = nodoInicial;
    }

    /**
     * @return the nodoFinal
     */
    public Estado getNodoFinal() {
        return nodoFinal;
    }

    /**
     * @param nodoFinal the nodoFinal to set
     */
    public void setNodoFinal(Estado nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * @return the retorno
     */
    public boolean isRetorno() {
        return retorno;
    }

    /**
     * @param retorno the retorno to set
     */
    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

}
