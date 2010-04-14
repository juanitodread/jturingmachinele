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
    private float escala = 1.0F;
    private boolean vistaPrevia = false;

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
        g2d.scale(escala, escala);
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
        Transicion tran = getTransicion(etiqueta);
        if(tran != null){
            objetosGraficos.remove(tran);
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
        Estado est = getEstado(etiqueta);
        if(est != null){
            for(Transicion tran : getTransicionesDeEstado(etiqueta)){
                objetosGraficos.remove(tran);
            }
            objetosGraficos.remove(est);
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

    /**
     * Bloquea los estados que no se están arrastrando para que si pasa por encima
     * no los tome en cuenta el ratón.
     * @param estado Estado que no se bloqueará debido a que es el estado que está
     * siendo arrastrado.
     */
    public void bloquearEstados(Estado estado){
        for(Estado est : getEstados()){
            if(!estado.equals(est)){
                est.setBloqueado(true);
            }
        }
    }

    /**
     * Obtiene un estado por su etiqueta, si no se encuentra retorna un null.
     * @param etiqueta
     * @return El estado que se quiere obtener
     */
    public Estado getEstado(String etiqueta){
        Estado est = null;
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getName().contains("Estado")){
                Estado estAux = (Estado) obj;
                if(estAux.getEtiqueta().equals(etiqueta)){
                    est = estAux;
                    return est;
                }
            }
        }
        return est;
    }

     /**
     * Obtiene una transicion por su etiqueta, si no se encuentra retorna un null.
     * @param etiqueta
     * @return La transicion que se quiere obtener
     */
    public Transicion getTransicion(String etiqueta){
        Transicion tran = null;
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getName().contains("Transicion")){
                Transicion tranAux = (Transicion) obj;
                if(tranAux.getEtiqueta().equals(etiqueta)){
                    tran = tranAux;
                    return tran;
                }
            }
        }
        return tran;
    }

    /**
     * Obtiene todas las transiciones correspondientes a un estado
     * @param etiquetaEstado Etiqueta del estado
     * @return Una lista con todas las transiciones de ese estado
     */
    public ArrayList<Transicion> getTransicionesDeEstado(String etiquetaEstado){
        ArrayList<Transicion> transiciones = new ArrayList<Transicion>();
        Estado est = getEstado(etiquetaEstado);
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getName().contains("Transicion")){
                Transicion tranAux = (Transicion)obj;
                if(est.equals(tranAux.getNodoInicial()) || est.equals(tranAux.getNodoFinal())){
                    transiciones.add(tranAux);
                }
            }
        }
        return transiciones;
    }

    /**
     * Obtiene todos los estados del lienzo.
     * @return Una lista con todos los estados, si no hay ninguno retorna null
     */
    public ArrayList<Estado> getEstados(){
        ArrayList<Estado> estados = new ArrayList<Estado>();
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getSuperclass() == Estado.class){
                Estado estAux = (Estado) obj;
                estados.add(estAux);
            }
        }
        return estados;
    }

     /**
     * Obtiene todas las transiciones del lienzo.
     * @return Una lista con todas las transiciones, si no hay ninguna retorna null
     */
    public ArrayList<Transicion> getTransiciones(){
        ArrayList<Transicion> transiciones = new ArrayList<Transicion>();
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getSuperclass() == Transicion.class){
                Transicion tranAux = (Transicion) obj;
                transiciones.add(tranAux);
            }
        }
        return transiciones;
    }

    /**
     * Obtiene el estado que esta seleccionado por el cursor. Si no hay ninguno
     * retorna null
     * @param x Posicion x del cursor
     * @param y Posición y del cursor
     * @return El estado
     */
    public Estado getEstadoSeleccionado(int x, int y){
        Estado est = null;
        for(ObjetoGrafico obj : objetosGraficos){
            if(obj.getClass().getName().contains("Estado")){
                Estado estAux = (Estado) obj;
                if(estAux.isFlotando(x, y)){
                    est = estAux;
                    return est;
                }
            }
        }
        return est;
    }

    /**
     * Obtiene la escala del lienzo
     * @return escala actual del lienzo
     */
    public float getEscala() {
        return escala;
    }

    /**
     * Establece la escala para el lienzo [0.1 a 2.0]
     * @param escala La escala que se quiere establece [minimo = 0.1]
     * [máximo = 2.0]
     */
    public void setEscala(float escala) {
        this.escala = escala;
        this.repaint();
    }

    /**
     * Verifica si el lienzo está en modo vista previa, si es así, entonces
     * el lienzo no escuchara ningun evento.
     * @return True o False dependiendo del modo en que esté el lienzo.
     */
    public boolean isVistaPrevia() {
        return vistaPrevia;
    }

    /**
     * Establece si el lienzo está en vista previa o no. Si es así, entonces
     * el lienzo no escuchara ningun evento.
     * @param vistaPrevia True para indicar al lienzo que se mantenga en vista
     * previa, false para que se comporte normalmente.
     */
    public void setVistaPrevia(boolean vistaPrevia) {
        this.vistaPrevia = vistaPrevia;
    }

}
