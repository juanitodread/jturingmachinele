/**
 *
 * @author Juan Sandoval
 */

package com.jturingmachinele.graphics.estados;

import com.jturingmachinele.graphics.ObjetoGrafico;
import java.awt.Point;
import java.io.Serializable;

public abstract class Estado extends ObjetoGrafico implements Serializable {
    private Point coordenadaXY, coordenadaX1Y, coordenadaXY1, coordenadaX1Y1, centroXY;
    private Point[] puertos;
    private static final int RADIO = 25;
    private String etiqueta;
    private boolean exitado = false;

    public void delimitarArea(){
        coordenadaX1Y.setLocation(coordenadaXY.getX() + 2 * RADIO, coordenadaXY.getY());
        coordenadaXY1.setLocation(coordenadaXY.getX(), coordenadaXY.getY() + 2 * RADIO);
        coordenadaX1Y1.setLocation(coordenadaXY.getX() + 2 * RADIO, coordenadaXY.getY() + 2 * RADIO);
        centroXY.setLocation(coordenadaXY.getX() + RADIO, coordenadaXY.getY() + RADIO);
    }
    
    public void formarPuertos(){
        
    }

    public abstract void exitar();

    public abstract void desexitar();

    public Point getCoordenadaXY() {
        return coordenadaXY;
    }

    public void setCoordenadaXY(Point coordenadaXY) {
        this.coordenadaXY = coordenadaXY;
    }

    public Point getCoordenadaX1Y() {
        return coordenadaX1Y;
    }

    public void setCoordenadaX1Y(Point coordenadaX1Y) {
        this.coordenadaX1Y = coordenadaX1Y;
    }

    public Point getCoordenadaXY1() {
        return coordenadaXY1;
    }

    public void setCoordenadaXY1(Point coordenadaXY1) {
        this.coordenadaXY1 = coordenadaXY1;
    }

    public Point getCoordenadaX1Y1() {
        return coordenadaX1Y1;
    }

    public void setCoordenadaX1Y1(Point coordenadaX1Y1) {
        this.coordenadaX1Y1 = coordenadaX1Y1;
    }

    public Point getCentroXY() {
        return centroXY;
    }

    public void setCentroXY(Point centroXY) {
        this.centroXY = centroXY;
    }

    public Point[] getPuertos() {
        return puertos;
    }

    public void setPuertos(Point[] puertos) {
        this.puertos = puertos;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean isExitado() {
        return exitado;
    }

    public void setExitado(boolean exitado) {
        this.exitado = exitado;
    }
}
