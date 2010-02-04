/*
 * @(#)ExtencionArchivo.java	1.0 04/02/2010
 *
 * TODOS LOS DERECHOS RESERVADOS PARA LOS DESARROLLADORES DEL PROYECTO jTuringMachine.
 */

package com.jturingmachinele.util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que filtra las extenciones para los archivos que maneja jTuringMachine.
 *
 * @author Juan Sandoval
 * @version 1.0
 */
public class ExtencionArchivo extends FileFilter {
    FileFilter obj;
    /**
     * Determina si el <code>archivo</code> es aceptado por el filtro del
     * <code>JFileChooser</code>.
     * @param archivo Archivo que se validará para saber si es aceptado o no.
     * @return <code>true</code> Si el archivo es válido, es decir tiene una
     * extencion de tipo (*.jtmx) y <code>false</code> si
     * no lo es.
     */
    public boolean accept(File archivo){
        if(archivo.isDirectory()){
            return true;
        }
        String nameArchivo = archivo.getName();
        int i = nameArchivo.lastIndexOf(".");
        if(i > 0 && i < nameArchivo.length() - 1){
            if(nameArchivo.substring(i+1).toLowerCase().equals("jtmx")){
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la descripción del filtro, es decir, los archivos que son
     * válidos para el filtro.
     * @return Cadena con una breve descripción de los archivos válidos por
     * jTuringMachine.
     */
    public String getDescription(){
        return ".jtmx | Archivo de datos de las máquinas de Turing creadas.";
    }
}
