/*
 *@(#)TransicionArco.java	1.0 13/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.graphics.transiciones;

import com.jturingmachinele.graphics.estados.Estado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.QuadCurve2D;
import java.io.Serializable;
import java.util.Observable;

/**
 * Clase que representa una <code>TransicionArco</code>, para representar
 * el movimiento de una máquina de turing en forma curva.
 *
 * @author Marcela Sena
 * @version 1.0
 */

public class TransicionArco extends Transicion implements Serializable {

    private static final long serialVersionUID = 1l;
    /**
     * Tamaño de la punta de la flecha en pixeles
     */
    public static final int TAMANIO_FLECHA = 10;
    /**
     * Angulo que forman las dos rectas de la flecha.
     */
    public static final double ANGULO_FLECHA = Math.PI / 6;
    /**
     * Tamaño que se le da a la curvatura en pixeles.
     */
    public static final int CURVATURA = 50;
    /**
     * Limite e inicio de los puertos dados a un nodo.
     */
    public static final int LIMITE_PUERTOS = 15;
    
    public static final int INICIO_PUERTOS = 0;
    /**
     * Límite e inicio para la curva de retorno.
     */    
    public static final int LIMITE_RETORNO = 14;
    
    public static final int INICIO_RETORNO = 2;

     /**
     * Crea una <code>TransicionArco</code>
     * @param nodoInicial Estado de donde partirá la transición
     * @param nodoFinal Estado a donde llegará la transición.
     * @param etiqueta Etiqueta que mostrará la transición
     */

    public TransicionArco(Estado nodoInicial, Estado nodoFinal, String etiqueta){
        super(nodoInicial, nodoFinal, etiqueta);
    }

     /**
     * Dibuja una <code>TransicionArco</code> de un estado a otro con su etiqueta.
     * @param g Objeto para dibujar graficos en el lienzo.
     */

   @Override
    public void dibujar(Graphics g) {
        g.setColor(Color.BLACK);
        Graphics2D g2d = (Graphics2D)g;
        QuadCurve2D.Double curva = new QuadCurve2D.Double();
        Point inicio = null, curvatura = null, fin = null;

        Point[] puertosInicial = this.getNodoInicial().getPuertos();
        Point[] puertosFinal = this.getNodoFinal().getPuertos();
        short[] puertos = this.getPuertos();
        int puertosInicio = puertos[0], puertosFin = puertos[1];

        inicio = new Point (puertosInicial[puertosInicio].x, puertosInicial[puertosInicio].y);
        fin = new Point (puertosFinal[puertosFin].x, puertosFinal[puertosFin].y);

        if((puertosInicial[puertosInicio].x != puertosFinal[puertosFin].x) ||
           (puertosInicial[puertosInicio].y != puertosFinal[puertosFin].y)){

            /*
            * Se especifica si la transición es de retorno, se obtiene el
            * cuadrante del nodo final con respecto al nodo inicial y se aplica
            * el algoritmo para establecer un arco de retorno.
            */

            if(TransicionArco.super.isRetorno()){
                int cuadrante = this.getCuadranteNodoFin(inicio, fin);
                if(cuadrante == 1){
                  puertosInicio = puertos[0]+INICIO_RETORNO > LIMITE_PUERTOS  ?
                                  INICIO_RETORNO : puertos[0]+INICIO_RETORNO;
                  puertosFin = puertos[1]-INICIO_RETORNO < INICIO_PUERTOS ?
                               LIMITE_RETORNO : puertos[1]-INICIO_RETORNO;
                 }else{
                    if(cuadrante == 2){
                       puertosInicio = puertos[0]-INICIO_RETORNO < INICIO_PUERTOS ?
                                       LIMITE_RETORNO : puertos[0]-INICIO_RETORNO;
                       puertosFin = puertos[1]+INICIO_RETORNO > LIMITE_PUERTOS ?
                                    INICIO_RETORNO : puertos[1]+INICIO_RETORNO;
                     }else{
                          if(cuadrante == 3){
                              puertosInicio = puertos[0]-INICIO_RETORNO < INICIO_PUERTOS ?
                                              LIMITE_RETORNO : puertos[0]-INICIO_RETORNO;
                              puertosFin = puertos[1]+INICIO_RETORNO > LIMITE_PUERTOS ?
                                           INICIO_RETORNO : puertos[1]+INICIO_RETORNO;
                           }else{
                              if(cuadrante == 4){
                                puertosInicio = puertos[0]+INICIO_RETORNO > LIMITE_PUERTOS ?
                                                INICIO_RETORNO : puertos[0]+INICIO_RETORNO;
                                puertosFin = puertos[1]-INICIO_RETORNO < INICIO_PUERTOS ?
                                             LIMITE_RETORNO : puertos[1]-INICIO_RETORNO;
                               }
                            }
                         }
                     }
                inicio = new Point (puertosInicial[puertosInicio].x,
                                    puertosInicial[puertosInicio].y);
                fin = new Point (puertosFinal[puertosFin].x,
                                 puertosFinal[puertosFin].y);
                 }
            curvatura = getPuntoCurvatura( inicio, fin );
            curva.setCurve(inicio,curvatura,fin);
            g2d.draw(curva);

            dibujarFlecha(g, (int) curvatura.getX(), (int)curvatura.getY(),
                    puertosFinal[puertosFin].x, puertosFinal[puertosFin].y);
            dibujarEtiqueta(g,curvatura, inicio);
        }

    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void dibujarFlecha(Graphics g, int x1, int y1, int x2, int y2){
        //Obtenemos la variacion de x y y
        double dY = - (y1 - y2) * 1.0;
        double dX = (x1 - x2) * 1.0;
        //Obtenemos el angulo Tetha con respecto al horizonte del plano
        float tetha = (float) Math.atan(dY / dX);
        //Si la variacion de x es negativa sumamos un PI (180º)
        if(dX < 0){
            tetha += Math.PI;
        }
        Point verticeIzq, verticeDer;
        //Obtenemos los valores de los puntos donde se dibujaran las lineas que conforman la flecha
        verticeIzq = new Point((int)(x2 + TransicionArco.TAMANIO_FLECHA * Math.cos(tetha - ANGULO_FLECHA)),
                               (int)(y2 - TransicionArco.TAMANIO_FLECHA * Math.sin(tetha - ANGULO_FLECHA)));
        verticeDer = new Point((int)(x2 + TransicionArco.TAMANIO_FLECHA * Math.cos(tetha + ANGULO_FLECHA)),
                               (int)(y2 - TransicionArco.TAMANIO_FLECHA * Math.sin(tetha + ANGULO_FLECHA)));
        //Dibujamos las dos lineas para hacer la flecha
        g.drawLine(verticeIzq.x, verticeIzq.y, x2, y2);
        g.drawLine(verticeDer.x, verticeDer.y, x2, y2);
    }

    private void dibujarEtiqueta(Graphics g, Point punto, Point inicio){
        int cuadrante = this.getCuadranteNodoFin(inicio,punto);
        if(cuadrante==1){
            g.drawString(getEtiqueta(),(int) punto.getX() - 10,(int) punto.getY() );
        }else{
            if(cuadrante==2){
               g.drawString(getEtiqueta(),(int) punto.getX() + 10,(int) punto.getY() );
            }
            else{
                if(cuadrante==3){
                    g.drawString(getEtiqueta(),(int) punto.getX() - 10,(int) punto.getY() );
                }else{
                    if(cuadrante==4){
                        g.drawString(getEtiqueta(),(int) punto.getX() + 10,(int) punto.getY() );
                    }
                }
            }
        }
        
    }

    /**
     * Obtiene el punto de curvatura para dibujar el arco de una <code>TransicionArco</code>
     * @param inicio Punto en el que saldrá la curva, de tipo Point
     * @param fin Punto al que llegará la curva, de tipo Point
     * @return putoCurvatura Punto en el que se formará la curvatura, de tipo Point
     */

    private Point getPuntoCurvatura(Point inicio, Point fin){
        int xCurva;
        int yCurva;
        Point puntoMedio = null;
        Point puntoCurvatura = null;        

        //Se obtiene el punto medio entre el punto inicial y final
        yCurva = (int) (Math.abs(inicio.getY() + fin.getY())/2);
        xCurva = (int) (Math.abs(inicio.getX() + fin.getX())/2);
        puntoMedio= new Point (xCurva,yCurva);

        //Se obtiene el ángulo Tetha en referencia al punto medio y la curvatura
        //que se le quiera dar
        double dY = - (puntoMedio.getY() - fin.getY()) * 1.0;
        double dX = (puntoMedio.getX() - fin.getX()) * 1.0;
        float tetha = (float) Math.atan(dY / dX);

        //Se obtiene la distancia opuesta y adyacente al angulo Tetha
        int distOpuesta = (int) Math.abs(CURVATURA * Math.sin(tetha));
        int distAdyacente = (int) Math.abs(CURVATURA * Math.cos(tetha));

        //Dependiendo del cuadrante se suma o resta la distancia opuesta o adyacente
        int cuadrante = this.getCuadranteNodoFin(inicio,fin);
        if(cuadrante==1){
            if(TransicionArco.super.isRetorno()){
              puntoCurvatura = new Point((int)puntoMedio.getX() + distOpuesta,
                                         (int)puntoMedio.getY() + distAdyacente);
            }else
            puntoCurvatura = new Point((int)puntoMedio.getX() - distOpuesta,
                                       (int)puntoMedio.getY() - distAdyacente);
        }else{
            if(cuadrante==2){
                if(TransicionArco.super.isRetorno()){
                  puntoCurvatura = new Point((int)puntoMedio.getX() - distOpuesta,
                                             (int)puntoMedio.getY() + distAdyacente);
               }else
               puntoCurvatura = new Point((int)puntoMedio.getX() + distOpuesta,
                                          (int)puntoMedio.getY() - distAdyacente);
            }else{
                if(cuadrante==3){
                    if(TransicionArco.super.isRetorno()){
                      puntoCurvatura = new Point((int)puntoMedio.getX() + distOpuesta,
                                                 (int)puntoMedio.getY() + distAdyacente);
                    }else
                    puntoCurvatura = new Point((int)puntoMedio.getX() - distOpuesta,
                                               (int)puntoMedio.getY() - distAdyacente);
                }else{
                    if(cuadrante==4){
                        if(TransicionArco.super.isRetorno()){
                          puntoCurvatura = new Point((int)puntoMedio.getX() - distOpuesta,
                                                     (int)puntoMedio.getY() + distAdyacente);
                        }else
                        puntoCurvatura = new Point((int)puntoMedio.getX() + distOpuesta,
                                                   (int)puntoMedio.getY() - distAdyacente);
                    }
                }
            }
        }
        return puntoCurvatura;
    }
}