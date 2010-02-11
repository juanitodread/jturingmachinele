/*
 * @(#)Lienzo.java	1.0 26/01/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */
package com.jturingmachinele.visual.componentes;

import com.jturingmachinele.graphics.ObjetoGrafico;
import com.jturingmachinele.graphics.estados.Estado;
import com.jturingmachinele.graphics.estados.EstadoInicial;
import com.jturingmachinele.graphics.transiciones.Transicion;
import com.jturingmachinele.util.IMemento;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Clase que representa un lienzo para pintar en el las máquinas de turing.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class Lienzo extends JPanel implements IMemento{

    private ArrayList<ObjetoGrafico> objetosGraficos;
    private CaretakerLienzo caretaker;
    //private EstadoInicial estadoInicial;
    /**
     * Crea el lienzo y lo configura con ciertas propiedades de inicio.
     */
    public Lienzo(){
        objetosGraficos = new ArrayList<ObjetoGrafico>();
        objetosGraficos.add(EstadoInicial.getInstancia());
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(1330, 1000));
        setPreferredSize(new Dimension(1330, 1000));
        setAutoscrolls(true);
        caretaker = new CaretakerLienzo();
    }

    /**
     * Pinta los objetos graficos en el lienzo.
     * @param g Objeto de tipo Graphics que permite dibujar gráficos.
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.scale(1.0, 1.0);
        g2d.setStroke (new BasicStroke(1.5f));
        for(ObjetoGrafico obj : objetosGraficos){
            obj.dibujar(g2d);
        }
    }

    /**
     * Obtiene un memento del <code>Lienzo</code> actual.
     * @return
     */
    public Object getMemento() {
        return new MementoLienzo(objetosGraficos);
    }

    /**
     * Establece un memento del <code>Lienzo</code> actual.
     * @param memento
     */
    public void setMemento(Object memento) {
        MementoLienzo obj = (MementoLienzo) memento;
        this.objetosGraficos = obj.objetosGraficos;
    }

    /**
     * Restaura el lienzo a su memento anterior.
     */
    public void deshacer() {
        setMemento(caretaker.deshacer());
        repaint();
    }

    /**
     * Recorre el lienzo a su memento próximo.
     */
    public void rehacer() {
        setMemento(caretaker.rehacer());
        repaint();
    }

    /**
     * Obtiene una lista con los objetos graficos dibujados en el <code>Lienzo</code>.
     * @return the listaObjetosGraficos.
     */
    public ArrayList<ObjetoGrafico> getObjetosGraficos() {
        return objetosGraficos;
    }

    /**
     *
     * @param obj
     */
    public void setObjetosGraficos(ArrayList<ObjetoGrafico> obj){
        objetosGraficos = obj;
        repaint();
    }

    /**
     * Agrega un <code>ObjetoGrafico</code> al lienzo para que pueda ser dibujado.
     * @param obj Objeto grafico que será dibujado en el lienzo.
     */
    public void setObjetoGrafico(ObjetoGrafico obj){
        objetosGraficos.add(obj);
        caretaker.addMemento((MementoLienzo) getMemento());
        repaint();
    }

    /**
     * Determina si el memento actual es el memento mas reciente del estado del
     * lienzo.
     * @return <code>True</code> si es el memento más reciente, y <code>False</code>
     * si no es el memento más reciente.
     */
    public boolean isMementoMaximo(){
        return (caretaker.isMementoMaximo() ? true : false);
    }

    /**
     * Determina si el memento actual es el memento mas viejo del estado del
     * Lienzo.
     * @return <code>True</code> si es el memento más viejo, y <code>False</code>
     * si no es el memento más viejo.
     */
    public boolean isMementoMinimo(){
        return (caretaker.isMementoMinimo() ? true : false);
    }

    /**
     * Elimina una transición del Lienzo.
     * @param etiqueta Es la etiqueta que tendrá la transición que se quiere
     * eliminar.
     */
    public void eliminarTransicion(String etiqueta){
        String nombre = null;
        for(ObjetoGrafico obj : objetosGraficos){
            nombre = obj.getClass().getSimpleName();
            if("TransicionArco".equals(nombre) ||
               "TransicionCiclo".equals(nombre) ||
               "TransicionRecta".equals(nombre)){
               Transicion aux = (Transicion) obj;
               if(aux.getEtiqueta().equals(etiqueta)){
                   objetosGraficos.remove(obj);
                   break;
               }
            }
        }
        caretaker.addMemento((MementoLienzo) getMemento());
        repaint();
    }

    /**
     * Elimina un estado del Lienzo.
     * @param etiqueta Es la etiqueta que tendrá el estado que se quiere
     * eliminar.
     */
    public void eliminarEstado(String etiqueta){
        String nombre = null;
        for(ObjetoGrafico obj : objetosGraficos){
            nombre = obj.getClass().getSimpleName();
            if("EstadoFinal".equals(nombre) ||
               "EstadoTransitivo".equals(nombre) ){
               Estado aux = (Estado) obj;
               if(aux.getEtiqueta().equals(etiqueta)){
                   objetosGraficos.remove(obj);
                   nombre = null;
                   break;
               }
            }
        }
        int j = -1;
        while(j < objetosGraficos.size()-1){
            j++;
            nombre = objetosGraficos.get(j).getClass().getSimpleName();
            if("TransicionArco".equals(nombre) ||
               "TransicionCiclo".equals(nombre) ||
               "TransicionRecta".equals(nombre)){
                Transicion  auxTran=(Transicion)objetosGraficos.get(j);
                if(auxTran.getNodoInicial().getEtiqueta().equals(etiqueta) ||
                auxTran.getNodoFinal().getEtiqueta().equals(etiqueta)){
                    objetosGraficos.remove(j);
                    j=-1;
                }
            }
        }
        caretaker.addMemento((MementoLienzo) getMemento());
        repaint();
    }
    /**
     * Limpia el lienzo, elimina todos los objetos que contiene.
     */
    public void limpiar(){
        objetosGraficos = new ArrayList<ObjetoGrafico>();
        caretaker = new CaretakerLienzo();
        objetosGraficos.add(EstadoInicial.getInstancia());
        repaint();
    }

}
